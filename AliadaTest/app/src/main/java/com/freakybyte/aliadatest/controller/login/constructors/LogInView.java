package com.freakybyte.aliadatest.controller.login.constructors;

/**
 * Created by Jose Torres in FreakyByte on 09/06/16.
 */
public interface LogInView {

    void showLoader(String sMessage, boolean bCancelable);

    void hideLoader();

    void onLogInSuccess();

    void onErrorLoading();

}
