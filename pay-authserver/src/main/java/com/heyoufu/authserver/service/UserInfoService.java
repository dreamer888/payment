package com.heyoufu.authserver.service;

import com.heyoufu.pay.model.UserInfo;

import java.util.List;

/**
 * xzm 2020-5-18
 */
public interface UserInfoService {

    /**
     * 通过用户名查询
     * @param username
     * @return
     */
    UserInfo findByUsername(String username);

    /**
     *
     * @param userId
     * @return
     */
    List<String> findRoles(Long userId);

    /**
     * 通过手机号查询
     * @param phone
     * @return
     */
    UserInfo findByPhone(String phone);

    /**
     * 通过电子邮箱查询
     * @param mail
     * @return
     */
    UserInfo findByMail(String mail);

    /**
     * 添加用户信息
     * @param userInfo
     */
    UserInfo add(UserInfo userInfo);


}
