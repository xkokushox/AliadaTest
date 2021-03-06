package com.freakybyte.aliadatest.controller.login.constructors;

import com.freakybyte.aliadatest.controller.login.listener.OnRequestLogInListener;

/**
 * Created by Jose Torres in FreakyByte on 09/06/16.
 */
public interface LogInInteractor {

    void logInInServer(OnRequestLogInListener mListener, String id, String password);

    boolean validateLogInForm(String id, String password);
}
