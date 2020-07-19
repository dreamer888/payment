package com.heyoufu.pay.common.vo.payMerchant.serchVO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 2 * @Author: xuan
 * 3 * @Date: 2020/6/11 8:40
 * 4
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("按时间段查询对应订单vo")
public class OrderTimeSerchVo {

    @ApiModelProperty("收款商户号")
    private String poNo;

    @ApiModelProperty("开始时间")
    private String starTime;

    @ApiModelProperty("结束时间")
    private String endTime;
}
