package com.heyoufu.agent.service.impl;

import com.heyoufu.agent.service.QrcodeService;
import com.heyoufu.pay.common.constant.SystemUserIdConstant;
import com.heyoufu.pay.common.util.Generator;
import com.heyoufu.pay.common.util.OptionalConsumer;
import com.heyoufu.pay.mapper.AgentAffiliationMapper;
import com.heyoufu.pay.mapper.AgentInfoMapper;
import com.heyoufu.pay.mapper.MerchantInfoMapper;
import com.heyoufu.pay.mapper.QrcodeInfoMapper;
import com.heyoufu.pay.model.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author xnk
 * @data 2020/6/11 10:37
 */
@Service
public class QrcodeServiceImpl implements QrcodeService {

    @Resource
    private QrcodeInfoMapper qrcodeInfoMapper;

    @Resource
    private AgentInfoMapper agentInfoMapper;

    @Resource
    private MerchantInfoMapper merchantInfoMapper;

    @Resource
    private AgentAffiliationMapper agentAffiliationMapper;

    /**
     * 用户二维注册,该二维码与用户关联
     * @param
     * @param
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean addQrcode(String qrcodeNo,UserInfo userInfo){
        //查询二维码编号
        QrcodeInfo qrcodeInfo = qrcodeInfoMapper.selectByQrcodeNo(qrcodeNo);
        if (qrcodeInfo == null){
            return false;
        }
        //将用户id与二维码id关联
        qrcodeInfo.setUserId(userInfo.getId());
        //用户头像关联
        qrcodeInfo.setUserHeader(userInfo.getHeader());
        if(!Optional.ofNullable(qrcodeInfo.getCreateUser()).isPresent() ||
                StringUtils.isBlank(qrcodeInfo.getCreateUser().toString())){
            qrcodeInfo.setCreateUser(SystemUserIdConstant.QrcodeService);//二维码服务
        }
        if(!Optional.ofNullable(qrcodeInfo.getCreateTime()).isPresent() ||
                StringUtils.isBlank(qrcodeInfo.getCreateTime().toString())){
            qrcodeInfo.setCreateTime(LocalDateTime.now());
        }
        qrcodeInfo.setUpdateUser(SystemUserIdConstant.QrcodeService);//修改人
        //时间
        qrcodeInfo.setUpdateTime(LocalDateTime.now());
        qrcodeInfoMapper.updateByPrimaryKey(qrcodeInfo);
        return true;
    }

    /**
     * 二维码下注册下代理商与用户建立从属关系
     * @param
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean  addAgentUserInfo(String agentNo,String merchantNo) {
        if (Optional.ofNullable(agentNo).isPresent()
                && StringUtils.isNoneBlank(agentNo)) {
            AgentInfo agentInfo = agentInfoMapper.selectByAgentNo(agentNo);
            if (agentInfo == null) {
                return false;
            }
            MerchantInfo merchantInfo = merchantInfoMapper.selectByMerchantNo(merchantNo);
            AgentAffiliation agentAffiliation = new AgentAffiliation();
            agentAffiliation.setId(Generator.getId());
            agentAffiliation.setAgentId(agentInfo.getId());
            agentAffiliation.setSubMerchantId(merchantInfo.getId());
            agentAffiliation.setSubMerchantNo(merchantInfo.getMerchantNo());
            agentAffiliation.setSubMerchantName(merchantInfo.getMerchantName());
            agentAffiliation.setCreateUser(SystemUserIdConstant.AgentService);//代理商服务
            agentAffiliation.setCreateTime(LocalDateTime.now());
            agentAffiliationMapper.insert(agentAffiliation);
            return true;
        }
        return false;
    }
}
