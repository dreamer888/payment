package com.heyoufu.pay.mapper;

import com.heyoufu.pay.model.ChannelInfo;

public interface ChannelInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ChannelInfo record);

    int insertSelective(ChannelInfo record);

    ChannelInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ChannelInfo record);

    int updateByPrimaryKey(ChannelInfo record);
}