package com.weblink.zbcommunity.fragment;


import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.weblink.zbcommunity.R;
import com.weblink.zbcommunity.activity.LoginActivity;
import com.weblink.zbcommunity.activity.MinecoActivity;
import com.weblink.zbcommunity.activity.MinehelpActivity;
import com.weblink.zbcommunity.activity.MuserinforActivity;
import com.weblink.zbcommunity.activity.MyorderActivity;

public class MineFragment extends Fragment implements OnClickListener {

    RelativeLayout mine_myorder;
    RelativeLayout mine_Relay_Top;
    RelativeLayout mine_mycoupon;
    RelativeLayout mine_kefu;
    RelativeLayout mine_dianhua;
    RelativeLayout mine_exit;
    TextView mine_wei;
    ImageButton left;
    private TextView tv_title;
    String check;


     void getcheck(){
         SharedPreferences settings = this.getActivity().getSharedPreferences("checklogin",0);
         check = settings.getString("checklogin","default");
     }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.mine, container, false);
        left = (ImageButton) contentView.findViewById(R.id.iv_left);
        left.setVisibility(View.GONE);
        mine_wei=(TextView)contentView.findViewById(R.id.mine_sign);
        mine_wei.setOnClickListener(this);
        mine_mycoupon = (RelativeLayout) contentView.findViewById(R.id.mine_Relay_second);
        mine_mycoupon.setOnClickListener(this);
        mine_dianhua = (RelativeLayout) contentView.findViewById(R.id.mine_Relay_four);
        mine_dianhua.setOnClickListener(this);
        mine_kefu = (RelativeLayout) contentView.findViewById(R.id.mine_kefu);//客服
        mine_kefu.setOnClickListener(this);
        mine_exit = (RelativeLayout) contentView.findViewById(R.id.mine_Relay_six);//退出
        mine_exit.setOnClickListener(this);
        tv_title = (TextView) contentView.findViewById(R.id.tv_title);
        tv_title.setText("我的");
        mine_myorder = (RelativeLayout) contentView.findViewById(R.id.mine_Relay_first);//订单
        mine_myorder.setOnClickListener(this);
        mine_Relay_Top = (RelativeLayout) contentView.findViewById(R.id.mine_Relay_Top);
        mine_Relay_Top.setOnClickListener(this);
        getcheck();
        if(check.equals("1"))
        {
            mine_wei.setVisibility(View.GONE);
            mine_exit.setVisibility(View.VISIBLE);
        }
        else{
             mine_exit.setVisibility(View.GONE);
        }

        return contentView;
    }

    @Override
    public void onClick(View v) {
        getcheck();

        //帮助反馈
        if (v == mine_kefu) {
            if(check.equals("1"))
            {
                Intent intenthelp = new Intent(getActivity(), MinehelpActivity.class);
                startActivity(intenthelp);
            }
            else{
                Intent intenteqit = new Intent(getActivity(), LoginActivity.class);
                startActivity(intenteqit);

            }


        }
        //电话号码暂时设定10086
        if (v == mine_dianhua) {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 10086));
            startActivity(intent);
        }
        //我的订单
        if (v == mine_myorder) {
            if(check.equals("1"))
            {
                Intent intentorder = new Intent(getActivity(), MyorderActivity.class);
                startActivity(intentorder);
            }
            else{
                Intent intenteqit = new Intent(getActivity(), LoginActivity.class);
                startActivity(intenteqit);

            }



        }
        //我的购物券
        if (v == mine_mycoupon) {
            if(check.equals("1"))
            {
                Intent intentcoupon = new Intent(getActivity(), MinecoActivity.class);
                startActivity(intentcoupon);
            }
            else{
                Intent intenteqit = new Intent(getActivity(), LoginActivity.class);
                startActivity(intenteqit);

            }


        }
        //退出
        if (v == mine_exit) {
            Intent intenteqit = new Intent(getActivity(), LoginActivity.class);
            startActivity(intenteqit);
        }
        //退出
        if (v == mine_wei) {
            Intent intenteqit = new Intent(getActivity(), LoginActivity.class);
            startActivity(intenteqit);
        }
        //个人信息修改
        if (v == mine_Relay_Top) {

            Intent intentuserinfor = new Intent(getActivity(), MuserinforActivity.class);
            startActivity(intentuserinfor);
        }


    }
}
