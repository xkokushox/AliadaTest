package com.freakybyte.aliadatest.controller.services.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.freakybyte.aliadatest.R;
import com.freakybyte.aliadatest.controller.MainActivity;
import com.freakybyte.aliadatest.controller.dialog.LogOutDialog;
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
    private TextView txtToolbarSubtitle;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ImageView menuItemLogOut;
    private Toolbar mToolbar;
    private LinearLayout mLayoutToolbarWrapper;

    private ProgressDialog mLoaderDialog;
    private LogOutDialog mLogOutDialog;

    private ServiceListAdapter mAdapter;

    private ServicesPresenter mPresenter;

    private LinearLayoutManager mLayoutManager;

    private boolean bLoading;
    private boolean bDownloadMore;
    private int iPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_services);

        setSupportActionBar(getToolbar());

        mPresenter = new ServicesPresenterImpl(this);
        bDownloadMore = true;

        getTxtToolbarTitle().setText(SharedPreferencesUtil.getStringPreference(SharedPreferencesUtil.USER_NAME));

        getSwipeRefreshLayout().setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                bDownloadMore = true;
                mPresenter.onRefreshServiceList();
            }
        });
        getListServices().addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (dy > 0) {
                    if (!bLoading && bDownloadMore && ((getLayoutManager().getChildCount() + getLayoutManager().findFirstVisibleItemPosition()) >= getLayoutManager().getItemCount())) {
                        WidgetUtils.createShortToast(R.string.txt_toast_download);
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

        getMenuItemLogOut().setOnClickListener(ServicesActivity.this);
        getLayoutToolbarWrapper().setOnClickListener(ServicesActivity.this);
    }

    public void onLogoutPressed() {
        DebugUtils.logDebug(TAG, "onLogoutPressed");

        if (mLogOutDialog == null || !mLogOutDialog.isShowing()) {
            mLogOutDialog = new LogOutDialog(ServicesActivity.this, getString(R.string.txt_dialog_title_logout), getString(R.string.txt_dialog_body_logout));
            mLogOutDialog.addAcceptButton(getString(R.string.txt_dialog_yes), new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onLogOut();
                }
            });
            mLogOutDialog.addCancelButton(getString(R.string.txt_dialog_no), null);
            mLogOutDialog.show();
        }
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
        iPage = 2;
        getListAdapter().getListServices().clear();
        getListAdapter().getListServices().addAll(mItems);

    }

    @Override
    public void addNewItemsToAdapter(final List<ServiceItemModel> mItems) {
        if (mItems.size() == 0)
            bDownloadMore = false;
        else {
            iPage++;
            getListAdapter().getListServices().addAll(mItems);
        }
    }

    @Override
    public void refreshAdapter() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                getTxtEmptyView().setVisibility(getListAdapter().getListServices().isEmpty() ? View.VISIBLE : View.GONE);
                getListAdapter().notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onLogOut() {
        SharedPreferencesUtil.setAppPreference(SharedPreferencesUtil.USER_TOKEN, "");
        Intent mIntentLogIn = new Intent(ServicesActivity.this, LogInActivity.class);
        mIntentLogIn.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(mIntentLogIn);
        finish();
    }

    @Override
    public void onErrorLoading() {
        WidgetUtils.createShortToast(R.string.error_service_retrieve);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.menuItemLogOut:
                onLogoutPressed();
                break;
            case R.id.layoutToolbarWrapper:
                getListServices().smoothScrollToPosition(0);
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
        if (txtToolbarSubtitle == null)
            txtToolbarSubtitle = (TextView) findViewById(R.id.txtToolbarSubtitle);

        return txtToolbarSubtitle;
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

    private LinearLayout getLayoutToolbarWrapper() {
        if (mLayoutToolbarWrapper == null)
            mLayoutToolbarWrapper = (LinearLayout) findViewById(R.id.layoutToolbarWrapper);
        return mLayoutToolbarWrapper;
    }

}