package com.heyoufu.pay.common.util;

import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.List;

/*
 *@Descrition 精确浮点运算
 *
 *@Autnor xuan
 *@Date 2020-05-19
 */
public class ArithUtils {

    /**
     * 默认除法运算精度
     */
    private static final int DEF_DIV_SCALE = 6;

    /**
     * 提供精确的加法运算。
     *
     * @param v1 被加数
     * @param v2 加数
     * @return 两个参数的和
     */
    public static double add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();
    }

    /**
     * 提供精确的加法运算。
     *
     * @param v1 被加数
     * @return 两个参数的和
     */
    public static double addList(List<Double> v1) {
        double result = 0.0;
        if(!CollectionUtils.isEmpty(v1)){
            for (Double item : v1) {
                result = add(result, item);
            }
        }
        return result;
    }

    /**
     * 提供精确的减法运算。
     *
     * @param v1 被减数
     * @param v2 减数
     * @return 两个参数的差
     */
    public static double sub(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 提供精确的乘法运算。
     *
     * @param v1 被乘数
     * @param v2 乘数
     * @return 两个参数的积
     */
    public static double mul(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).doubleValue();
    }

    /**
     * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到
     * 小数点以后10位，以后的数字四舍五入。
     *
     * @param v1 被除数
     * @param v2 除数
     * @return 两个参数的商
     */
    public static double div(double v1, double v2) {
        return div(v1, v2, DEF_DIV_SCALE);
    }

    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指
     * 定精度，以后的数字四舍五入。
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */
    public static double div(double v1, double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 提供精确的小数位四舍五入处理。
     *
     * @param v     需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果
     */
    public static double round(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 保留小数，不做四舍五入处理， 直接截断。
     *
     * @param v     需要处理的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果
     */
    public static double roundFloor(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_FLOOR).doubleValue();
    }



    /**
     * 计算乘以百分比
     *
     * @param v   需要计算百分比的数字
     * @param percent 百分比数字  例如： 1.5  %
     * @return 四舍五入后的结果
     */
    public static double mulPercent(double v, double percent) {
        if (percent <= 0) {
            return 0.0;
        }
        // 百分比换算
        double div = div(percent, 100);

        return mul(v, div);
    }

    /**
     * 元转分， 舍弃小数位
     *
     * @param v   需要转换的金额
     * @return 四舍五入后的结果
     */
    public static int yuanToCent(double v) {
        if (v <= 0) {
            return 0;
        }
        // *100
        double mul = mul(v, 100);

        return (int)mul;
    }

    public static int compareTo(double v1, double v2) {
        return new BigDecimal(v1).compareTo(new BigDecimal(v2));
    }

    public static int compareTo(Long v1, Long v2) {
        return new BigDecimal(v1).compareTo(new BigDecimal(v2));
    }

    public static String getPercent(double num1, double num2) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(2);
        String result = numberFormat.format(num1 / num2 * 100);
        return result;
    }
    public static String formatDouble2(double d) {
        NumberFormat nf = NumberFormat.getNumberInstance();
        // 保留两位小数
        nf.setMaximumFractionDigits(2);
        // 如果不需要四舍五入，可以使用RoundingMode.DOWN
        nf.setRoundingMode(RoundingMode.UP);
        return nf.format(d);
    }
}
