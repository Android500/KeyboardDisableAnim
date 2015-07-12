package com.czt.saisam.unittest.util.junit4;

import com.czt.saisam.unittest.util.StringUtil;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

/**
 * @author zhitao
 * @since 2015-07-06 23:08
 */
@RunWith(Parameterized.class)
public class StringUtilJunit4TestCase {

    @Parameterized.Parameters()
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {true, null}, {true, new String[] {null, null}}, {true, new String[] {""}}, {true, new String[] {"", ""}},
                {false, new String[] {"123"}}, {true, new String[] {"123", ""}}, {false, new String[] {"123", "456"}}
        });
    }

    private boolean mExpected;

    private String[] mArgs;

    public StringUtilJunit4TestCase(boolean expected, String... args) {
        mExpected = expected;
        mArgs = args;

    }

    @Test
    public void isStringNull() throws Exception {
        Assert.assertEquals(mExpected, StringUtil.isStringNull(mArgs));
    }

}
