package com.freakybyte.aliadatest.controller.services.listener;

import com.freakybyte.aliadatest.model.services.ServiceItemModel;

import java.util.List;

/**
 * Created by Jose Torres in FreakyByte on 01/06/16.
 */
public interface OnRequestItemsListener {

    void onRequestFailed();

    void onRequestSuccess(List<ServiceItemModel> mList);

    void onRequestMoreData(List<ServiceItemModel> mList);

    void onAuthenticationFailure();

}
