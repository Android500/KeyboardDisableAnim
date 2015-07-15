package com.czt.saisam.unittest.util;

import android.app.Activity;
import android.test.AndroidTestRunner;
import android.util.Log;

import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestListener;

/**
 * @author zhitao
 * @since 2015-07-10 01:55
 */
public class UtilTestListener implements Runnable, TestListener {

    int mTotalTestCounts;

    int mErrorTestCounts;

    int mFailureTestCounts;

    Activity parentActivity;

    public UtilTestListener(Activity parentActivity) {
        this.parentActivity = parentActivity;
    }

    @Override
    public void run() {
        mTotalTestCounts = 0;
        mErrorTestCounts = 0;
        mFailureTestCounts = 0;

        // 核心测试代码核心
        AndroidTestRunner testRunner = new AndroidTestRunner();
        testRunner.setTest(new UtilTestSuite());
        testRunner.setContext(parentActivity);
        testRunner.runTest();

        Log.v("test", String.format("测试完毕\n测试总数：%d\n失败总数：%d\n异常总数：%d", mTotalTestCounts, mFailureTestCounts, mErrorTestCounts));
    }

    @Override
    public void addError(Test test, Throwable throwable) {
        Log.e("test", String.format("%s 测试抛出异常", test.getClass().getName()));
        ++mErrorTestCounts;
    }

    @Override
    public void addFailure(Test test, AssertionFailedError assertionFailedError) {
        Log.e("test", String.format("%s 测试不通过", test.getClass().getName()));
        Log.e("test", assertionFailedError.getMessage(), assertionFailedError);
        ++mFailureTestCounts;
    }

    @Override
    public void endTest(Test test) {
        Log.i("test", String.format("%s 测试结束", test.getClass().getName()));
    }

    @Override
    public void startTest(Test test) {
        Log.i("test", String.format("%s 测试开始", test.getClass().getName()));
        ++mTotalTestCounts;

    }
}
