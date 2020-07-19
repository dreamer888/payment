package com.heyoufu.authserver.service.impl;

import cn.hutool.core.date.DateTime;
import com.heyoufu.authserver.service.SystemServiceService;
import com.heyoufu.pay.common.constant.Constants;
import com.heyoufu.pay.common.util.Generator;
import com.heyoufu.pay.mapper.SystemServiceMapper;
import com.heyoufu.pay.model.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SsytemServiceServiceImpl implements SystemServiceService {

    @Autowired
    private SystemServiceMapper systemServiceMapper;

    @Override
    public SystemService create(SystemService systemService) throws Exception{
        SystemService dbSystemService = findByName(systemService.getServiceName());
        if (dbSystemService != null) {
            throw new RuntimeException("当前服务名已存在");
        }
        systemService.setId(Generator.getId());
        systemService.setStatus(Constants.SYSTEM_SERVICE_NORMAL);
        systemService.setCreateUser(Constants.SYSTEM_USER);
        systemService.setCreateTime(new DateTime());
        systemService.setUpdateUser(Constants.SYSTEM_USER);
        systemService.setUpdateTime(new DateTime());
        systemServiceMapper.insertSelective(systemService);
        return systemService;
    }

    @Override
    public SystemService update(SystemService systemService) {
        return null;
    }

    @Override
    public List<SystemService> findAll() {
        return systemServiceMapper.selectAll();
    }

    @Override
    public SystemService findByName(String serviceName) {
        return systemServiceMapper.selectByServiceName(serviceName);
    }
}
