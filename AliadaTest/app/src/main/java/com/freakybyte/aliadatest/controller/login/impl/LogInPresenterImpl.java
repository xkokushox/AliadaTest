package com.freakybyte.aliadatest.controller.login.impl;

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
    public void onLogIn(String email, String password) {
        if (mLogInView == null)
            return;

        if (mLogInInteractor.validateLogInForm(email, password))
            mLogInInteractor.logInInServer(LogInPresenterImpl.this);

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onRequestFailed() {

    }

    @Override
    public void onRequestSuccess() {

    }
}
