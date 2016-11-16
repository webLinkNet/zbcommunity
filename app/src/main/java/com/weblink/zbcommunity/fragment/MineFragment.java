package com.weblink.zbcommunity.fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.weblink.zbcommunity.R;
import com.weblink.zbcommunity.activity.LoginActivity;
import com.weblink.zbcommunity.activity.MinecoActivity;
import com.weblink.zbcommunity.activity.MinehelpActivity;
import com.weblink.zbcommunity.activity.MyorderActivity;
import com.weblink.zbcommunity.activity.MuserinforActivity;

public class MineFragment extends Fragment implements OnClickListener {
	RelativeLayout mine_myorder;
	RelativeLayout mine_Relay_Top;
	RelativeLayout mine_mycoupon;
	RelativeLayout mine_kefu;
	RelativeLayout mine_dianhua;
	TextView mine_exit;
	private TextView tv_title;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
		 Bundle savedInstanceState) {
		View contentView = inflater.inflate(R.layout.mine, container,false);
	    mine_mycoupon=(RelativeLayout)contentView.findViewById(R.id.mine_Relay_second);
	    mine_mycoupon.setOnClickListener(this);
		mine_dianhua=(RelativeLayout)contentView.findViewById(R.id.mine_Relay_four);
		mine_dianhua.setOnClickListener(this);
	    mine_kefu=(RelativeLayout) contentView.findViewById(R.id.mine_kefu);//客服
	    mine_kefu.setOnClickListener(this);
	    mine_exit=(TextView) contentView.findViewById(R.id.mine_exit);//退出
	    mine_exit.setOnClickListener(this);
		tv_title=(TextView) contentView.findViewById(R.id.tv_title);
		tv_title.setText("我的");
	    mine_myorder=(RelativeLayout) contentView.findViewById(R.id.mine_Relay_first);//订单
	    mine_myorder.setOnClickListener(this);
		mine_Relay_Top=(RelativeLayout) contentView.findViewById(R.id.mine_Relay_Top);
		mine_Relay_Top.setOnClickListener(this);
		return contentView;		
	}

	@Override
	public void onClick(View v) {
		//帮助反馈
		if(v==mine_kefu){
			Intent intenthelp = new Intent(getActivity(),MinehelpActivity.class);
			startActivity(intenthelp);
		}
		//电话号码暂时设定10086
		if(v==mine_dianhua){
			Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+10086));
            startActivity(intent);
		}
		//我的订单
		if(v==mine_myorder){
			Intent intentorder=new Intent(getActivity(),MyorderActivity.class);
			startActivity(intentorder);		
		}
		//我的购物券
		if(v==mine_mycoupon)
		{
			Intent intentcoupon = new Intent(getActivity(),MinecoActivity.class);
			startActivity(intentcoupon);
		}
		//退出
		if(v==mine_exit){
			Intent intenteqit =new Intent(getActivity(),LoginActivity.class);
			startActivity(intenteqit);
		}
		//个人信息修改
		if(v==mine_Relay_Top){

           Intent intentuserinfor = new Intent(getActivity(),MuserinforActivity.class);
			startActivity(intentuserinfor);
		}
		
		
	}
}
