package com.weblink.zbcommunity.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.weblink.zbcommunity.R;
import com.weblink.zbcommunity.bean.Mineyouhuiquan;

import java.util.List;


public class MinemycouponListviewAdpter extends BaseAdapter {
    //author??ambitionjz
    private Context context;
    List<Mineyouhuiquan> datas;
    public MinemycouponListviewAdpter(Context context, List<Mineyouhuiquan> datas){
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

        final Mineyouhuiquan m = datas.get(position);

        convertView = LayoutInflater.from(context).inflate(R.layout.mine_coupon_listviewitem, null);
       TextView zi =(TextView) convertView.findViewById(R.id.mine_coupon_zi);
        TextView jiage = (TextView) convertView.findViewById(R.id.mine_coupon_num);
        LinearLayout lin =(LinearLayout)convertView.findViewById(R.id.mine_coupon_yanse);
        TextView leixing = (TextView) convertView.findViewById(R.id.mine_coupon_leixing);
        TextView guize  = (TextView) convertView.findViewById(R.id.mine_coupon_guize);
        TextView last = (TextView) convertView.findViewById(R.id.mine_coupon_last);
        if(m.getId()==1){
            zi.setText("有效日期");
            lin.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }
        if(m.getId()==2){
            zi.setText("作废原因");
            lin.setBackgroundColor(Color.parseColor("#CCCCCC"));
        }
        jiage.setText(m.getJiage());
        leixing.setText(m.getLeixing());
        guize.setText(m.getGuize());
        last.setText(m.getLast());


        return convertView;
    }


}

