package com.heyoufu.pay.common.constant;

/**
 * 短信发送模板
 */
public class SMSConstant {

    /**
     * 短信用户名密码，模板配置
     */
    public static final String SMS_USERNAME = "heyoufu";
    public static final String SMS_PASSWORD = "9b39680f4bf4b56731d8b98bfcdd4e1b";
    public static final String SMS_CONTENT = "【唤梦】您的验证码是${smsCode}, 3分钟内有效。若非本人操作请忽略此消息。";
    public static final String SMS_URL = "https://api.smsbao.com/sms?u=USERNAME&p=PASSWORD&m=PHONE&c=CONTENT";
    public static final String SMS_CODE_PHONE_NUMBER_KEY = "mobile";    //短信验证时，前端传过来的手机号参数

}
