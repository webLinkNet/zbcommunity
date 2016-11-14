package com.weblink.zbcommunity.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by swq on 2016/11/4.
 */
public class ToastUtils {

    private static Toast toast;

    public static void showToast(Context context, String s) {

        if (toast == null) {

            toast = Toast.makeText(context, s, Toast.LENGTH_LONG);
        } else {
            toast.setText(s);
        }

        toast.show();

    }

}
