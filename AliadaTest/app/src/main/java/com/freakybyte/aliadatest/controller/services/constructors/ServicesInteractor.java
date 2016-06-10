package com.freakybyte.aliadatest.controller.services.constructors;

import com.freakybyte.aliadatest.controller.services.listener.OnRequestItemsListener;

/**
 * Created by Jose Torres in FreakyByte on 09/06/16.
 */
public interface ServicesInteractor {

    void getItemsFromServer(int page, OnRequestItemsListener mListener);

}
