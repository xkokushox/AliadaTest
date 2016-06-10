package com.freakybyte.aliadatest.controller.services.constructors;

/**
 * Created by Jose Torres in FreakyByte on 09/06/16.
 */
public interface ServicesPresenter {

    void getItems();

    void getMoreItems(int items);

    void onRefreshServiceList();

    void onDestroy();
}
