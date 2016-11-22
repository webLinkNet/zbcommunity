package com.weblink.zbcommunity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by swq on 2016/11/7.
 */
public abstract class BaseFragment extends Fragment {

    private SweetAlertDialog dialog;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = createView(inflater, container, savedInstanceState);

        initView();
        initNet();

        return view;
    }

    public abstract View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);


    public abstract void initView();

    public abstract void initNet();


    public void showLoading() {

        dialog = new SweetAlertDialog(getActivity(), SweetAlertDialog.PROGRESS_TYPE)
                .setTitleText("玩命加载中");
        dialog.show();
        dialog.setCancelable(false);

    }

    public void cancelLoading() {

        dialog.dismiss();
    }

}
