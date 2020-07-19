package com.heyoufu.demo.service;

import com.heyoufu.pay.model.SystemService;

import java.util.List;

public interface SystemServiceService {

    /**
     * 查询所有系统服务
     * @return
     */
    List<SystemService> findAll();


}
