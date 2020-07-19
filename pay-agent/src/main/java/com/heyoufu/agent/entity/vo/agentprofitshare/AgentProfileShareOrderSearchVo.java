package com.heyoufu.agent.entity.vo.agentprofitshare;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xnk
 * @data 2020/5/13 10:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("代理商分润的多条件查询VO")
public class AgentProfileShareOrderSearchVo {

    @ApiModelProperty("查询页数")
    private Integer currentPage;

    @ApiModelProperty("每页大小")
    private Integer size;


    @ApiModelProperty("分润对象")
    private Integer target;

    @ApiModelProperty("时间排序规则") // 1-降序，2-升序
    private Integer timeSortStatus;
}
