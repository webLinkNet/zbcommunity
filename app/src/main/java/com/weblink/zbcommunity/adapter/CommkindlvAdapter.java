package com.weblink.zbcommunity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.weblink.zbcommunity.R;
import com.weblink.zbcommunity.bean.CommkindlvBean;

import java.util.List;

/**
 * Created by Administrator on 2016/11/16.
 */
public class CommkindlvAdapter extends BaseAdapter {

    private Context context;
    List<CommkindlvBean>datas;

    public CommkindlvAdapter(Context context, List<CommkindlvBean>datas){
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
        CommkindlvBean c= datas.get(position);
        convertView = LayoutInflater.from(context).inflate(R.layout.comm_kind_lv_item, null);
        ImageView shopimg= (ImageView)convertView.findViewById(R.id.kind_shopimg);
        ImageView thingimg1= (ImageView)convertView.findViewById(R.id.kind_thingimg1);
        ImageView thingimg2= (ImageView)convertView.findViewById(R.id.kind_thingimg2);
        ImageView thingimg3= (ImageView)convertView.findViewById(R.id.kind_thingimg3);
        TextView shopname  = (TextView)convertView.findViewById(R.id.kind_shopname);
        TextView  thingname1= (TextView)convertView.findViewById(R.id.kind_thingname1);
        TextView thingname2 = (TextView)convertView.findViewById(R.id.kind_thingname2);
        TextView  thingname3= (TextView)convertView.findViewById(R.id.kind_thingname3);
        TextView  money1= (TextView)convertView.findViewById(R.id.kind_money1);
        TextView  money2= (TextView)convertView.findViewById(R.id.kind_money2);
        TextView  money3= (TextView)convertView.findViewById(R.id.kind_money3);

        shopname.setText(c.getShopname());
        thingname1.setText(c.getThingname1());
        thingname2.setText(c.getThingname2());
        thingname3.setText(c.getThingname3());
        money1.setText(c.getPrice1());
        money2.setText(c.getPrice2());
        money3.setText(c.getPrice3());
        Glide.with(context) .load(c.getUrl1()) .into(shopimg);
        Glide.with(context) .load(c.getUrl2()) .into(thingimg1);
        Glide.with(context) .load(c.getUrl3()) .into(thingimg2);
        Glide.with(context) .load(c.getUrl4()) .into(thingimg3);

        return convertView;
    }


}


