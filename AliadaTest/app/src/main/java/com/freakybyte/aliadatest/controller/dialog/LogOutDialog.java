package com.freakybyte.aliadatest.controller.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.freakybyte.aliadatest.R;
import com.freakybyte.aliadatest.ui.material.ButtonFlat;


/**
 * Created by Jose Torres on 9/30/15.
 */
public class LogOutDialog extends android.app.Dialog {

    Context context;
    View view;
    View backView;
    String message;
    private TextView messageTextView;
    String title;
    TextView titleTextView;

    ButtonFlat buttonAccept;
    ButtonFlat buttonCancel;

    String buttonCancelText;
    String buttonAcceptText;

    View.OnClickListener onAcceptButtonClickListener;
    View.OnClickListener onCancelButtonClickListener;

    public LogOutDialog(Context context, String title, String message) {
        super(context, android.R.style.Theme_Translucent);
        this.context = context;// init Context
        this.message = message;
        this.title = title;
    }

    public void addCancelButton(String buttonCancelText, View.OnClickListener onCancelButtonClickListener) {
        this.buttonCancelText = buttonCancelText;
        this.onCancelButtonClickListener = onCancelButtonClickListener;
    }


    public void addAcceptButton(String buttonAcceptText, View.OnClickListener onAcceptButtonClickListener) {
        this.buttonAcceptText = buttonAcceptText;
        this.onAcceptButtonClickListener = onAcceptButtonClickListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_log_out);

        view = (RelativeLayout) findViewById(R.id.contentDialog);
        backView = (RelativeLayout) findViewById(R.id.dialog_rootView);

        backView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getX() < view.getLeft()
                        || event.getX() > view.getRight()
                        || event.getY() > view.getBottom()
                        || event.getY() < view.getTop()) {
                    dismiss();
                }
                return false;
            }
        });

        this.titleTextView = (TextView) findViewById(R.id.title);

        if (title == null) {
            this.titleTextView.setVisibility(View.GONE);
        } else
            setTitle(title);

        this.messageTextView = (TextView) findViewById(R.id.txt_message);
        setMessage(message);

        this.buttonAccept = (ButtonFlat) findViewById(R.id.button_accept);
        this.buttonAccept.setText(buttonAcceptText);
        buttonAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                if (onAcceptButtonClickListener != null)
                    onAcceptButtonClickListener.onClick(v);
            }
        });

        if (buttonCancelText != null) {
            this.buttonCancel = (ButtonFlat) findViewById(R.id.button_cancel);
            this.buttonCancel.setVisibility(View.VISIBLE);
            this.buttonCancel.setText(buttonCancelText);
            buttonCancel.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    dismiss();
                    if (onCancelButtonClickListener != null)
                        onCancelButtonClickListener.onClick(v);
                }
            });
        }
    }

    @Override
    public void show() {
        super.show();
        // set dialog enter animations
        view.startAnimation(AnimationUtils.loadAnimation(context, R.anim.dialog_main_show_amination));
        backView.startAnimation(AnimationUtils.loadAnimation(context, R.anim.dialog_root_show_amin));
    }

    // GETERS & SETTERS

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        messageTextView.setText(message);
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        if (title == null)
            titleTextView.setVisibility(View.GONE);
        else {
            titleTextView.setVisibility(View.VISIBLE);
            titleTextView.setText(title);
        }
    }

    public TextView getTitleTextView() {
        return titleTextView;
    }

    public void setTitleTextView(TextView titleTextView) {
        this.titleTextView = titleTextView;
    }

    public ButtonFlat getButtonAccept() {
        return buttonAccept;
    }

    public void setButtonAccept(ButtonFlat buttonAccept) {
        this.buttonAccept = buttonAccept;
    }

    public ButtonFlat getButtonCancel() {
        return buttonCancel;
    }

    public void setButtonCancel(ButtonFlat buttonCancel) {
        this.buttonCancel = buttonCancel;
    }

    public void setOnAcceptButtonClickListener(View.OnClickListener onAcceptButtonClickListener) {
        this.onAcceptButtonClickListener = onAcceptButtonClickListener;
        if (buttonAccept != null)
            buttonAccept.setOnClickListener(onAcceptButtonClickListener);
    }

    public void setOnCancelButtonClickListener(View.OnClickListener onCancelButtonClickListener) {
        this.onCancelButtonClickListener = onCancelButtonClickListener;
        if (buttonCancel != null)
            buttonCancel.setOnClickListener(onCancelButtonClickListener);
    }

}
