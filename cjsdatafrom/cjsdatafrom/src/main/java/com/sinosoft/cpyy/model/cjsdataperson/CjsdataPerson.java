package com.sinosoft.cpyy.model.cjsdataperson;


import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

/**
 * 创建时间：2018/六月/07
 *
 * @author 张政[zhang_zheng@sinosoft.com.cn]
 * 类名：CjsdataPerson
 * 描述：长江学者对象
 */
@Data
public class CjsdataPerson {
    /**
     * 姓名
     */
    @Excel(name = "姓名")
    private String name;

    /**
     * 出生日期
     */
    @Excel(name = "出生日期")
    private String birthday;

    /**
     * 性别
     */
    @Excel(name = "性别")
    private String sex;

    /**
     * 籍贯
     */
    @Excel(name = "籍贯")
    private String nativePlace;

    /**
     * 籍贯位置坐标
     */
    @Excel(name = "籍贯位置坐标")
    private String nativePlaceCoordinate;

    /**
     * 所在单位
     */
    @Excel(name = "所在单位")
    private String organisation;

    /**
     * 所在单位位置坐标
     */
    @Excel(name = "所在单位位置坐标")
    private String organisationCoordinate;

    /**
     * 专业
     */
    @Excel(name = "专业")
    private String major;

    /**
     * 获得称号时间
     */
    @Excel(name = "获得称号时间")
    private String appellationTime;

    /**
     * 获得称号单位
     */
    @Excel(name = "获得称号单位")
    private String appellationOrganisation;

    /**
     * 获得称号单位位置坐标
     */
    @Excel(name = "获得称号单位位置坐标")
    private String appellationCoordinate;

    /**
     * 毕业院校
     */
    @Excel(name = "毕业院校")
    private String graduationAcademy;

    /**
     * 毕业院校位置坐标
     */
    @Excel(name = "毕业院校位置坐标")
    private String graduationAcademyCoordinate;

    /**
     * 毕业时间
     */
    @Excel(name = "毕业时间")
    private String graduationTime;
}
