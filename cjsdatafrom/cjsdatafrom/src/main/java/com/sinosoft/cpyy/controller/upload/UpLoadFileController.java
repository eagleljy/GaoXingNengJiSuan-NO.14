package com.sinosoft.cpyy.controller.upload;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.sinosoft.cpyy.dao.AnalyzeResultRegistry;
import com.sinosoft.cpyy.model.cjsdataperson.CjsdataPerson;
import com.sinosoft.cpyy.model.constant.ExceptionEnum;
import com.sinosoft.cpyy.util.FileServerUUIDUtil;
import com.sinosoft.cpyy.util.voutils.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.sinosoft.cpyy.util.voutils.ResultResponseUtils.error;
import static com.sinosoft.cpyy.util.voutils.ResultResponseUtils.success;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * 创建时间：2018/六月/05
 *
 * @author 卢俊宇[lujunyu@sinosoft.com.cn]
 * 类名：UpLoadFileController
 * 描述：文件上传Controller
 */
@Controller
@Slf4j
public class UpLoadFileController {
    private static final String UPLOAD = "upload";

    /**
     * 内置处理器
     */
    private final StandardServletMultipartResolver standardServletMultipartResolver;

    @Autowired
    public UpLoadFileController(StandardServletMultipartResolver standardServletMultipartResolver) {
        this.standardServletMultipartResolver = standardServletMultipartResolver;
    }

    /**
     * 描述   :上传临时下载文件(多个文件)
     *
     * @return 返回
     */
    @PostMapping(UPLOAD)
    @ResponseBody
    public ResponseResult<Object> uploadTempFiles(HttpServletRequest request) {
        //第一步、判断 request 是否有文件上传,即多部分请求
        MultipartHttpServletRequest multipartAndTransform = null;
        if (standardServletMultipartResolver.isMultipart(request)) {
            multipartAndTransform = standardServletMultipartResolver.resolveMultipart(request);
        }

        //第二步、如果是多部请求则进行处理，否则返回不支持的请求响应
        if (multipartAndTransform == null) {
            return error(ExceptionEnum.UNSUPPORTED_MEDIA_TYPE);
        }

        //从multipartAndTransform保存到本地并添加到needToZipFiles待压缩列表中
        File importFile = transferFileFromMultipart(multipartAndTransform);

        // 文件转换数据模型并持久化到存储仓库中
        AnalyzeResultRegistry.orgResulr = getCjsdataPersonListWithExcle(importFile);

        return success();
    }


    //===================================私有方法===================================

    /**
     * MultipartHttpServletRequest中的文件保存到本地
     *
     * @param multipartAndTransform 请求对象
     */
    private File transferFileFromMultipart(MultipartHttpServletRequest multipartAndTransform) {
        ArrayList<File> uploadTempFiles = new ArrayList<>();
        // 接收到的文件列表
        multipartAndTransform.getMultiFileMap().forEach((key, value) -> {
            if (CollectionUtils.isEmpty(value)) {
                return;
            }
            MultipartFile multipartFile = value.get(0);
            String separatorAndExtension = FilenameUtils.EXTENSION_SEPARATOR + FilenameUtils.getExtension(multipartFile.getOriginalFilename());
            try {
                File file = new File(FileServerUUIDUtil.getUUID() + separatorAndExtension);
                multipartFile.transferTo(file.getAbsoluteFile());
                uploadTempFiles.add(file);
            } catch (IOException e) {
                log.error("上传文件获取异常", e);
            }
        });

        // 只处理批量导入的第一个
        if (uploadTempFiles.isEmpty()) {
            return null;
        } else {
            return uploadTempFiles.get(0);
        }
    }


    /**
     * @param file 带转换文件对象
     * @return 数据转换成的模型
     */
    private static List<CjsdataPerson> getCjsdataPersonListWithExcle(File file) {
        // 导入参数设置
        ImportParams importParams = new ImportParams();
        importParams.setHeadRows(1);
        List<CjsdataPerson> objects = ExcelImportUtil.importExcel(file, CjsdataPerson.class, importParams);

        //过滤姓名为空的导入信息
        return objects.stream()
                .filter(item -> isNotBlank(item.getName()))
                .collect(ArrayList::new, List::add, List::addAll);
    }


}
