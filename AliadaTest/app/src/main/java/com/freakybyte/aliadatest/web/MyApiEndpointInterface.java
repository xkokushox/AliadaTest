package com.freakybyte.aliadatest.web;

import com.freakybyte.aliadatest.model.LogInModel;
import com.freakybyte.aliadatest.model.services.ServiceModel;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Jose Torres in FreakyByte on 09/06/16.
 */
public interface MyApiEndpointInterface {

    @Headers({"Accept: application/vnd.aliada.v1"})
    @FormUrlEncoded
    @POST("sessions/")
    Call<LogInModel> logInServer(@FieldMap Map<String, String> params);

    @Headers({"Accept: application/vnd.aliada.v1"})
    @GET("services?limit=5")
    Call<ServiceModel> getNextServices(@Header("Authorization") String apiToken, @Query("page") int page);

}