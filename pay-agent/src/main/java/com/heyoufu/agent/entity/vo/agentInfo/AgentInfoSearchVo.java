package com.heyoufu.agent.entity.vo.agentInfo;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.beans.IntrospectionException;
import java.sql.Timestamp;

/**
 * @author xnk
 * @data 2020/6/5 16:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiOperation(value = "代理商中心查询信息vo")
public class AgentInfoSearchVo {
    @ApiModelProperty("代理商编号")
    private String agentNo;

    @ApiModelProperty("代理商状态")
    private String agentStatus;

    @ApiModelProperty("范围时间")
    private Timestamp registerTime;

    @ApiModelProperty("查询页数")
    private Integer currentPage;

    @ApiModelProperty("每页大小")
    private Integer size;

}
