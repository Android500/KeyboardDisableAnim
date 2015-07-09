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
 * @since 2015-07-06 21:31
 */
public class MathUtilJunit4TestCase {

    private int a;

    private int b;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("BeforeClass================");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("AfterClass================");
    }

    @Before
    public void beforeMethod() {
        a = 5;
        b = 2;
        System.out.println("BeforeMethod================");
    }


    @After
    public void afterMethod() {
        System.out.println("AfterMethod================");
    }


    /**
     * ���Լӷ�����ͬʱ�����Ƿ���ȷ��ʧ��
     *
     * @throws Exception
     */
    @Test
    public void add1() throws Exception {
        System.out.println("test_add================");
        Assert.assertSame(2, MathUtil.add(1, 1));
        Assert.assertNotSame(1, MathUtil.add(1, 1));
    }


    /**
     * ���Լӷ�����������Է���Ӧ����ʧ�ܵģ������������@Ignoreע�⣬��������Խ����������������Խ����
     *
     * @throws Exception
     */
    @Test
    @Ignore
    public void add2() throws Exception {
        System.out.println("test_add_ShouldBeFailed================");
        Assert.assertSame(3, MathUtil.add(1, 1));
    }


    /**
     * ���Լ���
     *
     * @throws Exception
     */
    @Test
    public void sub() throws Exception {
        System.out.println("test_sub================");
        Assert.assertEquals(3, MathUtil.sub(a, b));
    }

    /**
     * ��ʱ����
     * ���Լ��������Է���ִ���Ƿ�ʱ���޶�ʱ��Ϊ1000ms ������������2000s�Դﵽʧ�ܵ�Ŀ��
     *
     * @throws Exception
     */
    @Test(timeout = 1000)
    @Ignore
    public void sub_wait() throws Exception {
        System.out.println("test_sub_wait================");
        Thread.sleep(2000);
        Assert.assertEquals(3, MathUtil.sub(a, b));
    }


}
