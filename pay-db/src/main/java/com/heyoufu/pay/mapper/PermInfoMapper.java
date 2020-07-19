package com.heyoufu.pay.mapper;

import com.heyoufu.pay.model.PermInfo;

public interface PermInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PermInfo record);

    int insertSelective(PermInfo record);

    PermInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PermInfo record);

    int updateByPrimaryKey(PermInfo record);
}