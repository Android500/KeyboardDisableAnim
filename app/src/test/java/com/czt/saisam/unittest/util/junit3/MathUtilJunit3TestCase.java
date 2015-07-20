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
        System.out.println("---Calling setUp---");
        a = 5;
        b = 2;
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        System.out.println("---Calling tearDown---");
    }

    /**
     * 测试加法——同时测试是否正确与失败
     *
     * @throws Exception
     */
    public void test_add() throws Exception {
        System.out.println("---Calling test_add---");

        assertSame(2, MathUtil.add(1, 1));
        assertNotSame(1, MathUtil.add(1, 1));
    }

    /**
     * 测试减法——应该失败
     *
     * @throws Exception
     */
    public void test_sub() throws Exception {
        System.out.println("---Calling test_sub---");

        // 这里的a，b的值会在 setUp() 方法中进行初始化
        assertEquals(3, MathUtil.sub(a, b));
        assertEquals(2, MathUtil.sub(a, b));
    }

    public void test_getDecimalFromString() throws Exception {
        System.out.println("---Calling test_getDecimalFromString---");
        try {
            assertEquals(456, MathUtil.getDecimalFromString("123.456"));
            assertEquals(0, MathUtil.getDecimalFromString("abc"));
            assertEquals(0, MathUtil.getDecimalFromString("123"));
        } catch (NumberFormatException e) {
            assertNotNull(e.getMessage());
        }
    }

}
