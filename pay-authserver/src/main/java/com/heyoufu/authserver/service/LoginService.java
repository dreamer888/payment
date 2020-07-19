package com.heyoufu.authserver.service;

import com.heyoufu.pay.common.vo.auth.AccessTokenVO;
import com.heyoufu.pay.common.vo.auth.FormLoginUserVO;
import com.heyoufu.pay.common.vo.auth.SmsLoginUserVO;

/**
 * xzm 2020-5-18
 */
public interface LoginService {

    /**
     * 表单登录
     * @param user
     * @return
     */
    AccessTokenVO formLogin(FormLoginUserVO user) throws Exception;

    /**
     * 获取登录的短信验证码
     * @param mobile
     * @return
     */
    String smsCode(String mobile) throws Exception;

    /**
     * 短信验证码登录
     * @param user
     * @return
     */
    AccessTokenVO smsLogin(SmsLoginUserVO user) throws Exception;
}
