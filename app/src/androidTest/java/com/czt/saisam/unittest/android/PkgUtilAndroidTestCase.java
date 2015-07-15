package com.czt.saisam.unittest.android;

import android.test.AndroidTestCase;

/**
 * @author zhitao
 * @since 2015-07-07 01:23
 */
public class PkgUtilAndroidTestCase extends AndroidTestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void test_getVersionName() throws Exception {
        PkgUtil.getVersionName(getContext());
    }

}
