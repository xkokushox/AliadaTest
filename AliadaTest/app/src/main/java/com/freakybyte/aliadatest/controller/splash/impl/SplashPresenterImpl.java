package com.freakybyte.aliadatest.controller.splash.impl;

import android.os.CountDownTimer;

import com.freakybyte.aliadatest.controller.splash.constructors.SplashPresenter;
import com.freakybyte.aliadatest.controller.splash.constructors.SplashView;

/**
 * Created by Jose Torres in FreakyByte on 09/06/16.
 */
public class SplashPresenterImpl implements SplashPresenter {

    private SplashView mSplashView;
    private CountDownTimer cdTimer = null;


    public SplashPresenterImpl(SplashView splashView) {
        mSplashView = splashView;
    }

    @Override
    public void onStartTimer() {
        if (mSplashView == null)
            return;

        cdTimer = new CountDownTimer(2000, 1500) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                mSplashView.openNextScreen();
            }
        };
        cdTimer.start();
    }


    @Override
    public void onDestroy() {
        mSplashView = null;
    }

}
