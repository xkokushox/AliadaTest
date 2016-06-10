package com.freakybyte.aliadatest.controller.services.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.freakybyte.aliadatest.R;
import com.freakybyte.aliadatest.controller.MainActivity;
import com.freakybyte.aliadatest.controller.dialog.ProgressDialog;
import com.freakybyte.aliadatest.controller.login.ui.LogInActivity;
import com.freakybyte.aliadatest.controller.services.adapter.ServiceListAdapter;
import com.freakybyte.aliadatest.controller.services.constructors.ServicesPresenter;
import com.freakybyte.aliadatest.controller.services.constructors.ServicesView;
import com.freakybyte.aliadatest.controller.services.impl.ServicesPresenterImpl;
import com.freakybyte.aliadatest.model.services.ServiceItemModel;
import com.freakybyte.aliadatest.util.DebugUtils;
import com.freakybyte.aliadatest.util.SharedPreferencesUtil;
import com.freakybyte.aliadatest.util.WidgetUtils;

import java.util.List;

/**
 * Created by Jose Torres in FreakyByte on 09/06/16.
 */
public class ServicesActivity extends MainActivity implements ServicesView, View.OnClickListener {

    private static final String TAG = "ServicesActivity";

    private RecyclerView mRecyclerView;
    private TextView txtEmptyView;
    private TextView txtToolbarTitle;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ImageView menuItemLogOut;
    private ProgressDialog mLoaderDialog;
    private Toolbar mToolbar;

    private ServiceListAdapter mAdapter;

    private ServicesPresenter mPresenter;

    private LinearLayoutManager mLayoutManager;

    private boolean bLoading;
    private int iPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_services);

        setSupportActionBar(getToolbar());

        mPresenter = new ServicesPresenterImpl(this);
        getMenuItemLogOut().setOnClickListener(ServicesActivity.this);

        getTxtToolbarTitle().setText(SharedPreferencesUtil.getStringPreference(SharedPreferencesUtil.USER_NAME));

        getSwipeRefreshLayout().setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.onRefreshServiceList();
            }
        });
        getListServices().addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (dy > 0) {
                    if (!bLoading && ((getLayoutManager().getChildCount() + getLayoutManager().findFirstVisibleItemPosition()) >= getLayoutManager().getItemCount())) {
                        bLoading = true;
                        mPresenter.getMoreItems(iPage);
                    }
                }

            }
        });

        getListServices().setAdapter(getListAdapter());

        bLoading = true;
        iPage = 1;

        mPresenter.getItems();
    }


    @Override
    public void showLoader(final String sMessage, final boolean bCancelable) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mLoaderDialog == null || !mLoaderDialog.isShowing()) {
                    mLoaderDialog = new ProgressDialog(ServicesActivity.this, sMessage);
                    mLoaderDialog.setCancelable(bCancelable);
                    mLoaderDialog.show();
                }
            }
        });
    }

    @Override
    public void hideLoader() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                bLoading = false;
                getSwipeRefreshLayout().setRefreshing(false);
                if (mLoaderDialog != null)
                    mLoaderDialog.dismiss();
            }
        });
    }

    @Override
    public void fillAdapter(List<ServiceItemModel> mItems) {
        iPage++;
        getListAdapter().getListServices().clear();
        getListAdapter().getListServices().addAll(mItems);
    }

    @Override
    public void addNewItemsToAdapter(final List<ServiceItemModel> mItems) {
        iPage++;
        getListAdapter().getListServices().addAll(mItems);
    }

    @Override
    public void refreshAdapter() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                getTxtEmptyView().setVisibility(getListAdapter().getListServices().isEmpty() ? View.VISIBLE : View.GONE);
                // getListServices().setVisibility(getListAdapter().getListServices().isEmpty() ? View.GONE : View.VISIBLE);
                getListAdapter().notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onErrorLoading() {
        WidgetUtils.createShortToast(R.string.error_service_retrieve);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.menuItemLogOut:
                SharedPreferencesUtil.setAppPreference(SharedPreferencesUtil.USER_TOKEN, "");
                Intent iPhoneNumber = new Intent(ServicesActivity.this, LogInActivity.class);
                iPhoneNumber.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(iPhoneNumber);
                finish();
                break;
            default:
                DebugUtils.logError(TAG, "Unknown View:: " + v.getId());
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

    private TextView getTxtToolbarTitle() {
        if (txtToolbarTitle == null)
            txtToolbarTitle = (TextView) findViewById(R.id.txtToolbarTitle);

        return txtToolbarTitle;
    }

    private ImageView getMenuItemLogOut() {
        if (menuItemLogOut == null)
            menuItemLogOut = (ImageView) findViewById(R.id.menuItemLogOut);

        return menuItemLogOut;
    }

    private Toolbar getToolbar() {
        if (mToolbar == null)
            mToolbar = (Toolbar) findViewById(R.id.toolbar);
        return mToolbar;
    }

    private TextView getTxtEmptyView() {
        if (txtEmptyView == null)
            txtEmptyView = (TextView) findViewById(R.id.txtEmptyList);
        return txtEmptyView;
    }

    private SwipeRefreshLayout getSwipeRefreshLayout() {
        if (swipeRefreshLayout == null)
            swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        return swipeRefreshLayout;
    }

    private LinearLayoutManager getLayoutManager() {
        if (mLayoutManager == null)
            mLayoutManager = new LinearLayoutManager(ServicesActivity.this);
        return mLayoutManager;
    }

    private RecyclerView getListServices() {
        if (mRecyclerView == null) {
            mRecyclerView = (RecyclerView) findViewById(R.id.listServices);
            mRecyclerView.setLayoutManager(getLayoutManager());
        }
        return mRecyclerView;
    }

    private ServiceListAdapter getListAdapter() {
        if (mAdapter == null)
            mAdapter = new ServiceListAdapter(ServicesActivity.this);
        return mAdapter;
    }

}