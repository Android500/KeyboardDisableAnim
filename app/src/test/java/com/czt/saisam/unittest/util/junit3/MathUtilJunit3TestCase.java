package com.czt.saisam.unittest.util.junit3;

import com.czt.saisam.unittest.util.MathUtil;

import junit.framework.TestCase;

/**
 * @author zhitao
 * @since 2015-07-06 21:31
 */
public class MathUtilJunit3TestCase extends TestCase {

    private int a;

    private int b;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        a = 5;
        b = 2;
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void test_add() throws Exception {
        assertSame(2, MathUtil.add(1, 1));
        assertNotSame(1, MathUtil.add(1, 1));
    }

    public void test_sub() throws Exception {
        assertEquals(3, MathUtil.sub(a, b));
        assertEquals(2, MathUtil.sub(a, b));
    }

}
