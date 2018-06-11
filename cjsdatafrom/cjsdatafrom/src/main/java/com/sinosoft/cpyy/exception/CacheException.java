package com.sinosoft.cpyy.exception;

/**
 * 描述  : 缓存相关的异常
 * 联系人: 张政<zhang_zheng@sinosoft.com.cn>
 */
public class CacheException extends RuntimeException {

    private static final long serialVersionUID = -5112528854998647834L;

    public CacheException(String s) {
        super(s);
    }

    public CacheException(String s, Throwable e) {
        super(s, e);
    }

    public CacheException(Throwable e) {
        super(e);
    }

}
