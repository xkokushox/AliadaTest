package com.freakybyte.aliadatest.controller.login.impl;

import com.freakybyte.aliadatest.R;
import com.freakybyte.aliadatest.TestApplication;
import com.freakybyte.aliadatest.controller.login.constructors.LogInPresenter;
import com.freakybyte.aliadatest.controller.login.constructors.LogInView;
import com.freakybyte.aliadatest.controller.login.listener.OnRequestLogInListener;

/**
 * Created by Jose Torres in FreakyByte on 09/06/16.
 */
public class LogInPresenterImpl implements LogInPresenter, OnRequestLogInListener {

    private LogInView mLogInView;
    private LogInInteractorImpl mLogInInteractor;

    public LogInPresenterImpl(LogInView logInView) {
        mLogInView = logInView;
        mLogInInteractor = new LogInInteractorImpl();
    }

    @Override
    public void onLogIn(String id, String password) {
        if (mLogInView == null)
            return;

        if (mLogInInteractor.validateLogInForm(id, password)) {
            mLogInView.showLoader(TestApplication.getInstance().getString(R.string.txt_progress_loader_label), false);
            mLogInInteractor.logInInServer(LogInPresenterImpl.this, id, password);
        }

    }

    @Override
    public void onDestroy() {
        mLogInView = null;
        mLogInInteractor = null;
    }

    @Override
    public void onRequestFailed() {
        if (mLogInView == null)
            return;

        mLogInView.hideLoader();
        mLogInView.onErrorLoading();
    }

    @Override
    public void onRequestSuccess() {
        if (mLogInView == null)
            return;

        mLogInView.hideLoader();
        mLogInView.onLogInSuccess();
    }
}
