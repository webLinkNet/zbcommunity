package com.weblink.zbcommunity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.weblink.zbcommunity.R;
import com.weblink.zbcommunity.bean.CommodgvBean;
import com.weblink.zbcommunity.utils.ToastUtils;

import java.util.List;


/**
 * Created by Administrator on 2016/11/22.
 */
public class EvaluateAdpter extends android.widget.BaseAdapter {
    Context context;
    List<CommodgvBean> data;

    public EvaluateAdpter(Context context, List<CommodgvBean> data) {
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        CommodgvBean c = data.get(position);
        convertView = LayoutInflater.from(context).inflate(R.layout.evaluate_item, parent, false);
        TextView shopname = (TextView) convertView.findViewById(R.id.eva_thingname);
        ImageView shopimg = (ImageView) convertView.findViewById(R.id.eva_thingimg);
        Button bu = (Button) convertView.findViewById(R.id.eval_butt);
        final RatingBar ra = (RatingBar) convertView.findViewById(R.id.eva_rating);
        final EditText ed = (EditText) convertView.findViewById(R.id.eva_eva);
        bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ra.getRating() >= 1) {
                    //评价提交界面
                    data.remove(position);
                    notifyDataSetChanged();
                } else {
                    ToastUtils.showToast(context, "请评分1到5颗星 谢谢");
                }
            }
        });
        shopname.setText(c.getKintext());
        Glide.with(context).load(c.getKinurl()).into(shopimg);
        return convertView;
    }
}
