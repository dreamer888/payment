package com.heyoufu.pay.mapper;

import com.heyoufu.pay.model.MerchantReviewUpstream;

public interface MerchantReviewUpstreamMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MerchantReviewUpstream record);

    int insertSelective(MerchantReviewUpstream record);

    MerchantReviewUpstream selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MerchantReviewUpstream record);

    int updateByPrimaryKey(MerchantReviewUpstream record);
}