package com.heyoufu.pay.common.vo.payMerchant.serchVO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
    * 保存系统审核商户条件参数VO
    */
@ApiModel(value="com-heyoufu-pay-model-MerchantReviewSystem")
@Data
public class MerchantReviewSystemSerchVO {

    @ApiModelProperty(value="用户id")
    private Long userId;

    @ApiModelProperty(value="商户号")
    private String merchantNo;

    @ApiModelProperty(value="审核状态")
    private String reviewStatus;

    @ApiModelProperty(value="审核结果")
    private String reviewResult;

    @ApiModelProperty(value="创建人")
    private Long createUser;

    @ApiModelProperty(value="修改人")
    private Long updateUser;

}