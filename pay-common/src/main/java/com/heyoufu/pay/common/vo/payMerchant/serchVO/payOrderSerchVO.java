package com.heyoufu.pay.common.vo.payMerchant.serchVO;

import lombok.Data;

/**
 * 2 * @Author: xuan
 * 3 * @Date: 2020/6/11 11:17
 * 4
 */
@Data
public class payOrderSerchVO {

    //商户号
    private String poNo;

    private Integer page;

    private Integer size;
}
