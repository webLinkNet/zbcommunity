package com.weblink.zbcommunity.utils;

import android.app.Application;

/**
 * Created by Administrator on 2016/12/1.
 */
public class CheckLogin extends Application {
    private  int checklogin=0;

    public void onCreate() {
        super.onCreate();

    }
    public int getChecklogin() {
        return checklogin;
    }

    public void setChecklogin(int checklogin) {
        this.checklogin = checklogin;
    }
}
