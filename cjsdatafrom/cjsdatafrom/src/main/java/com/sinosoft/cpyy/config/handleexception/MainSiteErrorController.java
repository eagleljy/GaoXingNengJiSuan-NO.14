package com.sinosoft.cpyy.config.handleexception;

import com.sinosoft.cpyy.model.constant.ExceptionEnum;
import com.sinosoft.cpyy.util.voutils.ResponseResult;
import com.sinosoft.cpyy.util.voutils.ResultResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

import static org.springframework.http.HttpStatus.*;

/**
 * @author 邱健[qiujian12150@sinosoft.com.cn]
 */
@ControllerAdvice
@Controller
@Slf4j
public class MainSiteErrorController implements ErrorController {
    /**
     * 匹配error并处理
     */
    private static final String ERROR_PATH = "/error";

    //===========================================================================

    /**
     * Date 2017/6/1
     * Author 邱健[qiujian12150@sinosoft.com.cn]
     * <p>
     * 方法说明:本方法处理Exception抛出异常的情况。
     * 注意GET/POST用错了，SpringMVC的处理也是在异常中展示的，因此需要特殊处理一下
     *
     * @param e        传递的最顶级的异常
     * @param response response对象
     * @return 返回响应
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseResult<Object> handle(Exception e, HttpServletResponse response) {
        log.error("\"exceptionMessage\":\"{}\",\"causeBy\":\"{}\"", e.getMessage(), e.getCause().getMessage());
        response.setStatus(HttpStatus.OK.value());
        if (e instanceof HttpRequestMethodNotSupportedException) {
            response.setStatus(METHOD_NOT_ALLOWED.value());
            return handle(response);
        }
        if (e instanceof HttpMessageNotReadableException) {
            response.setStatus(BAD_REQUEST.value());
            return handle(response);
        }
        if (e instanceof HttpMediaTypeNotSupportedException) {
            response.setStatus(UNSUPPORTED_MEDIA_TYPE.value());
            return handle(response);
        }
        if (e instanceof ServiceException) {
            ServiceException serviceException = (ServiceException) e;
            ExceptionEnum exceptionEnum = serviceException.getResponseEnum();

            //打印错误
            log.error("\"exceptionCode\":\"{}\",\"message\":\"{}\"",
                    serviceException.getResponseEnum().getCode(),
                    serviceException.getResponseEnum().getMessage());

            //前端返回
            return ResultResponseUtils.error(exceptionEnum);
        }
        return ResultResponseUtils.error(ExceptionEnum.SYSTEM_FAILURE);
    }

    /**
     * Date 2017/4/30
     * Author 张政[zhang_zheng@sinosoft.com.cn]
     * <p>
     * 方法说明:本方法处理除了500之外的所有异常,
     * 注意405错误是被ExceptionHandler转发调用的
     */
    @ResponseBody
    @RequestMapping(ERROR_PATH)
    public ResponseResult<Object> handle(HttpServletResponse response) {
        ResponseResult<Object> resultResponse;
        //根据不同status返回不同消息
        switch (HttpStatus.valueOf(response.getStatus())) {
            //请检查POST/GET方式
            case METHOD_NOT_ALLOWED:
                resultResponse = ResultResponseUtils.error(ExceptionEnum.METHOD_NOT_ALLOWED);
                break;
            //请检查JSON格式是否规范
            case BAD_REQUEST:
                resultResponse = ResultResponseUtils.error(ExceptionEnum.JSON_DATA_ERROR);
                break;
            //请求头错误
            case UNSUPPORTED_MEDIA_TYPE:
                resultResponse = ResultResponseUtils.error(ExceptionEnum.UNSUPPORTED_MEDIA_TYPE);
                break;
            case NOT_FOUND:
                resultResponse = ResultResponseUtils.error(ExceptionEnum.SERVICE_NOT_FOUND_ERROR);
                break;
            default:
                resultResponse = ResultResponseUtils.error(ExceptionEnum.SYSTEM_FAILURE);
                break;
        }
        //欺骗性质的各种问题均转化为状态置为200
        response.setStatus(HttpStatus.OK.value());
        return resultResponse;
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}