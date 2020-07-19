package com.heyoufu.pay.mapper;

import com.heyoufu.pay.model.BankInfo;

public interface BankInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BankInfo record);

    int insertSelective(BankInfo record);

    BankInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BankInfo record);

    int updateByPrimaryKey(BankInfo record);
}