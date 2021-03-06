package com.freakybyte.aliadatest.util;

import android.widget.Toast;

import com.freakybyte.aliadatest.TestApplication;


/**
 * Created by Jose Torres in FreakyByte on 19/04/16.
 */
public class WidgetUtils {

    public static Toast mToast;

    /**
     * Method that creates a short toast based in a String
     *
     * @param message The String that is going to be show
     */
    public static void createShortToast(final String message) {
        TestApplication.getInstance().handlerPost(new Runnable() {
            public void run() {
                if (!isToastShowing()) {
                    mToast = Toast.makeText(TestApplication.getInstance(), message, Toast.LENGTH_SHORT);
                    mToast.show();
                }
            }
        });
    }

    /**
     * Method that creates a long Toast Message based in a string
     *
     * @param message The String that is going to be show
     */
    public static void createLongToast(final String message) {
        TestApplication.getInstance().handlerPost(new Runnable() {
            public void run() {
                if (!isToastShowing()) {
                    mToast = Toast.makeText(TestApplication.getInstance(), message, Toast.LENGTH_LONG);
                    mToast.show();
                }
            }
        });
    }

    /**
     * Method that creates a short Toast based in a string id
     *
     * @param id The Int from the String id
     */
    public static void createShortToast(final int id) {
        TestApplication.getInstance().handlerPost(new Runnable() {
            public void run() {
                if (!isToastShowing()) {
                    mToast = Toast.makeText(TestApplication.getInstance(), TestApplication.getInstance().getString(id), Toast.LENGTH_SHORT);
                    mToast.show();
                }
            }
        });
    }

    /**
     * Method that creates a long Toast Message based in a string id
     *
     * @param id
     */
    public static void createLongToast(final int id) {
        TestApplication.getInstance().handlerPost(new Runnable() {
            public void run() {
                if (!isToastShowing()) {
                    mToast = Toast.makeText(TestApplication.getInstance(), TestApplication.getInstance().getString(id), Toast.LENGTH_LONG);
                    mToast.show();
                }
            }
        });
    }

    private static boolean isToastShowing() {
        if (mToast == null)
            return false;
        else if (mToast.getView().isShown())
            return true;
        else
            return false;
    }

}
