package com.heyoufu.pay.mapper;

import com.heyoufu.pay.model.CompanyNature;

public interface CompanyNatureMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CompanyNature record);

    int insertSelective(CompanyNature record);

    CompanyNature selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CompanyNature record);

    int updateByPrimaryKey(CompanyNature record);
}