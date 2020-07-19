package com.heyoufu.merchant.vo.searchVO;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 2 * @Author: xuan
 * 3 * @Date: 2020/4/22 15:49
 * 4
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("app查询统计商户订单请求vo")
public class OrderBillSearchVO {

    //月份
    private String ctime;
    //商户号
    private String pono;
}
