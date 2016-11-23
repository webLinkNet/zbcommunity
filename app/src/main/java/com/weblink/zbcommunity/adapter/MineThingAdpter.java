package com.weblink.zbcommunity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.weblink.zbcommunity.R;
import com.weblink.zbcommunity.bean.MineThingListBean;

import java.util.List;

/**
 * Created by Administrator on 2016/11/23.
 */
public class MineThingAdpter extends android.widget.BaseAdapter {
    Context context;
    List<MineThingListBean>data;
    public MineThingAdpter(    Context context,List<MineThingListBean>data){
        this.context=context;
        this.data=data;

    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MineThingListBean m=data.get(position);

        convertView= LayoutInflater.from(context).inflate(R.layout.mine_order_thing_item,null);
        ImageView img=(ImageView) convertView.findViewById(R.id.mine_thing_img);
        TextView shop = (TextView)convertView.findViewById(R.id.mine_thing_shop);
        TextView prize = (TextView)convertView.findViewById(R.id.mine_thing_price);
        TextView num = (TextView)convertView.findViewById(R.id.mine_thing_num);
        TextView zong = (TextView)convertView.findViewById(R.id.mine_thing_zong);

        Glide.with(context).load(m.getImg()).into(img);
        shop.setText(m.getShopname());
        prize.setText("¥ "+m.getPrice());
        num.setText("× "+m.getNum());
        zong.setText(m.getZong());

        return convertView;
    }
}
