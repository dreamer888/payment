package com.heyoufu.merchant.vo.dtoVO;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 2 * @Author: Gosin
 * 3 * @Date: 2020/4/14 16:26
 * 4
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("支付方式键值返回")
public class ChildrenVO {

    private String value;
    private String label;

}
