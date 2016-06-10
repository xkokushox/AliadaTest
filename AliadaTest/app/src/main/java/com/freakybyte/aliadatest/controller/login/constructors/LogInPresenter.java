package com.freakybyte.aliadatest.controller.login.constructors;

/**
 * Created by Jose Torres in FreakyByte on 09/06/16.
 */
public interface LogInPresenter {

    void onLogIn(String id, String password);

    void onDestroy();
}
