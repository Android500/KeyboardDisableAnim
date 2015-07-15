package com.czt.saisam.unittest.util;

import android.test.AndroidTestCase;

/**
 * @author zhitao
 * @since 2015-07-10 01:44
 */
public class MathUtilTestCase extends AndroidTestCase {

    public void test_float_add1() throws Exception {
        assertEquals(3.46f, MathUtil.add1(1.23f, 2.23f));
    }

    public void test_float_sub1() throws Exception {
        assertEquals(3f, MathUtil.sub1(5.23f, 2.23f));
        assertEquals(1.1f, MathUtil.sub1(529.12f, 528.02f));
    }

    public void test_float_add2() throws Exception {
        assertEquals(3.46f, MathUtil.add2(1.23f, 2.23f));
    }

    public void test_float_sub2() throws Exception {
        assertEquals(3f, MathUtil.sub2(5.23f, 2.23f));
        assertEquals(1.1f, MathUtil.sub2(529.12f, 528.02f));
    }

}
