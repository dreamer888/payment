package com.heyoufu.authserver.service.impl;

import com.heyoufu.authserver.service.UserServiceService;
import com.heyoufu.pay.mapper.UserServiceMapper;
import com.heyoufu.pay.model.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceServiceImpl implements UserServiceService {

    @Autowired
    private UserServiceMapper userServiceMapper;

    @Override
    public UserService create(UserService userService) {
        userServiceMapper.insertSelective(userService);
        return userService;
    }
}
