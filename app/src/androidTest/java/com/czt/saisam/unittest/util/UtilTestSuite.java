package com.czt.saisam.unittest.util;

import com.czt.saisam.unittest.android.PkgUtilAndroidTestCase;

import junit.framework.TestSuite;

/**
 * @author zhitao
 * @since 2015-07-10 01:53
 */
public class UtilTestSuite extends TestSuite {

    public UtilTestSuite() {
        super();
        addTestSuite(MathUtilTestCase.class);
        addTestSuite(PkgUtilAndroidTestCase.class);

    }
}
