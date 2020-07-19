package com.heyoufu.merchant.vo.dtoVO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 2 * @Author: Gosin
 * 3 * @Date: 2020/4/18 10:53
 * 4
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("查询订单返回对象")
@Builder
public class FindTimeByAppListDto {

    @ApiModelProperty("日期")
    private String cTime;
    @ApiModelProperty("总金额")
    private BigDecimal aMout;
}
