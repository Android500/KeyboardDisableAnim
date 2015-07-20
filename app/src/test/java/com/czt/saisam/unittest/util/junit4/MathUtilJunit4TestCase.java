package com.czt.saisam.unittest.util.junit4;

import com.czt.saisam.unittest.util.MathUtil;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author zhitao
 * @since 2015-07-13 00:17
 */

public class MathUtilJunit4TestCase {

    private int a;

    private int b;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("---BeforeClass---");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("---AfterClass---");
    }

    @Before
    public void beforeMethod() {
        a = 5;
        b = 2;
        System.out.println("---BeforeMethod---");
    }

    @After
    public void afterMethod() {
        System.out.println("---AfterMethod---");
    }

    /**
     * 测试加法——同时测试是否正确与失败
     *
     * @throws Exception
     */
    @Test
    public void add() {
        System.out.println("---add---");
        Assert.assertSame(2, MathUtil.add(1, 1));
        Assert.assertNotSame(1, MathUtil.add(1, 1));
    }

    @Test
    public void sub() {
        System.out.println("---sub---");
        // 这里的a，b的值会在 setUp() 方法中进行初始化
        Assert.assertEquals(3, MathUtil.sub(a, b));
        Assert.assertEquals(2, MathUtil.sub(a, b));
    }

    @Test
    public void sub_ignore() {
        System.out.println("---sub_ignore---");
        Assert.assertEquals(2, MathUtil.sub(a, b));
    }

    @Test(expected = NumberFormatException.class)
    @Ignore
    public void getDecimalFromString() {
        System.out.println("---getDecimalFromString---");
        Assert.assertEquals(456, MathUtil.getDecimalFromString("123.456d"));
        Assert.assertEquals(0, MathUtil.getDecimalFromString("abc"));
        Assert.assertEquals(0, MathUtil.getDecimalFromString("123"));
    }

}
