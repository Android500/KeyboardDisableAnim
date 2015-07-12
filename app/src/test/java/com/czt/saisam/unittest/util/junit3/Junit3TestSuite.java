package com.czt.saisam.unittest.util.junit3;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author zhitao
 * @since 2015-07-06 22:31
 */
public class Junit3TestSuite extends TestSuite {

    public static Test suite() {
        TestSuite suite = new TestSuite(Junit3TestSuite.class);

        suite.addTestSuite(MathUtilJunit3TestCase.class);
        suite.addTestSuite(StringUtilJunit3TestCase.class);

        return suite;
    }
}
