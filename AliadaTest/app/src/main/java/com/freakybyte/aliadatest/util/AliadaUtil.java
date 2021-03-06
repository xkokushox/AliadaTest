package com.freakybyte.aliadatest.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Jose Torres in FreakyByte on 10/06/16.
 */
public class AliadaUtil {

    public static final String TAG = "AliadaUtil";

    public static String getDateFromString(String date) {
        try {
            Date mDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(date);
            String formattedDate = new SimpleDateFormat("dd/MM/yyyy").format(mDate);
            return formattedDate;
        } catch (Exception ex) {
            DebugUtils.logError(TAG, ex);
            return "";
        }
    }

    public static boolean isInValiedField(String value) {
        return value == null || value.isEmpty() || value.equals("null");
    }
}
