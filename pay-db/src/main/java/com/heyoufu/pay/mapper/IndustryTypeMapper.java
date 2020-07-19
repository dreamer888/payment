package com.heyoufu.pay.mapper;

import com.heyoufu.pay.model.IndustryType;

public interface IndustryTypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(IndustryType record);

    int insertSelective(IndustryType record);

    IndustryType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(IndustryType record);

    int updateByPrimaryKey(IndustryType record);
}