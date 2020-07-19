package com.heyoufu.authserver.service.impl;

import cn.hutool.core.date.DateTime;
import com.heyoufu.authserver.service.RoleInfoService;
import com.heyoufu.pay.common.constant.Constants;
import com.heyoufu.pay.common.util.Generator;
import com.heyoufu.pay.mapper.RoleInfoMapper;
import com.heyoufu.pay.model.RoleInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleInfoServiceImpl implements RoleInfoService {

    @Autowired
    private RoleInfoMapper roleInfoMapper;

    @Override
    public String create(RoleInfo roleInfo) throws Exception{
        // 判断角色名是否重复
        RoleInfo dbRole = roleInfoMapper.selectByName(roleInfo.getName());
        if (dbRole != null) {
            throw new RuntimeException("角色名重复");
        }
        // 判断角色tag是否重复
        dbRole = roleInfoMapper.selectByTag(roleInfo.getTag());
        if (dbRole != null) {
            throw new RuntimeException("角色标识符重复");
        }
        roleInfo.setId(Generator.getId());
        roleInfo.setStatus(Constants.USER_STATUS_NORMAL);
        roleInfo.setCreateUser(Constants.SYSTEM_USER);
        roleInfo.setCreateTime(new DateTime());
        roleInfo.setUpdateUser(Constants.SYSTEM_USER);
        roleInfo.setUpdateTime(new DateTime());
        roleInfoMapper.insertSelective(roleInfo);
        return "添加成功";
    }

    @Override
    public List<RoleInfo> findAll() {
        return roleInfoMapper.selectAll();
    }
}
