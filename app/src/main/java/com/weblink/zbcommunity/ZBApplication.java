package com.weblink.zbcommunity;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by swq on 2016/11/3.
 */
public class ZBApplication extends Application {


    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();

        mContext = getApplicationContext();

        Fresco.initialize(this);


    }

    public static Context getContext() {

        return mContext;
    }
}
