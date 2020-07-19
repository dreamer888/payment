package com.heyoufu.pay.common.constant;

/**
 * comms系统接口结果常量枚举类
 * @author comms xuan
 * @date 2020-05-19
 */
public enum ErrorConstant {
    /*************************  通用信息  *********************************************/
    /**
     * 失败
     */
    FAILED(0, "failed"),

    /**
     * 成功
     */
    SUCCESS(200, "success"),
    /**
     * 无效长度
     */
    INVALID_LENGTH(10001, "Invalid length"),
    /**
     * 参数为空
     */
    EMPTY_PARAM(10003, "参数不能为空"),

    /************************* 和账号相关的异常**************************************/
    /**
     * 用户名不能为空
     */
    EMPTY_USERNAME(10101, "Username cannot be empty"),

    /**
     * 密码不能为空
     */
    EMPTY_PASSWORD(10102, "Password cannot be empty"),

    /**
     * 帐号不存在
     */
    INVALID_USERNAME(10103, "Account does not exist"),

    /**
     * 密码错误
     */
    INVALID_PASSWORD(10104, "Password error"),

    /**
     * 无效帐号
     */
    INVALID_ACCOUNT(10105, "Invalid account"),
    /** ***************************** 和 TOKEN 相关的异常说明 ****************************************** */
    /**
     *用户Token过期
     */
    USER_TOKEN_EXPIRED(40101,"User token expired!"),
    /**
     * User token signature error
     * 用户Token 签名错误
     */
    USER_TOKEN_SIGNATURE_ERROR(40102,"User token signature error"),
    /**
     * User token is null or empty!
     * 用户Token 为NULL 或 为空
     */
    USER_TOKEN_EMPTY_ERROR(40103,"User token is null or empty!"),
    /**
     *客户端Token过期
     */
    CLIENT_TOKEN_EXPIRED(40104,"Client token expired!"),
    /**
     * Client token signature error
     * 客户端Token 签名错误
     */
    CLIENT_TOKEN_SIGNATURE_ERROR(40105,"Client token signature error"),
    /**
     * User token is null or empty!
     * 客户端Token 为NULL 或 为空
     */
    CLIENT_TOKEN_EMPTY_ERROR(40106,"Client token is null or empty!"),

    /**
     * Client is Forbidden!
     * 客户端被禁止
     */
    CLIENT_FORBIDDEN_ERROR(40107,"Client is Forbidden!");

    public int code;

    public String message;

    ErrorConstant(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
