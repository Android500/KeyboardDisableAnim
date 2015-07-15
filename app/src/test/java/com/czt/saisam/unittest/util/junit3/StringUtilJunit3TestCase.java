package com.czt.saisam.unittest.util.junit3;

import com.czt.saisam.unittest.util.StringUtil;

import junit.framework.TestCase;

/**
 * @author zhitao
 * @since 2015-07-06 21:31
 */
public class StringUtilJunit3TestCase extends TestCase {

    /**
     * 测试字符串是否为空的方法,因为要模拟各种边界情况，这里就详细列出各个情况
     *
     * @throws Exception
     */
    public void test_isStringNull() throws Exception {
        assertEquals(true, StringUtil.isStringNull(null));
        assertEquals(true, StringUtil.isStringNull(null, null));
        assertEquals(true, StringUtil.isStringNull(""));
        assertEquals(true, StringUtil.isStringNull("", ""));
        assertEquals(false, StringUtil.isStringNull("123"));
        assertEquals(true, StringUtil.isStringNull("123", ""));
        assertEquals(false, StringUtil.isStringNull("123", "345"));
    }
}
