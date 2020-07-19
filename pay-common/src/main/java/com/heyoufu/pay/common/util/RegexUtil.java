package com.heyoufu.pay.common.util;

import java.util.regex.Pattern;

/**
 * 正则表达式工具类
 */
public class RegexUtil {

    /**
     * 判断当前字符串是否全部为数字
     * @param str
     * @return
     */
    public static boolean isAllNumber(String str) {
        return Pattern.matches("[0-9]+", str);
    }

    /**
     * 判断当前字符串是否全部为字母(不区分大小写)
     * @param str
     * @return
     */
    public static boolean isAllLetter(String str) {
        return Pattern.matches("[A-Za-z]+", str);
    }

    /**
     * 校验电子邮箱是否合法
     * @param email
     * @return
     */
    public static boolean checkEmail(String email) {
        String reg = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
        return Pattern.matches(reg, email);
    }

    /**
     * 校验手机号是否合法
     * @param phone
     * @return
     */
    public static boolean checkPhone(String phone) {
        String reg = "^1[345678]\\d{9}$";
        return Pattern.matches(reg, phone);
    }

}
