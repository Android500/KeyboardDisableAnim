package com.czt.saisam.unittest.util.junit4;

import com.czt.saisam.unittest.util.AsyncTask;

import junit.framework.Assert;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * @author zhitao
 * @since 2015-07-15 22:31
 */
public class AsyncTaskJunit4TestCase {

    @Test(timeout = 1000)
    public void sync_getOnlineConfig() {
        Assert.assertEquals("value1", new AsyncTask().sync_getOnlineConfig("key1"));
    }

    @Test(timeout = 6000, expected = InterruptedException.class)
    public void async_getOnlineConfig() throws InterruptedException {
        final CountDownLatch signal = new CountDownLatch(1);
        new AsyncTask().async_getOnlineConfig("key1", new AsyncTask.onFinishListener() {

            @Override
            public void onFinish(String key, String value) {
                if ("key1".equals(key)) {
                    Assert.assertEquals("value1", value);
                }
                signal.countDown();
            }
        });
        signal.await();
    }
}
