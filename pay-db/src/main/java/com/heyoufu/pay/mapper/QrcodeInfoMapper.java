package com.heyoufu.pay.mapper;

import com.heyoufu.pay.model.QrcodeInfo;
import org.apache.ibatis.annotations.Param;

public interface QrcodeInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(QrcodeInfo record);

    int insertSelective(QrcodeInfo record);

    QrcodeInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QrcodeInfo record);

    int updateByPrimaryKey(QrcodeInfo record);

    QrcodeInfo selectByQrcodeNo(@Param("qrcodeNo")String qrcodeNo);


}