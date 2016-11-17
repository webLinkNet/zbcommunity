package com.weblink.zbcommunity.activity;


import android.os.Bundle;
import android.widget.TextView;

import com.weblink.zbcommunity.BaseActivity;
import com.weblink.zbcommunity.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by swq on 2016/11/7.
 */
public class GuideActivity extends BaseActivity {


    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tv2)
    TextView tv2;

    @Override
    public void setContent() {

        setContentView(R.layout.activity_guide);
    }

    @Override
    public void initView() {

    }

    @Override
    public void initNet() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
