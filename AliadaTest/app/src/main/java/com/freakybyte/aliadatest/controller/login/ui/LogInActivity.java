package com.freakybyte.aliadatest.controller.login.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.freakybyte.aliadatest.R;
import com.freakybyte.aliadatest.controller.MainActivity;
import com.freakybyte.aliadatest.controller.dialog.ProgressDialog;
import com.freakybyte.aliadatest.controller.login.constructors.LogInPresenter;
import com.freakybyte.aliadatest.controller.login.constructors.LogInView;
import com.freakybyte.aliadatest.controller.login.impl.LogInPresenterImpl;
import com.freakybyte.aliadatest.controller.services.ui.ServicesActivity;
import com.freakybyte.aliadatest.util.AndroidUtil;
import com.freakybyte.aliadatest.util.DebugUtils;
import com.freakybyte.aliadatest.util.WidgetUtils;

public class LogInActivity extends MainActivity implements LogInView, View.OnClickListener {

    private static final String TAG = "LogInActivity";

    private EditText editTextId;
    private EditText editTextPassword;
    private Button btnLogIn;

    private ProgressDialog mLoaderDialog;

    private LogInPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        getBtnLogIn().setOnClickListener(LogInActivity.this);

        if (!AndroidUtil.isHoneyComb()) {
            getEditTextId().setTextColor(getResources().getColor(R.color.black));
            getEditTextId().setHintTextColor(getResources().getColor(R.color.black_60));
            getEditTextPassword().setTextColor(getResources().getColor(R.color.black));
            getEditTextPassword().setHintTextColor(getResources().getColor(R.color.black_60));
        }

    }

    @Override
    public void showLoader(final String sMessage, final boolean bCancelable) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mLoaderDialog == null || !mLoaderDialog.isShowing()) {
                    mLoaderDialog = new ProgressDialog(LogInActivity.this, sMessage);
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
                if (mLoaderDialog != null)
                    mLoaderDialog.dismiss();
            }
        });
    }

    @Override
    public void onLogInSuccess() {
        Intent mIntentServices = new Intent(LogInActivity.this, ServicesActivity.class);
        mIntentServices.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(mIntentServices);
        finish();
    }

    @Override
    public void onErrorLoading() {
        WidgetUtils.createShortToast(R.string.error_login_server);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogIn:
                getPresenter().onLogIn(getEditTextId().getText().toString(), getEditTextPassword().getText().toString());
                break;
            default:
                DebugUtils.logError(TAG, "Unknown View:: " + v.getId());
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getPresenter().onDestroy();
        mLoaderDialog = null;
        mPresenter = null;
    }

    private LogInPresenter getPresenter() {
        if (mPresenter == null)
            mPresenter = new LogInPresenterImpl(LogInActivity.this);

        return mPresenter;
    }

    private EditText getEditTextId() {
        if (editTextId == null)
            editTextId = (EditText) findViewById(R.id.editTextId);

        return editTextId;
    }

    private EditText getEditTextPassword() {
        if (editTextPassword == null)
            editTextPassword = (EditText) findViewById(R.id.editTextPassword);

        return editTextPassword;
    }

    private Button getBtnLogIn() {
        if (btnLogIn == null)
            btnLogIn = (Button) findViewById(R.id.btnLogIn);

        return btnLogIn;
    }


}
