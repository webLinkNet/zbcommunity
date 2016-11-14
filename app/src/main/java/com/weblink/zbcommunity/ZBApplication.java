package com.weblink.zbcommunity;

import android.app.Application;
import android.content.Context;

import com.baidu.mapapi.SDKInitializer;
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
        SDKInitializer.initialize(this.getApplicationContext());


    }

    public static Context getContext() {

        return mContext;
    }
}
