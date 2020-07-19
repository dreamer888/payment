package com.heyoufu.pay.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.heyoufu.pay.model.MerchantReviewSystem;

public interface MerchantReviewSystemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MerchantReviewSystem record);

    int insertSelective(MerchantReviewSystem record);

    MerchantReviewSystem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MerchantReviewSystem record);

    int updateByPrimaryKey(MerchantReviewSystem record);

    MerchantReviewSystem findByUserId(Long userId);

    MerchantReviewSystem selectByMerchantNo(@Param("merchantNo")String merchantNo);


}