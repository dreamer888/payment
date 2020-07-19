package com.heyoufu.pay.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.heyoufu.pay.model.MerchantInfo;

public interface MerchantInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MerchantInfo record);

    int insertSelective(MerchantInfo record);

    MerchantInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MerchantInfo record);

    int updateByPrimaryKey(MerchantInfo record);

    MerchantInfo selectByUserId(@Param("userId")Long userId);

    MerchantInfo selectByMerchantNo(@Param("merchantNo")String merchantNo);

}