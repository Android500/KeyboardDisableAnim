package com.czt.saisam.unittest.util;

import java.math.BigDecimal;

/**
 * @author zhitao
 * @since 2015-07-06 21:30
 */
public class MathUtil {

    public static int add(int a, int b) {
        return a + b;
    }

    public static int sub(int a, int b) {
        return a - b;
    }

    /**
     * 从一个浮点型字符串中获取小数部分的整数
     * <p/>
     * 实际上如果是一个整数或者其他不是数字的字符串，我们除了抛出无法转型的异常之外，还可能会抛出数组越界的异常
     * 假设是"123"，那么是没有numbers[1]的
     *
     * @param str
     *
     * @return
     *
     * @throws NumberFormatException
     */
    public static int getDecimalFromString(String str) throws NumberFormatException {
        String[] numbers = str.split("\\.");
        return Integer.valueOf(numbers[1]);
    }

    public static float add1(float a, float b) {
        BigDecimal tempA = new BigDecimal(String.valueOf(a));
        BigDecimal tempB = new BigDecimal(String.valueOf(b));
        return tempA.add(tempB).floatValue();
    }

    public static float add2(float a, float b) {
        return a + b;
    }

    public static float sub1(float a, float b) {
        BigDecimal tempA = new BigDecimal(String.valueOf(a));
        BigDecimal tempB = new BigDecimal(String.valueOf(b));
        return tempA.subtract(tempB).floatValue();
    }

    public static float sub2(float a, float b) {
        return a - b;
    }

}
