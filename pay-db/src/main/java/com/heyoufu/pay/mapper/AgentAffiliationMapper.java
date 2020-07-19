package com.heyoufu.pay.mapper;

import com.heyoufu.pay.model.AgentAffiliation;
import com.heyoufu.pay.model.AgentInfo;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;

public interface AgentAffiliationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AgentAffiliation record);

    int insertSelective(AgentAffiliation record);

    AgentAffiliation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AgentAffiliation record);

    int updateByPrimaryKey(AgentAffiliation record);

    List<AgentAffiliation> findAgentSonAndAgent(String agentNo);

    AgentInfo findByAgentNo(String agentNo);
}