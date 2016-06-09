package com.freakybyte.aliadatest.controller.login.ui;

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
import com.freakybyte.aliadatest.util.DebugUtils;

public class LogInActivity extends MainActivity implements LogInView, View.OnClickListener {

    private static final String TAG = "LogInActivity";

    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button btnLogIn;

    private ProgressDialog mLoaderDialog;

    private LogInPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        getBtnLogIn().setOnClickListener(LogInActivity.this);
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

    }

    @Override
    public void onErrorLoading() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogIn:
                getPresenter().onLogIn(getEditTextEmail().getText().toString(), getEditTextPassword().getText().toString());
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
    }

    private LogInPresenter getPresenter() {
        if (mPresenter == null)
            mPresenter = new LogInPresenterImpl(LogInActivity.this);

        return mPresenter;
    }

    private EditText getEditTextEmail() {
        if (editTextEmail == null)
            editTextEmail = (EditText) findViewById(R.id.editTextEmail);

        return editTextEmail;
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
