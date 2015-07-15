package com.czt.saisam.unittest.util.junit3;

import com.czt.saisam.unittest.util.AsyncTask;

import junit.framework.TestCase;

import java.util.concurrent.CountDownLatch;

/**
 * @author zhitao
 * @since 2015-07-15 22:31
 */
public class AsyncTaskJunit3TestCase extends TestCase {

    public void test_sync_getOnlineConfig() throws Exception {
        assertEquals("value1", new AsyncTask().sync_getOnlineConfig("key1"));
    }

    public void test_async_getOnlineConfig() throws Exception {
        final CountDownLatch signal = new CountDownLatch(1);
        new AsyncTask().async_getOnlineConfig("key1", new AsyncTask.onFinishListener() {

            @Override
            public void onFinish(String key, String value) {
                if ("key1".equals(key)) {
                    assertEquals("value1", value);
                }
                signal.countDown();
            }
        });
        signal.await();
    }
}
