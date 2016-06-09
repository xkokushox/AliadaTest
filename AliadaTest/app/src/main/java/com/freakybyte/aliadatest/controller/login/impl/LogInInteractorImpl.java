package com.freakybyte.aliadatest.controller.login.impl;

import com.freakybyte.aliadatest.R;
import com.freakybyte.aliadatest.controller.login.constructors.LogInInteractor;
import com.freakybyte.aliadatest.controller.login.listener.OnRequestLogInListener;
import com.freakybyte.aliadatest.util.AndroidUtil;
import com.freakybyte.aliadatest.util.WidgetUtils;

/**
 * Created by Jose Torres in FreakyByte on 09/06/16.
 */
public class LogInInteractorImpl implements LogInInteractor {

    @Override
    public void logInInServer(OnRequestLogInListener mListener) {

    }

    @Override
    public boolean validateLogInForm(String email, String password) {

        if (AndroidUtil.isEmailValid(email) && AndroidUtil.isValidField(password))
            return true;
        else {
            WidgetUtils.createShortToast(R.string.error_login_invalid_form);
            return false;
        }
    }

}
