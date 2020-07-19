package com.heyoufu.pay.mapper;

import com.heyoufu.pay.model.UserRate;

public interface UserRateMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserRate record);

    int insertSelective(UserRate record);

    UserRate selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserRate record);

    int updateByPrimaryKey(UserRate record);
}