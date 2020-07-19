package com.heyoufu.pay.common.exception;

import com.heyoufu.pay.common.api.IErrorCode;

/**
 * 断言处理类，用于抛出各种API异常
 * Created by lgl on 2020/5/7.
 */
public class Asserts {
    public static void fail(String message) {
        throw new ApiException(message);
    }

    public static void fail(IErrorCode errorCode) {
        throw new ApiException(errorCode);
    }
}
