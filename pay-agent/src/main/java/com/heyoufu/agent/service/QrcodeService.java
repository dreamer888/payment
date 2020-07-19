package com.heyoufu.agent.service;

import com.heyoufu.pay.model.UserInfo;
/**
 * @author xnk
 * @data 2020/6/11 10:36
 */
public interface QrcodeService {

    /**
     * 1.用户通过二维码注册,二维码绑定
     * @param
     * @param
     * @return
     */
    Boolean addQrcode(String qrcodeNo,UserInfo userInfo);

    /**
     * 代理商用户绑定
     */
    Boolean addAgentUserInfo(String agentNo,String merchantNo);
}
