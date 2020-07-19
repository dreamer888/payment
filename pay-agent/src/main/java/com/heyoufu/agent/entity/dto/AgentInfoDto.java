package com.heyoufu.agent.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author xnk
 * @data 2020/6/9 15:55
 */
@Api("代理商中心VO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AgentInfoDto {

    @ApiModelProperty("代理商名称")
    private String agentName;

    @ApiModelProperty("代理商编号")
    private String agent_no;

    @ApiModelProperty("用户头像")
    private String user_img;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd",  timezone="GMT+8")
    private Timestamp createTime;

    @ApiModelProperty("活跃商家")
    private Long activeBusiness;

    @ApiModelProperty("本月流水")
    private BigDecimal monthAmount;

    @ApiModelProperty("状态")
    private String auditState;
}
