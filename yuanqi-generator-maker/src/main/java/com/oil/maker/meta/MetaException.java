package com.oil.maker.meta;

/**
 * @author 走肖
 * @version 2.3
 * 元信息异常类
 */
public class MetaException extends RuntimeException {

    public MetaException(String message) {
        super(message);
    }

    public MetaException(String message, Throwable cause) {
        super(message, cause);
    }
}
