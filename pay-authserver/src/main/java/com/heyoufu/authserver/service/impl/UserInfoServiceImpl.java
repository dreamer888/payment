package com.heyoufu.authserver.service.impl;

import cn.hutool.core.date.DateTime;
import com.heyoufu.authserver.service.UserInfoService;
import com.heyoufu.pay.common.constant.Constants;
import com.heyoufu.pay.common.util.Generator;
import com.heyoufu.pay.mapper.RoleInfoMapper;
import com.heyoufu.pay.mapper.UserInfoMapper;
import com.heyoufu.pay.mapper.UserRoleMapper;
import com.heyoufu.pay.model.RoleInfo;
import com.heyoufu.pay.model.UserInfo;
import com.heyoufu.pay.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * xzm 2020-5-18
 * 用户service
 */
@Transactional
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private RoleInfoMapper roleInfoMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public UserInfo findByUsername(String username) {
        return userInfoMapper.selectByUsername(username);
    }

    @Override
    public List<String> findRoles(Long userId) {
        List<String> roles = new ArrayList<>();
        List<UserRole> userRoles = userRoleMapper.selectByUserId(userId);
        for (UserRole userRole: userRoles) {
            RoleInfo roleInfo = roleInfoMapper.selectByPrimaryKey(userRole.getRoleId());
            // 如果用户拥有的角色中包ROLE_ADMIN, 则把所有角色添加给该用户
            if ("ROLE_ADMIN".equals(roleInfo.getTag())) {
                roles = getAdminRoles();
                break;
            }
            if (roleInfo.getStatus() == Constants.USER_STATUS_NORMAL) {
                roles.add(roleInfo.getTag());
            }
        }
        return roles;
    }

    @Override
    public UserInfo findByPhone(String phone) {
        return userInfoMapper.selectByPhone(phone);
    }

    @Override
    public UserInfo findByMail(String mail) {
        return userInfoMapper.selectByMail(mail);
    }

    @Override
    public UserInfo add(UserInfo userInfo) {
        userInfo.setId(Generator.getId());
        userInfo.setCreateUser(Constants.SYSTEM_USER);
        userInfo.setCreateTime(new DateTime());
        userInfo.setUpdateUser(Constants.SYSTEM_USER);
        userInfo.setUpdateTime(new DateTime());
        userInfoMapper.insertSelective(userInfo);
        return userInfo;
    }

    /**
     * 给超级管理赋予所有角色的权限
     * @return
     */
    private List<String> getAdminRoles() {
        List<String> roles = new ArrayList<>();
        List<RoleInfo> roleInfos = roleInfoMapper.selectAll();
        for (RoleInfo roleInfo: roleInfos) {
            if ("ROLE_ADMIN".equals(roleInfo.getTag()) && roleInfo.getStatus() == Constants.USER_STATUS_NORMAL) {
                roles.add(roleInfo.getTag());
            }
        }
        return roles;
    }
}
