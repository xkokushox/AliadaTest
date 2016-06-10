package com.freakybyte.aliadatest.util;

import android.content.res.Resources;
import android.os.Build;
import android.util.TypedValue;

import com.freakybyte.aliadatest.TestApplication;

/**
 * Created by Jose Torres in FreakyByte on 19/04/16.
 */
public class AndroidUtil {


    public static int dpToPx(float dp) {
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, TestApplication.getInstance().getResources().getDisplayMetrics());
        return (int) px;
    }

    public static int dpToPx(float dp, Resources resources) {
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.getDisplayMetrics());
        return (int) px;
    }

    public static boolean isValidField(String sText) {
        return sText != null && !sText.trim().isEmpty();
    }

    public static boolean isValidInteger(String sText) {
        if (!isValidField(sText))
            return false;
        else {
            return sText.matches("\\d+");
        }
    }

    public static boolean isEmailValid(String email) {
        return isValidField(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static boolean isHoneyComb() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
            return true;
        else
            return false;
    }
}
