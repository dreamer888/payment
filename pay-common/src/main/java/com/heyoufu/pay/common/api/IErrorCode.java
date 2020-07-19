package com.heyoufu.pay.common.api;

/**
 * 封装API的错误码
 * Created by lgl on 2020/5/7.
 */
public interface IErrorCode {
    long getCode();

    String getMessage();
}
