package com.freakybyte.aliadatest.controller.services.impl;

import com.freakybyte.aliadatest.R;
import com.freakybyte.aliadatest.TestApplication;
import com.freakybyte.aliadatest.controller.services.constructors.ServicesPresenter;
import com.freakybyte.aliadatest.controller.services.constructors.ServicesView;
import com.freakybyte.aliadatest.controller.services.listener.OnRequestItemsListener;
import com.freakybyte.aliadatest.model.services.ServiceItemModel;
import com.freakybyte.aliadatest.util.WidgetUtils;

import java.util.List;

/**
 * Created by Jose Torres in FreakyByte on 09/06/16.
 */
public class ServicesPresenterImpl implements ServicesPresenter, OnRequestItemsListener {

    private ServicesView mServicesView;
    private ServicesInteractorImpl mHomeInteractor;

    public ServicesPresenterImpl(ServicesView homeView) {
        mServicesView = homeView;
        mHomeInteractor = new ServicesInteractorImpl();
    }

    @Override
    public void getItems() {
        if (mServicesView == null)
            return;

        mServicesView.showLoader(TestApplication.getInstance().getString(R.string.txt_progress_loader_label), false);
        mHomeInteractor.getItemsFromServer(1, this);
    }

    @Override
    public void getMoreItems(int nItems) {
        if (mServicesView == null)
            return;

        mHomeInteractor.getItemsFromServer(nItems, this);
    }

    @Override
    public void onRefreshServiceList() {
        if (mServicesView == null)
            return;

        mHomeInteractor.getItemsFromServer(1, this);
    }


    @Override
    public void onDestroy() {
        mServicesView = null;
        mHomeInteractor = null;
    }

    @Override
    public void onRequestFailed() {
        if (mServicesView == null)
            return;

        mServicesView.onErrorLoading();
        mServicesView.refreshAdapter();
        mServicesView.hideLoader();
    }

    @Override
    public void onRequestSuccess(List<ServiceItemModel> mList) {
        if (mServicesView == null)
            return;

        mServicesView.fillAdapter(mList);
        mServicesView.refreshAdapter();
        mServicesView.hideLoader();
    }

    @Override
    public void onRequestMoreData(List<ServiceItemModel> mList) {
        if (mServicesView == null)
            return;

        mServicesView.addNewItemsToAdapter(mList);
        mServicesView.refreshAdapter();
        mServicesView.hideLoader();
    }

    @Override
    public void onAuthenticationFailure() {
        if (mServicesView == null)
            return;

        WidgetUtils.createShortToast(R.string.error_problem_authentication);
        mServicesView.onLogOut();
    }

}
