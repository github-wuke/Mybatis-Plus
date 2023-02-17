package com.wuke.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

/**
 * 用于高精确处理常用的数学运算
 */
public class BigDecimalUtil {

    //默认除法运算精度
    private static final int DEF_DIV_SCALE = 10;

    /**
     * 价格类型 保留小数点 2
     */
    public static final int PRICE_DECIMAL_POINT = 2;

    /**
     * 价格类型 保留小数点 6
     */
    public static final int SIX_PRICE_DECIMAL_POINT = 6;

    /**
     * 重量类型保留小数点 3
     */
    public static final int WEIGHT_DECIMAL_POINT = 3;


    /**
     * 提供精确的加法运算
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
     * 提供精确的加法运算
     *
     * @param v1 被加数
     * @param v2 加数
     * @return 两个参数的和
     */
    public static BigDecimal add(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.add(b2);
    }

    /**
     * 提供精确的加法运算
     *
     * @param v1    被加数
     * @param v2    加数
     * @param scale 保留scale 位小数
     * @return 两个参数的和
     */
    public static String add(String v1, String v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.add(b2).setScale(scale, BigDecimal.ROUND_HALF_UP).toString();
    }

    /**
     * 提供精确的减法运算
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
     * 提供精确的减法运算。
     *
     * @param v1 被减数
     * @param v2 减数
     * @return 两个参数的差
     */
    public static BigDecimal sub(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.subtract(b2);
    }

    /**
     * 提供精确的减法运算
     *
     * @param v1    被减数
     * @param v2    减数
     * @param scale 保留scale 位小数
     * @return 两个参数的差
     */
    public static String sub(String v1, String v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.subtract(b2).setScale(scale, BigDecimal.ROUND_HALF_UP).toString();
    }

    /**
     * 提供精确的乘法运算
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
     * 提供精确的乘法运算
     *
     * @param v1 被乘数
     * @param v2 乘数
     * @return 两个参数的积
     */
    public static BigDecimal mul(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.multiply(b2);
    }

    /**
     * 提供精确的乘法运算
     *
     * @param v1    被乘数
     * @param v2    乘数
     * @param scale 保留scale 位小数
     * @return 两个参数的积
     */
    public static double mul(double v1, double v2, int scale) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return round(b1.multiply(b2).doubleValue(), scale);
    }

    /**
     * 提供精确的乘法运算
     *
     * @param v1    被乘数
     * @param v2    乘数
     * @param scale 保留scale 位小数
     * @return 两个参数的积
     */
    public static String mul(String v1, String v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.multiply(b2).setScale(scale, BigDecimal.ROUND_HALF_UP).toString();
    }

    /**
     * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到
     * 小数点以后10位，以后的数字四舍五入
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
     * 定精度，以后的数字四舍五入
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
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指
     * 定精度，以后的数字四舍五入
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 表示需要精确到小数点以后几位
     * @return 两个参数的商
     */
    public static String div(String v1, String v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v1);
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).toString();
    }

    /**
     * 提供精确的小数位四舍五入处理
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
        return b.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 提供精确的小数位四舍五入处理
     *
     * @param v     需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果
     */
    public static String round(String v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(v);
        return b.setScale(scale, BigDecimal.ROUND_HALF_UP).toString();
    }

    /**
     * 取余数
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 小数点后保留几位
     * @return 余数
     */
    public static String remainder(String v1, String v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.remainder(b2).setScale(scale, BigDecimal.ROUND_HALF_UP).toString();
    }

    /**
     * 取余数  BigDecimal
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 小数点后保留几位
     * @return 余数
     */
    public static BigDecimal remainder(BigDecimal v1, BigDecimal v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        return v1.remainder(v2).setScale(scale, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 比较大小
     *
     * @param v1 被比较数
     * @param v2 比较数
     * @return 如果v1 大于v2 则 返回true 否则false
     */
    public static boolean compare(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        int bj = b1.compareTo(b2);
        boolean res;
        if (bj > 0)
            res = true;
        else
            res = false;
        return res;
    }

    /**
     * 金额相关计算方法：四舍五入 保留2位小数点
     */
    public static class Amount {

        public static BigDecimal add(BigDecimal num1, BigDecimal num2) {
            return setScale(num1.add(num2), PRICE_DECIMAL_POINT);
        }
        public static BigDecimal multiply(BigDecimal num1, BigDecimal num2) {
            return setScale(num1.multiply(num2), PRICE_DECIMAL_POINT);
        }
        public static BigDecimal subtract(BigDecimal num1, BigDecimal num2) {
            return setScale(num1.subtract(num2), PRICE_DECIMAL_POINT);
        }
        public static BigDecimal divide(BigDecimal num1, BigDecimal num2) {
            return setScale(num1.divide(num2, RoundingMode.HALF_UP), PRICE_DECIMAL_POINT);
        }
    }

    /**
     * 金额相关计算方法：四舍五入 保留2位小数点
     */
    public static class AmountSix {

        public static BigDecimal add(BigDecimal num1, BigDecimal num2) {
            return setScale(num1.add(num2), SIX_PRICE_DECIMAL_POINT);
        }
        public static BigDecimal multiply(BigDecimal num1, BigDecimal num2) {
            return setScale(num1.multiply(num2), SIX_PRICE_DECIMAL_POINT);
        }
        public static BigDecimal subtract(BigDecimal num1, BigDecimal num2) {
            return setScale(num1.subtract(num2), SIX_PRICE_DECIMAL_POINT);
        }
        public static BigDecimal divide(BigDecimal num1, BigDecimal num2) {
            return num1.divide(num2, PRICE_DECIMAL_POINT, RoundingMode.HALF_UP);
        }
    }

    /**
     * 重量相关计算方法：四舍五入 保留3位小数点
     */
    public static class Weight {

        public static BigDecimal add(BigDecimal num1, BigDecimal num2) {
            return setScale(num1.add(num2), WEIGHT_DECIMAL_POINT);
        }
        public static BigDecimal multiply(BigDecimal num1, BigDecimal num2) {
            return setScale(num1.multiply(num2), WEIGHT_DECIMAL_POINT);
        }
        public static BigDecimal subtract(BigDecimal num1, BigDecimal num2) {
            return setScale(num1.subtract(num2), WEIGHT_DECIMAL_POINT);
        }
        public static BigDecimal divide(BigDecimal num1, BigDecimal num2) {
            return num1.divide(num2, WEIGHT_DECIMAL_POINT, RoundingMode.HALF_UP);
        }
    }

    /**
     * BigDecimal 加法 num1 + num2
     * 未做非空校验
     *
     * @param num1
     * @param num2
     * @param point 请使用BigDecimalUtils.PRICE_DECIMAL_POINT | BigDecimalUtils.WEIGHT_DECIMAL_POINT
     * @return BigDecimal
     */
    public static BigDecimal add(BigDecimal num1, BigDecimal num2, int point) {
        return setScale(num1.add(num2), point);
    }

    /**
     * BigDecimal 乘法 num1 x num2
     * 未做非空校验
     *
     * @param num1
     * @param num2
     * @param point 请使用BigDecimalUtils.PRICE_DECIMAL_POINT | BigDecimalUtils.WEIGHT_DECIMAL_POINT
     * @return BigDecimal
     */
    public static BigDecimal multiply(BigDecimal num1, BigDecimal num2, int point) {
        return setScale(num1.multiply(num2), point);
    }

    /**
     * BigDecimal 减法 num1 - num2
     * 未做非空校验
     *
     * @param num1
     * @param num2
     * @param point 请使用BigDecimalUtils.PRICE_DECIMAL_POINT | BigDecimalUtils.WEIGHT_DECIMAL_POINT
     * @return BigDecimal
     */
    public static BigDecimal subtract(BigDecimal num1, BigDecimal num2, int point) {
        return setScale(num1.subtract(num2), point);
    }

    /**
     * BigDecimal 除法 num1/num2
     * 未做非空校验
     *
     * @param num1
     * @param num2
     * @param point 请使用BigDecimalUtils.PRICE_DECIMAL_POINT | BigDecimalUtils.WEIGHT_DECIMAL_POINT
     * @return BigDecimal
     */
    public static BigDecimal divide(BigDecimal num1, BigDecimal num2, int point) {
        return num1.divide(num2, point, RoundingMode.HALF_UP);
    }

    /**
     * 设置小数点类型为 四舍五入
     *
     * @param num
     * @param point
     * @return BigDecimal
     */
    public static BigDecimal setScale(BigDecimal num, int point) {
        return num.setScale(point, RoundingMode.HALF_UP);
    }

    /**
     * 比较 num1 是否大于 num2
     *
     * @param num1
     * @param num2
     * @return boolean
     */
    public static boolean isGreaterThan(BigDecimal num1, BigDecimal num2) {
        return num1.compareTo(num2) == 1;
    }

    /**
     * 比较 num1 是否大于等于 num2
     *
     * @param num1
     * @param num2
     * @return boolean
     */
    public static boolean isGreaterOrEqual(BigDecimal num1, BigDecimal num2) {
        return isGreaterThan(num1, num2) || equals(num1, num2);
    }

    /**
     * 比较 num1 是否小于 num2
     *
     * @param num1
     * @param num2
     * @return boolean
     */
    public static boolean isLessThan(BigDecimal num1, BigDecimal num2) {
        return num1.compareTo(num2) == - 1;
    }

    /**
     * 比较 num1 是否小于等于 num2
     *
     * @param num1
     * @param num2
     * @return boolean
     */
    public static boolean isLessOrEqual(BigDecimal num1, BigDecimal num2) {
        return isLessThan(num1, num2) || equals(num1, num2);
    }

    /**
     * 比较 num1 是否等于 num2
     *
     * @param num1
     * @param num2
     * @return
     */
    public static boolean equals(BigDecimal num1, BigDecimal num2) {
        return num1.compareTo(num2) == 0;
    }

    /**
     * 计算 num1 / num2 的百分比
     *
     * @param num1
     * @param num2
     * @return String
     */
    public static String getPercentage(BigDecimal num1, BigDecimal num2) {
        BigDecimal result = num1.divide(num2, 4, RoundingMode.HALF_UP);
        NumberFormat percent = NumberFormat.getPercentInstance();
        percent.setMaximumFractionDigits(2);
        return percent.format(result.doubleValue());
    }

    /**
     * 计算 num1 / num2 的百分比
     *
     * @param num1
     * @param num2
     * @param point 保留几位小数
     * @return String
     */
    public static BigDecimal bigDecimalPercent(Integer num1, Integer num2, int point) {
        if (num1 == null || num2 == null) {
            return BigDecimal.ZERO;
        }
        if (num2.equals(Integer.valueOf(0))) {
            return BigDecimal.ZERO;
        }
        BigDecimal bigDecimalNum1 = new BigDecimal(num1);
        BigDecimal bigDecimalNum2 = new BigDecimal(num2);
        return bigDecimalPercent(bigDecimalNum1, bigDecimalNum2, point);
    }

    /**
     * 计算 num1 / num2 的百分比
     *
     * @param num1
     * @param num2
     * @param point 保留几位小数
     * @return String
     */
    public static BigDecimal bigDecimalPercent(BigDecimal num1, BigDecimal num2, int point) {
        if (num1 == null || num2 == null) {
            return BigDecimal.ZERO;
        }
        if (equals(BigDecimal.ZERO, num2)) {
            return BigDecimal.ZERO;
        }
        BigDecimal percent = num1.divide(num2, point + 2, RoundingMode.HALF_UP);
        BigDecimal percent100 = percent.multiply(new BigDecimal(100)).setScale(point);
        return percent100;
    }

    /**
     * 判断num是否为空 或者 零
     *
     * @param num
     * @return String
     */
    public static Boolean isEmpty(BigDecimal num) {
        return null == num || equals(BigDecimal.ZERO, num);
    }

    /**
     * 判断num是否 不等于null 并且不等于零
     *
     * @param num
     * @return String
     */
    public static Boolean isNotEmpty(BigDecimal num) {
        return ! isEmpty(num);
    }

    /**
     * 转换为万
     *
     * @param num
     * @param point
     * @return
     */
    public static BigDecimal convertTenThousand(BigDecimal num, int point) {
        BigDecimal decimal = num.divide(new BigDecimal(10000), point, RoundingMode.HALF_UP);
        return decimal;
    }

    /**
     * 转换为负数
     *
     * @param num
     * @return
     */
    public static BigDecimal convertToMinusNumber(BigDecimal num) {
        if (isLessOrEqual(num, BigDecimal.ZERO)) {
            return num;
        }
        return BigDecimal.ZERO.subtract(num);
    }

    /**
     * 对BigDecimal求2次平方根，精度无损失。
     */
    public static BigDecimal sqrt(BigDecimal value) {
        BigDecimal val = BigDecimal.valueOf(Math.sqrt(value.doubleValue()));
        return val.add(BigDecimal.valueOf(value.subtract(val.multiply(val)).doubleValue() / (val.doubleValue() * 2.0)));
    }

    /**
     * 对BigDecimal求平方根，结果四舍五入
     *
     * @param scale 几次方
     * @return java.math.BigDecimal
     * @author wuke
     * @date 2022/3/22 14:06
     */
    public static BigDecimal sqrt(BigDecimal value, int scale) {
        if (value.compareTo(BigDecimal.ZERO) == 0) {
            return new BigDecimal(0);
        }
        BigDecimal num2 = BigDecimal.valueOf(2);
        int precision = 100;
        BigDecimal deviation = value;
        int cnt = 0;
        while (cnt < precision) {
            deviation = (deviation.add(value.divide(deviation, 100, RoundingMode.HALF_UP))).divide(num2, 100, RoundingMode.HALF_UP);
            cnt++;
        }
        deviation = deviation.setScale(scale, RoundingMode.HALF_UP);
        return deviation;
    }

}
