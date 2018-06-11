package com.sinosoft.cpyy.controller.index;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sinosoft.cpyy.controller.index.ordervo.OrderVo;
import com.sinosoft.cpyy.dao.AnalyzeResultRegistry;
import com.sinosoft.cpyy.util.voutils.ResponseResult;
import com.sinosoft.cpyy.util.voutils.ResultResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 创建时间：2018/六月/05
 *
 * @author 卢俊宇[lujunyu@sinosoft.com.cn]
 * 类名：IndexController
 * 描述：
 */
@Controller
@Slf4j
public class IndexController {
    /**
     * 当前日期
     */
    private static Calendar calNow = Calendar.getInstance();

    //当前年
    static {
        calNow.setTime(new Date());
    }

    @RequestMapping("/index")
    public String getConsumeInfo() {
        return "index";
    }

    /**
     * 获取专业分布
     *
     * @return 返回专业分布
     */
    @PostMapping("/majorGeomResult")
    @ResponseBody
    public ResponseResult<Object> majorGeomResult() {
        AnalyzeResultRegistry.clearMajorGeomResult();
        AnalyzeResultRegistry.orgResulr.forEach(item -> {
            if (!StringUtils.isNotBlank(item.getMajor())) {
                classifyMajor(null);
            } else {
                classifyMajor(item.getMajor());
            }
        });
        String result = JSON.toJSONString(mapToArrayList(AnalyzeResultRegistry.majorGeomResult));
        return ResultResponseUtils.success(result);
    }

    /**
     * 获得称号年趋势变化
     *
     * @return 返回获得称号年趋势变化
     */
    @PostMapping("/trendDataResult")
    @ResponseBody
    public ResponseResult<Object> trendDataResult() {
        AnalyzeResultRegistry.clearTrendDataResult();
        AnalyzeResultRegistry.orgResulr.forEach(item -> {
            if (!StringUtils.isNotBlank(item.getAppellationTime())) {
                classifyAppellationTime(null);
            } else {
                classifyAppellationTime(item.getAppellationTime());
            }
        });

        //排序
        ArrayList<OrderVo> orderVos = new ArrayList<>();
        AnalyzeResultRegistry.trendDataResult
                .forEach((key, value) -> {
                    OrderVo orderVo = new OrderVo(Integer.valueOf(key), value);
                    orderVos.add(orderVo);
                });
        Collections.sort(orderVos);
        return ResultResponseUtils.success(orderVos);
    }

    /**
     * 获取年龄分布
     *
     * @return 返回年龄分布
     */
    @PostMapping("/ageGeomResult")
    @ResponseBody
    public ResponseResult<Object> ageGeomResult() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy年");
        AnalyzeResultRegistry.clearAgeGeomResult();
        AnalyzeResultRegistry.orgResulr.forEach(item -> {
            try {
                if (!StringUtils.isNotBlank(item.getBirthday())) {
                    classifyAge(null);
                } else {
                    Date birthday = dateFormat.parse(item.getBirthday());
                    classifyAge(birthday);
                }
            } catch (ParseException e) {
                classifyAge(null);
            }
        });
        String result = JSON.toJSONString(mapToArrayList(AnalyzeResultRegistry.ageGeomResult));
        return ResultResponseUtils.success(result);
    }


    //============================私有方法============================

    /**
     * 根据生日进行分类
     *
     * @param major 专业
     */
    private void classifyMajor(String major) {
        // 年龄不详
        if (!StringUtils.isNotBlank(major)) {
            countMajor("专业不详");
            return;
        }
        countMajor(major);
    }

    /**
     * 对传入的分类进行一次计数
     *
     * @param greaterKey 待计数key
     */
    private void countMajor(String greaterKey) {
        Integer greater;
        greater = AnalyzeResultRegistry.majorGeomResult.get(greaterKey);
        if (greater != null) {
            AnalyzeResultRegistry.majorGeomResult.put(greaterKey, ++greater);
        } else {
            AnalyzeResultRegistry.majorGeomResult.put(greaterKey, 1);
        }
    }

    /**
     * 根据获取称号时间进行分类
     *
     * @param appellationTime 获取称号时间
     */
    private void classifyAppellationTime(String appellationTime) {
        // 年龄不详
        if (!NumberUtils.isParsable(appellationTime)) {
            //获取称号时间不详
            countAppellationTime("0");
            return;
        }
        countAppellationTime(appellationTime);
    }

    /**
     * 对传入的分类进行一次计数
     *
     * @param greaterKey 待计数key
     */
    private void countAppellationTime(String greaterKey) {
        Integer greater;
        greater = AnalyzeResultRegistry.trendDataResult.get(greaterKey);
        if (greater != null) {
            AnalyzeResultRegistry.trendDataResult.put(greaterKey, ++greater);
        } else {
            AnalyzeResultRegistry.trendDataResult.put(greaterKey, 1);
        }
    }

    /**
     * 根据生日进行分类
     *
     * @param birthday 生日
     */
    private void classifyAge(Date birthday) {
        // 年龄不详
        if (birthday == null) {
            countAge("年龄不详");
            return;
        }

        // 计算具有年龄的人分布
        Calendar calBegin = Calendar.getInstance();
        calBegin.setTime(birthday);
        int age = calNow.get(Calendar.YEAR) - calBegin.get(Calendar.YEAR);
        if (age > 60) {
            countAge("大于60岁");
            return;
        }
        if (age > 50) {
            countAge("大于50岁小于60岁");
            return;
        }
        if (age > 40) {
            countAge("大于40岁小于50岁");
            return;
        }
        if (age > 30) {
            countAge("大于30岁小于40岁");
            return;
        }
        if (age > 20) {
            countAge("大于20岁小于30岁");
            return;
        }
        if (age > 0) {
            countAge("小于20岁");
        }
    }

    /**
     * 对传入的分类进行一次计数
     *
     * @param greaterKey 待计数key
     */
    private void countAge(String greaterKey) {
        Integer greater;
        greater = AnalyzeResultRegistry.ageGeomResult.get(greaterKey);
        if (greater != null) {
            AnalyzeResultRegistry.ageGeomResult.put(greaterKey, ++greater);
        } else {
            AnalyzeResultRegistry.ageGeomResult.put(greaterKey, 1);
        }
    }

    private ArrayList<JSONObject> mapToArrayList(Map<String, Integer> map) {
        ArrayList<JSONObject> jsonObjects = new ArrayList<>();
        map.forEach((key, item) -> {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", key);
            jsonObject.put("value", item);
            jsonObjects.add(jsonObject);
        });
        return jsonObjects;
    }
}
