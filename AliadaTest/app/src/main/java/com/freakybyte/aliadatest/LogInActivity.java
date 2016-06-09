package com.freakybyte.aliadatest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class LogInActivity extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button btnLogIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
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
