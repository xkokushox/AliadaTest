package com.freakybyte.aliadatest.controller.login.impl;

import com.freakybyte.aliadatest.R;
import com.freakybyte.aliadatest.controller.login.constructors.LogInInteractor;
import com.freakybyte.aliadatest.controller.login.listener.OnRequestLogInListener;
import com.freakybyte.aliadatest.model.LogInModel;
import com.freakybyte.aliadatest.util.AndroidUtil;
import com.freakybyte.aliadatest.util.DebugUtils;
import com.freakybyte.aliadatest.util.SharedPreferencesUtil;
import com.freakybyte.aliadatest.util.WidgetUtils;
import com.freakybyte.aliadatest.web.MyApiEndpointInterface;
import com.freakybyte.aliadatest.web.RetrofitBuilder;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Jose Torres in FreakyByte on 09/06/16.
 */
public class LogInInteractorImpl implements LogInInteractor {
    public static final String TAG = "LogInInteractorImpl";

    @Override
    public void logInInServer(final OnRequestLogInListener mListener, String id, String password) {
        DebugUtils.logDebug(TAG, "GetItemsFromServer: Start");

        MyApiEndpointInterface apiService = RetrofitBuilder.getRetrofitBuilder().create(MyApiEndpointInterface.class);

        Map<String, String> params = new HashMap<>();
        params.put("aliada_id", id);
        params.put("password", password);

        Call<LogInModel> call = apiService.logInServer(params);
        call.enqueue(new Callback<LogInModel>() {
            @Override
            public void onResponse(Call<LogInModel> call, Response<LogInModel> response) {

                switch (response.code()) {
                    case 200:
                        LogInModel mSession = response.body();

                        SharedPreferencesUtil.setAppPreference(SharedPreferencesUtil.USER_TOKEN, mSession.getSession().getApiToken());
                        SharedPreferencesUtil.setAppPreference(SharedPreferencesUtil.USER_NAME, mSession.getSession().getFullName());
                        DebugUtils.logDebug(TAG, "LogInInServer: AuthToken:: " + mSession.getSession().getApiToken());

                        mListener.onRequestSuccess();
                        break;
                    default:
                        DebugUtils.logError("LogInInServer:: Error Code:: " + response.code());
                        mListener.onRequestFailed();
                        break;
                }
            }

            @Override
            public void onFailure(Call<LogInModel> call, Throwable t) {
                DebugUtils.logError("LogInInServer:: onFailure:: " + t.getLocalizedMessage());
                mListener.onRequestFailed();
            }

        });
    }

    @Override
    public boolean validateLogInForm(String id, String password) {

        if (AndroidUtil.isValidInteger(id) && AndroidUtil.isValidField(password))
            return true;
        else {
            WidgetUtils.createShortToast(R.string.error_login_invalid_form);
            return false;
        }
    }

}
