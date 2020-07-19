package com.heyoufu.agent.entity.vo;

import com.heyoufu.agent.entity.vo.agentprofitshare.ProfitShareOrderDetailVo;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author xnk
 * @data 2020/5/13 10:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("分润订单展示")
public class AgentProfitShareOrderVo {

    private List<ProfitShareOrderDetailVo> content;

    private Integer page;  //当前页

    private Integer size; //每页大小

    private int totalPage;   //总的页数

    private long totalSize;   //总共的数量
}
