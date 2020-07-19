package com.heyoufu.agent.entity.vo.agentprofitshare;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author xnk
 * @data 2020/5/13 10:29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("分润订单展示细节vo")
public class ProfitShareOrderDetailVo {

    @ApiModelProperty("订单id")
    private UUID orderNo;

    @ApiModelProperty("订单标题")
    private String orderTitle;

    @ApiModelProperty("订单分润金额")
    private BigDecimal orderAmount;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("分润订单状态")
    private String profitShareStatus;

}
