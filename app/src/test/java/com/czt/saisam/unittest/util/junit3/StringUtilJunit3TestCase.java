package com.czt.saisam.unittest.util.junit3;

import com.czt.saisam.unittest.util.StringUtil;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Test;

/**
 * @author zhitao
 * @since 2015-07-06 21:31
 */
public class StringUtilJunit3TestCase extends TestCase {

    @Test
    public void test_isStringNull1() throws Exception {
        Assert.assertEquals(true, StringUtil.isStringNull(null));
    }

    @Test
    public void test_isStringNull2() throws Exception {
        Assert.assertEquals(true, StringUtil.isStringNull(null, null));
    }

    @Test
    public void test_isStringNull3() throws Exception {
        Assert.assertEquals(true, StringUtil.isStringNull(""));
    }

    @Test
    public void test_isStringNull4() throws Exception {
        Assert.assertEquals(true, StringUtil.isStringNull("", ""));
    }

    @Test
    public void test_isStringNull5() throws Exception {
        Assert.assertEquals(false, StringUtil.isStringNull("123"));
    }

    @Test
    public void test_isStringNull6() throws Exception {
        Assert.assertEquals(true, StringUtil.isStringNull("123", ""));
    }

    @Test
    public void test_isStringNull7() throws Exception {
        Assert.assertEquals(false, StringUtil.isStringNull("123", "345"));
    }

}
