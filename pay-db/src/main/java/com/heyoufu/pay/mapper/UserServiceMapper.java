package com.heyoufu.pay.mapper;

import com.heyoufu.pay.model.UserService;

public interface UserServiceMapper {
    int insert(UserService record);

    int insertSelective(UserService record);
}