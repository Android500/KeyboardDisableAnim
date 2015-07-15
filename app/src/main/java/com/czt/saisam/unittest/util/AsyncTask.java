package com.czt.saisam.unittest.util;

/**
 * @author zhitao
 * @since 2015-07-15 22:25
 */
public class AsyncTask {

    public AsyncTask() {
        super();
    }

    public String sync_getOnlineConfig(String key) {
        // 采用线程睡眠模拟耗时操作
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if ("key1".equals(key)) {
            return "value1";
        }
        return null;
    }

    public void async_getOnlineConfig(String key, onFinishListener listener) {
        String value = sync_getOnlineConfig(key);
        if (listener != null) {
            listener.onFinish(key, value);
        }
    }

    public interface onFinishListener {

        void onFinish(String key, String value);

    }
}
