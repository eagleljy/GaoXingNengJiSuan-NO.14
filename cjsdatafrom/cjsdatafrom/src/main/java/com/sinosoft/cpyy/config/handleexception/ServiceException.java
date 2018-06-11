package com.sinosoft.cpyy.config.handleexception;

import com.sinosoft.cpyy.model.constant.ExceptionEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author nicai
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ServiceException extends RuntimeException {

    /**
     * 错误的枚举返回
     */
    private final ExceptionEnum responseEnum;

    /**
     * 补充错误信息
     */
    private final String suffix;

    private static final long serialVersionUID = 1L;

    public ServiceException(ExceptionEnum responseEnum, String suffix) {
        this.responseEnum = responseEnum;
        this.suffix = suffix;


    }

}
