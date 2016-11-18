package com.weblink.zbcommunity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;

/**
 * Created by swq on 2016/10/31.
 */
public abstract class BaseActivity extends Activity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContent();
        ButterKnife.bind(this);

        initView();
        initNet();

    }

    public abstract void setContent();

    public abstract void initView();

    public abstract void initNet();


}
