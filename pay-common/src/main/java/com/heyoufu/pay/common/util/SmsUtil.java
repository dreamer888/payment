package com.heyoufu.pay.common.util;

import cn.hutool.http.HttpUtil;
import com.heyoufu.pay.common.constant.SMSConstant;

/**
 * 短信发送工具类
 */
public class SmsUtil {

    public static void send(String mobile, String code) throws Exception{
        String url = SMSConstant.SMS_URL;
        url = url.replace("USERNAME", SMSConstant.SMS_USERNAME);
        url = url.replace("PASSWORD", SMSConstant.SMS_PASSWORD);
        String content = SMSConstant.SMS_CONTENT.replace("${smsCode}", code);
        url = url.replace("CONTENT", content);
        url = url.replace("PHONE", mobile);
        String result = HttpUtil.get(url);
        switch (result) {
            case "30":
                throw new RuntimeException("错误密码");
            case "40":
                throw new RuntimeException("账号不存在");
            case "41":
                throw new RuntimeException("余额不足");
            case "43":
                throw new RuntimeException("ip地址限制");
            case "50":
                throw new RuntimeException("内容有敏感词");
            case "51":
                throw new RuntimeException("手机号码不正确");
        }
    }

    public static String createCode() {
        double random = Math.random();
        String randStr = random + "";
        String code = randStr.substring(randStr.length()-6);
        return code;
    }

}
