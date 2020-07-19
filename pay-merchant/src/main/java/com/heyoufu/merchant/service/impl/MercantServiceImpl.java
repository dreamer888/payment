package com.heyoufu.merchant.service.impl;

import cn.hutool.core.date.DateTime;
import com.heyoufu.merchant.service.MercantService;
import com.heyoufu.pay.common.vo.payMerchant.serchVO.MerchantReviewSystemSerchVO;
import com.heyoufu.pay.common.util.Generator;
import com.heyoufu.pay.mapper.MerchantInfoMapper;
import com.heyoufu.pay.mapper.MerchantReviewSystemMapper;
import com.heyoufu.pay.model.MerchantInfo;
import com.heyoufu.pay.model.MerchantReviewSystem;
import com.heyoufu.pay.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * 2 * @Author: xuan
 * 3 * @Date: 2020/6/4 11:09
 * 4
 */
@Service
public class MercantServiceImpl implements MercantService {

    @Autowired
    private MerchantReviewSystemMapper merchantReviewSystemMapper;

    @Autowired
    private MerchantInfoMapper merchantInfoMapper;

    @Override
    public int saveMercant(MerchantReviewSystemSerchVO vo) {
        MerchantReviewSystem mer = new MerchantReviewSystem();
        mer.setId(Generator.getId());
        mer.setUserId(vo.getUserId());
        mer.setMerchantNo(vo.getMerchantNo());
        mer.setReviewResult(vo.getReviewResult());
        mer.setCreateUser(vo.getCreateUser());
        mer.setCreateTime(new Date());
        return merchantReviewSystemMapper.insertSelective(mer);
    }


    @Transactional
    @Override
    public String setDefaultMerchantReview(UserInfo info) {
        MerchantInfo merchantInfo = merchantInfoMapper.selectByUserId(info.getId());
        if (merchantInfo == null) {
            merchantInfo = new MerchantInfo();
            merchantInfo.setId(Generator.getId());
            merchantInfo.setUserId(info.getId());
            merchantInfo.setMerchantNo(Generator.getMerchantNo());
            merchantInfoMapper.insertSelective(merchantInfo);
        }
        MerchantReviewSystem mer = merchantReviewSystemMapper.selectByMerchantNo(merchantInfo.getMerchantNo());
        if (mer == null) {
            mer = new MerchantReviewSystem();
            mer.setId(Generator.getId());
            mer.setUserId(info.getId());
            mer.setMerchantNo(merchantInfo.getMerchantNo());
            mer.setReviewStatus("UNCOMMITTED");
            mer.setCreateTime(new DateTime());
            mer.setCreateUser(info.getCreateUser());
            mer.setUpdateTime(new DateTime());
            mer.setUpdateUser(info.getUpdateUser());
            merchantReviewSystemMapper.insertSelective(mer);
        }
        return merchantInfo.getMerchantNo();
    }


}
