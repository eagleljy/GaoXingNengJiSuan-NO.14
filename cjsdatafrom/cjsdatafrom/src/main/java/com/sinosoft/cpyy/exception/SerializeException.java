package com.sinosoft.cpyy.exception;

/**
 * 描述  : 序列化异常
 * 联系人: 张政<zhang_zheng@sinosoft.com.cn>
 */
public class SerializeException extends RuntimeException {

    private static final long serialVersionUID = -5112528854998647834L;

    public SerializeException(String s) {
        super(s);
    }

    public SerializeException(String s, Throwable e) {
        super(s, e);
    }

    public SerializeException(Throwable e) {
        super(e);
    }

}
