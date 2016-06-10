package com.freakybyte.aliadatest.controller.services.constructors;

import com.freakybyte.aliadatest.model.services.ServiceItemModel;

import java.util.List;

/**
 * Created by Jose Torres in FreakyByte on 09/06/16.
 */
public interface ServicesView {

    void showLoader(final String sMessage, final boolean bCancelable);

    void hideLoader();

    void fillAdapter(List<ServiceItemModel> mItems);

    void addNewItemsToAdapter(List<ServiceItemModel> mItems);

    void refreshAdapter();

    void onLogOut();

    void onErrorLoading();
}
