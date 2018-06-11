package com.sinosoft.cpyy.dao;

import com.sinosoft.cpyy.model.cjsdataperson.CjsdataPerson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 创建时间：2018/六月/07
 *
 * @author 张政[zhang_zheng@sinosoft.com.cn]
 * 类名：AnalyzeResultRegistry
 * 描述：分析结果存储仓库
 */
public class AnalyzeResultRegistry {
    private AnalyzeResultRegistry() {
    }

    /**
     * 原始信息存储对象
     */
    public static List<CjsdataPerson> orgResulr = new ArrayList<>();

    /**
     * 年龄分布图存储对象
     */
    public static Map<String, Integer> ageGeomResult = new HashMap<>();

    /**
     * 专业领域分布
     */
    public static Map<String, Integer> majorGeomResult = new HashMap<>();

    /**
     * 信息完善度比例
     */
    public static Map<String, Integer> infoGeomResult = new HashMap<>();

    /**
     * 获得称号年趋势变化
     */
    public static Map<String, Integer> trendDataResult = new HashMap<>();

    public static void clearMajorGeomResult() {
        majorGeomResult = new HashMap<>(3);
    }

    public static void clearAgeGeomResult() {
        ageGeomResult = new HashMap<>(3);
    }

    public static void clearTrendDataResult() {
        trendDataResult = new HashMap<>(3);
    }

}
