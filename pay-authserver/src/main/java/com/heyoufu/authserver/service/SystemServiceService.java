package com.heyoufu.authserver.service;

import com.heyoufu.pay.model.SystemService;

import java.util.List;

public interface SystemServiceService {

    /**
     * 新增系统服务
     * @param systemService
     * @return
     */
    SystemService create(SystemService systemService) throws Exception;

    /**
     * 修改系统服务
     * @param systemService
     * @return
     */
    SystemService update(SystemService systemService);

    /**
     * 查询所有系统服务
     * @return
     */
    List<SystemService> findAll();

    /**
     * 通过服务名模糊查询
     * @param serviceName
     * @return
     */
    SystemService findByName(String serviceName);

}
