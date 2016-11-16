package com.weblink.zbcommunity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.weblink.zbcommunity.R;


/**
 * Created by Administrator on 2016/11/14.
 */
public class MyhelpLvAdpter extends BaseAdapter {
    private Context context;
    String[] datas;
    public MyhelpLvAdpter(Context context, String[] datas){
        this.context =context;
        this.datas=datas;
    }

    @Override
    public int getCount() {

        return datas.length;
    }

    @Override
    public Object getItem(int position) {

        return datas[position];
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.mine_help_listitem, null);

        TextView last = (TextView) convertView.findViewById(R.id.mine_help_list_text);
        last.setText(datas[position]);
        return convertView;
    }


}


