package com.weblink.zbcommunity.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by swq on 2016/10/31.
 */
public abstract class BaseActivity extends FragmentActivity {


    private SweetAlertDialog dialog;

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


    public void showLoading() {

        dialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE)
                .setTitleText("玩命加载中");
        dialog.show();
        dialog.setCancelable(false);

    }

    public void cancelLoading() {

        dialog.dismiss();
    }
}
