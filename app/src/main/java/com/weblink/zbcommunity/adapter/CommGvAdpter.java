package com.weblink.zbcommunity.adapter;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.weblink.zbcommunity.R;


public class CommGvAdpter extends BaseAdapter {
	//author ambitionjz
	private Context context;
	private String[] strings;
	private String[] gridurl;
	public static int mPosition;
	
	public CommGvAdpter(Context context, String[] strings, String[] gridurl){
		this.context =context;
		this.strings = strings;
		this.gridurl = gridurl;
	}
	
	@Override
	public int getCount() {
		
		return strings.length;
	}

	@Override
	public Object getItem(int position) {
		
		return strings[position];
	}

	
	@Override
	public long getItemId(int position) {
		
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		convertView = LayoutInflater.from(context).inflate(R.layout.commgv_item, null);
		TextView gird_tv = (TextView) convertView.findViewById(R.id.grid_name);
		 final SimpleDraweeView gird_iv=(SimpleDraweeView)convertView.findViewById(R.id.grid_icon);
		mPosition = position;
		gird_tv.setText(strings[position]);
		gird_iv.setImageURI(Uri.parse(gridurl[position]));
		return convertView;
	}


}
