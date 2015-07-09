package com.czt.saisam.unittest.util;

import java.math.BigDecimal;

/**
 * @author zhitao
 * @since 2015-07-06 21:30
 */
public class MathUtil {

    public static float add1(float a, float b) {
        BigDecimal tempA = new BigDecimal(String.valueOf(a));
        BigDecimal tempB = new BigDecimal(String.valueOf(b));
        return tempA.add(tempB).floatValue();
    }

    public static float sub1(float a, float b) {
        BigDecimal tempA = new BigDecimal(String.valueOf(a));
        BigDecimal tempB = new BigDecimal(String.valueOf(b));
        return tempA.subtract(tempB).floatValue();
    }

    public static float add2(float a, float b) {
        return a + b;
    }

    public static float sub2(float a, float b) {
        return a - b;
    }
}
