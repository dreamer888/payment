package com.heyoufu.pay.mapper;

import com.heyoufu.pay.model.AgentInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
/**
 * <p>
 * 代理商信息表 Mapper 接口
 * </p>
 *
 * @author lgl
 * @since 2020-05-14
 */
public interface AgentInfoMapper  {

    int deleteByPrimaryKey(Long id);

    int deleteByPrimaryKey(Integer id);

    AgentInfo selectByPrimaryKey(Integer id);

    int insert(AgentInfo record);

    int insertSelective(AgentInfo record);

    AgentInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AgentInfo record);

    int updateByPrimaryKey(AgentInfo record);

    AgentInfo selectByAgentNo(@Param("agentNo") String agentNo);
}