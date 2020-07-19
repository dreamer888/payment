package com.heyoufu.pay.common.util;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.util.AntPathMatcher;

import java.util.regex.Pattern;

/*
 *@Descrition 路径匹配工具类
 *
 *@Autnor XUAN
 *@Date 2020-05-18 15:15
 */
public class UrlPatternUtils {
    private static final AntPathMatcher matcher = new AntPathMatcher();

    /**
     * 方式一 使用spring通用方式验证
     * @param targetPath 目标路径
     * @param patterns 匹配列表
     * @return
     */
    public static boolean matcher1(String targetPath, String... patterns){
        if(ArrayUtils.isEmpty(patterns)){
            return false;
        }
        for (String pattern : patterns) {
            if(matcher.match(pattern, targetPath)){
                return true;
            }
        }
        return false;
    }

    /**
     * 方式二 自定义正则验证， 能够解决上面不能匹配"**\/public\/**" 问题, 比较危险，不建议使用
     * @param targetPath 目标路径
     * @param patterns 匹配列表
     * @return
     */
    public static boolean matcher2(String targetPath, String... patterns){
        if(ArrayUtils.isEmpty(patterns)){
            return false;
        }
        for (String pattern : patterns) {
            String regPath = getRegPath(pattern);
            if(Pattern.compile(regPath).matcher(targetPath).matches()){
                return true;
            }
        }
        return false;
    }


    /**
     * 将通配符表达式转化为正则表达式
     * @param path
     * @return
     */
    private static String getRegPath(String path) {
        char[] chars = path.toCharArray();
        int len = chars.length;
        StringBuilder sb = new StringBuilder();
        boolean preX = false;
        for(int i=0;i<len;i++){
            if (chars[i] == '*'){
                if (preX){
                    sb.append(".*");
                    preX = false;
                }else if(i+1 == len){
                    sb.append("[^/]*");
                }else{
                    preX = true;
                    continue;
                }
            }else{
                if (preX){
                    sb.append("[^/]*");
                    preX = false;
                }
                if (chars[i] == '?'){
                    sb.append('.');
                }else{
                    sb.append(chars[i]);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] urlArr = {
                "**/webjars",
                "**/doc.html",
                "**/v2/api-docs",
                "*/public/**"};

        String targetUrl = "/users/public/sendMsg";

        boolean matcher = matcher2(targetUrl, urlArr);
        System.out.println(matcher);
    }
}
