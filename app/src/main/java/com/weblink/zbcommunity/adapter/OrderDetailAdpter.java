package com.weblink.zbcommunity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.bumptech.glide.Glide;
import com.weblink.zbcommunity.R;
import com.weblink.zbcommunity.bean.OrderDetailBean;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/24.
 */
public class OrderDetailAdpter extends android.widget.BaseAdapter {
    Context context;
    List<OrderDetailBean> data;

    public OrderDetailAdpter(Context context, List<OrderDetailBean> data) {
        this.context = context;
        this.data = data;

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
        OrderDetailBean o=data.get(position);
        convertView = LayoutInflater.from(context).inflate(R.layout.orderdetailitem, null);
        ViewHolder v=new ViewHolder(convertView);
        v.mineItemStorename.setText(o.getShopname());
        Glide.with(context).load(o.getImg1()).into(v.mineItemImg1);
        Glide.with(context).load(o.getImg2()).into(v.mineItemImg2);
        Glide.with(context).load(o.getImg3()).into(v.mineItemImg3);
        v.mineitemJianshu.setText(o.getNum());
        v.mineItemPrice1.setText("¥"+o.getPrice1());
        v.mineItemPrice2.setText("¥"+o.getPrice2());
        v.mineItemPrice3.setText("¥"+o.getPrice3());
        v.mineItemPrice4.setText("¥"+o.getPrice4());
        v.mineItemPrice5.setText("¥"+o.getPrice5());
        v.mineItemPrice6.setText("¥"+o.getPrice6());
        v.mineItemBeizhu.setText("备注："+o.getBeizhu());
        int a=Integer.parseInt(o.getNum());
        if(a<=3){
            v.mineeSandian.setVisibility(View.GONE);
        }


        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.mine_item_storename)
        TextView mineItemStorename;
        @BindView(R.id.nnn1)
        RelativeLayout nnn1;
        @BindView(R.id.mine_item_img1)
        ImageView mineItemImg1;
        @BindView(R.id.mine_item_img2)
        ImageView mineItemImg2;
        @BindView(R.id.mine_item_img3)
        ImageView mineItemImg3;
        @BindView(R.id.minee_sandian)
        TextView mineeSandian;
        @BindView(R.id.mine_gong)
        TextView mineGong;
        @BindView(R.id.mineitem_jianshu)
        TextView mineitemJianshu;
        @BindView(R.id.mine_jiann)
        TextView mineJiann;
        @BindView(R.id.nnn2)
        RelativeLayout nnn2;
        @BindView(R.id.mine_item_price1)
        TextView mineItemPrice1;
        @BindView(R.id.mine_item_price2)
        TextView mineItemPrice2;
        @BindView(R.id.mine_item_price3)
        TextView mineItemPrice3;
        @BindView(R.id.nnn3)
        RelativeLayout nnn3;
        @BindView(R.id.mine_item_price4)
        TextView mineItemPrice4;
        @BindView(R.id.mine_item_price5)
        TextView mineItemPrice5;
        @BindView(R.id.mine_item_price6)
        TextView mineItemPrice6;
        @BindView(R.id.nnn4)
        RelativeLayout nnn4;
        @BindView(R.id.mine_item_beizhu)
        TextView mineItemBeizhu;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
