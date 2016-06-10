package com.freakybyte.aliadatest.web;

import com.freakybyte.aliadatest.R;
import com.freakybyte.aliadatest.TestApplication;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Jose Torres in FreakyByte on 07/06/16.
 */
public class RetrofitBuilder {

    private static Retrofit retrofit;

    public static Retrofit getRetrofitBuilder() {
        if (retrofit == null)
            retrofit = new Retrofit.Builder()
                    .baseUrl(TestApplication.getInstance().getString(R.string.url_base))
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        return retrofit;
    }
}
