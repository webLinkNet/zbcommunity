package com.weblink.zbcommunity.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.weblink.zbcommunity.R;
import com.weblink.zbcommunity.activity.CommkindActivity;
import com.weblink.zbcommunity.bean.CommodgvBean;

import java.util.List;


public class CommGvAdpter extends BaseAdapter {
    //author ambitionjz
    private Context context;
    private List<CommodgvBean> datas;
    public static int mPosition;

    public CommGvAdpter(Context context, List<CommodgvBean> datas) {
        this.context = context;
        this.datas = datas;
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
        CommodgvBean c= datas.get(position);
        convertView = LayoutInflater.from(context).inflate(R.layout.commgv_item, null);
        TextView gird_tv = (TextView) convertView.findViewById(R.id.grid_name);
        final SimpleDraweeView gird_iv = (SimpleDraweeView) convertView.findViewById(R.id.grid_icon);
        mPosition = position;
        gird_tv.setText(c.getKintext());
        gird_iv.setImageURI(Uri.parse(c.getKinurl()));
        return convertView;
    }


}
