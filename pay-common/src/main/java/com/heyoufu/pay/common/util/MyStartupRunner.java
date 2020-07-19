package com.heyoufu.pay.common.util;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Locale;

/*
 *@Descrition
 *
 *@Autnor QingMu.yue
 *@Date 2020-05-18 11:11
 */
@Component
public class MyStartupRunner {
    @Resource
    private MessageSource messageSource;

    /**
     * 根据键获取提示信息
     *
     * @param code 键
     * @return 提示信息
     */
    public String getMsg(String code) {
        return this.getMsg(code, null, null, Locale.getDefault());
    }

    /**
     * 获取带参数的数据
     *
     * @param code
     * @param args string
     * @return
     */
    public String getMsg(String code, String[] args) {
        return this.getMsg(code, args, null,  Locale.getDefault());
    }

    /**
     * 获取带参数的数据
     *
     * @param code
     * @param args int
     * @return
     */
    public String getMsg(String code,Integer[] args) {
        return this.getMsg(code, args, null,  Locale.getDefault());
    }

    public String getMsg(String code, Object[] args, String defaultMessage, Locale locale) {
        return messageSource.getMessage(code, args, defaultMessage, locale);
    }

    public String getMsg(String code, Object... args) {
        return messageSource.getMessage(code, args, null,  Locale.getDefault());
    }
}
