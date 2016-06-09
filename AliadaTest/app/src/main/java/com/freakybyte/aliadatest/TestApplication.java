package com.freakybyte.aliadatest;

import android.app.Application;
import android.os.Handler;

/**
 * Created by Jose Torres in FreakyByte on 19/04/16.
 */
public class TestApplication extends Application {

    private static TestApplication singleton;
    private Handler mHandler = new Handler();

    public static TestApplication getInstance() {
        return singleton;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
    }

    public void handlerPost(Runnable runnable) {
        mHandler.post(runnable);
    }
}
