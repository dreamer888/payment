package com.heyoufu.merchant.service;

import com.heyoufu.pay.common.vo.payMerchant.serchVO.MerchantReviewSystemSerchVO;
import com.heyoufu.pay.model.UserInfo;

/**
 * 2 * @Author: xuan
 * 3 * @Date: 2020/6/4 11:23
 * 4
 */

public interface MercantService {

    int saveMercant(MerchantReviewSystemSerchVO vo);

    /**
     * 创建默认的商户审核信息
     * @param info
     * @return
     */
    String setDefaultMerchantReview(UserInfo info);
}
