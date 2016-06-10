package com.freakybyte.aliadatest.controller.services.impl;

import com.freakybyte.aliadatest.controller.services.constructors.ServicesInteractor;
import com.freakybyte.aliadatest.controller.services.listener.OnRequestItemsListener;
import com.freakybyte.aliadatest.model.services.ServiceModel;
import com.freakybyte.aliadatest.util.DebugUtils;
import com.freakybyte.aliadatest.util.SharedPreferencesUtil;
import com.freakybyte.aliadatest.web.MyApiEndpointInterface;
import com.freakybyte.aliadatest.web.RetrofitBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Jose Torres in FreakyByte on 09/06/16.
 */
public class ServicesInteractorImpl implements ServicesInteractor {
    public static final String TAG = "ServicesInteractorImpl";

    @Override
    public void getItemsFromServer(final int page, final OnRequestItemsListener mListener) {
        DebugUtils.logDebug(TAG, "getItemsFromServer: Start");

        MyApiEndpointInterface apiService = RetrofitBuilder.getRetrofitBuilder().create(MyApiEndpointInterface.class);

        Call<ServiceModel> call = apiService.getNextServices(SharedPreferencesUtil.getStringPreference(SharedPreferencesUtil.USER_TOKEN), page);
        call.enqueue(new Callback<ServiceModel>() {
            @Override
            public void onResponse(Call<ServiceModel> call, Response<ServiceModel> response) {

                switch (response.code()) {
                    case 200:
                        ServiceModel mService = response.body();

                        DebugUtils.logDebug(TAG, "GetItemsFromServer: Num Services:: " + mService.getServices().size());

                        if (page == 0)
                            mListener.onRequestSuccess(mService.getServices());
                        else
                            mListener.onRequestMoreData(mService.getServices());
                        break;
                    default:
                        DebugUtils.logError("GetItemsFromServer:: Error Code:: " + response.code());
                        mListener.onRequestFailed();
                        break;
                }
            }

            @Override
            public void onFailure(Call<ServiceModel> call, Throwable t) {
                DebugUtils.logError("GetItemsFromServer:: onFailure:: " + t.getLocalizedMessage());
                mListener.onRequestFailed();
            }

        });

    }

}
