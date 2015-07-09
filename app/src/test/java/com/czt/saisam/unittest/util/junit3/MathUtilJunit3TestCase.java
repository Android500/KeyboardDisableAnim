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

    /**
     * 测试加法——同时测试是否正确与失败
     *
     * @throws Exception
     */
    public void test_add() throws Exception {
        assertSame(2, MathUtil.add(1, 1));
        assertNotSame(1, MathUtil.add(1, 1));
    }


    /**
     * 测试减法——应该失败
     *
     * @throws Exception
     */
    public void test_sub() throws Exception {
        /**
         * 这里的a，b的值会在{@link #setUp()} 方法中进行初始化
         */
        assertEquals(3, MathUtil.sub(a, b));
        assertEquals(2, MathUtil.sub(a, b));
    }

}
