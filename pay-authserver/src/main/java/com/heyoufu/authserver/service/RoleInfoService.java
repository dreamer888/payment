package com.heyoufu.authserver.service;

import com.heyoufu.pay.model.RoleInfo;

import java.util.List;

public interface RoleInfoService {

    /**
     * 创建角色
     * @param roleInfo
     * @return
     */
    String create(RoleInfo roleInfo) throws Exception;

    /**
     * 查询所有角色
     * @return
     */
    List<RoleInfo> findAll();
}
