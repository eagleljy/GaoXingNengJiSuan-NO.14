package com.sinosoft.cpyy.model.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 创建时间：2018/四月/17
 *
 * @author 张政[zhang_zheng@sinosoft.com.cn]
 * 类名：MongoCollectionEnum
 * 描述：MongoCollectionEnum
 */
@Getter
@AllArgsConstructor
public enum MongoCollectionEnum {
    /**
     * 视频存储信息
     */
    VIDEO_TEMP_INFO("VideoTempInfo");
    private String collectionName;
}
