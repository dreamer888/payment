package com.heyoufu.pay.mapper;

import com.heyoufu.pay.model.AgentReview;
import java.util.UUID;

public interface AgentReviewMapper {
    int deleteByPrimaryKey(UUID id);

    int insert(AgentReview record);

    int insertSelective(AgentReview record);

    AgentReview selectByPrimaryKey(UUID id);

    int updateByPrimaryKeySelective(AgentReview record);

    int updateByPrimaryKey(AgentReview record);
}