package com.heyoufu.authserver.service;

import com.heyoufu.pay.common.vo.auth.RegisterUserVO;

public interface RegisterService {

    /**
     * 校验用户名
     */
    void checkUsername(String username) throws Exception;

    /**
     * 校验电子邮箱
     * @param mail
     * @throws Exception
     */
    void checkEmail(String mail) throws Exception;

    /**
     * 校验手机号
     * @param phone
     * @throws Exception
     */
    void checkPhone(String phone) throws Exception;

    /**
     * 获取注册短信验证码
     * @param phone
     * @return
     * @throws Exception
     */
    String smsCode(String phone) throws Exception;

    /**
     * 用户注册
     * @return
     * @throws Exception
     */
    String doRegister(RegisterUserVO registerUserVO) throws Exception;

}
