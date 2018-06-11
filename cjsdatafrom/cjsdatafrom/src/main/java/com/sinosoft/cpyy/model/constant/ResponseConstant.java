package com.sinosoft.cpyy.model.constant;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "constant.response")
public class ResponseConstant {

    //=================系统响应常量定义=================
    //响应成功
    private String success;
    //响应失败
    private String fail;
    //系统异常500错误
    private String systemError;
}
