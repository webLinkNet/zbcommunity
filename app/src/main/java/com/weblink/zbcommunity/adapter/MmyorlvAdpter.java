package com.weblink.zbcommunity.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.weblink.zbcommunity.R;
import com.weblink.zbcommunity.bean.MinedingdanBean;
import com.weblink.zbcommunity.utils.CircleUtils;

import java.util.List;


public class MmyorlvAdpter extends BaseAdapter {
	//author��ambitionjz
	private Context context;
	List<MinedingdanBean> datas;
	public static int mPosition;
	
	public MmyorlvAdpter(Context context, List<MinedingdanBean> datas){
		this.context =context;
		this.datas=datas;
	}
	
	@Override
	public int getCount() {
		
		return datas.size();
	}

	@Override
	public Object getItem(int position) {
		
		return datas.get(position);
	}

	
	@Override
	public long getItemId(int position) {
		
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		final MinedingdanBean m = datas.get(position);
		
		convertView = LayoutInflater.from(context).inflate(R.layout.mine_myorder_listviewitem, null);
		TextView storename = (TextView) convertView.findViewById(R.id.mine_myorder_storename);
		CircleUtils imgone = (CircleUtils) convertView.findViewById(R.id.mine_myorderlist_img1);
		CircleUtils imgtwo = (CircleUtils) convertView.findViewById(R.id.mine_myorderlist_img2);
		CircleUtils imgthree = (CircleUtils) convertView.findViewById(R.id.mine_myorderlist_img3);
		TextView jianshu = (TextView) convertView.findViewById(R.id.mine_list_jianshu);
		TextView money = (TextView) convertView.findViewById(R.id.mine_list_qian);
		Button button1 = (Button) convertView.findViewById(R.id.mine_list_button1);
		Button button2 = (Button) convertView.findViewById(R.id.mine_list_button2);

		storename.setText(m.getStorename());
		Glide.with(context) .load(m.getImgurlone()) .into(imgone);
		Glide.with(context) .load(m.getImgurltwo()) .into(imgtwo);	
		Glide.with(context) .load(m.getImgurlthree()) .into(imgthree);
		 jianshu.setText(m.getThingnum());
		 money.setText(m.getMoneynum());
		button1.setText(m.getButton1());
		button2.setText(m.getButton2());
		
		return convertView;
	}


}
