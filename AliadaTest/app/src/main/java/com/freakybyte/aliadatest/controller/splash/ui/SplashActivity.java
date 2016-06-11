package com.freakybyte.aliadatest.controller.splash.ui;

import android.content.Intent;
import android.os.Bundle;

import com.freakybyte.aliadatest.R;
import com.freakybyte.aliadatest.controller.MainActivity;
import com.freakybyte.aliadatest.controller.login.ui.LogInActivity;
import com.freakybyte.aliadatest.controller.services.ui.ServicesActivity;
import com.freakybyte.aliadatest.controller.splash.constructors.SplashPresenter;
import com.freakybyte.aliadatest.controller.splash.constructors.SplashView;
import com.freakybyte.aliadatest.controller.splash.impl.SplashPresenterImpl;
import com.freakybyte.aliadatest.util.SharedPreferencesUtil;

/**
 * Created by Jose Torres in FreakyByte on 09/06/16.
 */
public class SplashActivity extends MainActivity implements SplashView {

    private SplashPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (!isTaskRoot()) {
            final Intent intent = getIntent();
            final String intentAction = intent.getAction();
            if (intent != null && intent.hasCategory(Intent.CATEGORY_LAUNCHER) && intentAction != null && intentAction.equals(Intent.ACTION_MAIN)) {
                finish();
                return;
            }
        }

        mPresenter = new SplashPresenterImpl(SplashActivity.this);

        mPresenter.onStartTimer();
    }

    @Override
    public void openNextScreen() {
        Intent mIntentNext;

        if (SharedPreferencesUtil.getStringPreference(SharedPreferencesUtil.USER_TOKEN).isEmpty())
            mIntentNext = new Intent(SplashActivity.this, LogInActivity.class);
        else
            mIntentNext = new Intent(SplashActivity.this, ServicesActivity.class);

        mIntentNext.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(mIntentNext);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.onDestroy();
    }
}
