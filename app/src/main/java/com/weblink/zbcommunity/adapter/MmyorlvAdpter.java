package com.weblink.zbcommunity.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.weblink.zbcommunity.R;
import com.weblink.zbcommunity.activity.EvaluateActivity;
import com.weblink.zbcommunity.activity.MineThingList;
import com.weblink.zbcommunity.activity.OrderDetailActivity;
import com.weblink.zbcommunity.bean.MinedingdanBean;

import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;


public class MmyorlvAdpter extends BaseAdapter {
    //author��ambitionjz
    private Context context;
    List<MinedingdanBean> datas;
    public static int mPosition;

    public MmyorlvAdpter(Context context, List<MinedingdanBean> datas) {
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
    public View getView(final int position, View convertView, ViewGroup parent) {

        final MinedingdanBean m = datas.get(position);

        convertView = LayoutInflater.from(context).inflate(R.layout.mine_myorder_listviewitem, null);
        TextView storename = (TextView) convertView.findViewById(R.id.mine_myorder_storename);
        ImageView imgone = (ImageView) convertView.findViewById(R.id.mine_myorderlist_img1);
        ImageView imgtwo = (ImageView) convertView.findViewById(R.id.mine_myorderlist_img2);
        ImageView imgthree = (ImageView) convertView.findViewById(R.id.mine_myorderlist_img3);
        TextView jianshu = (TextView) convertView.findViewById(R.id.mine_list_jianshu);
        TextView sandian = (TextView) convertView.findViewById(R.id.mine_sandian);
        TextView money = (TextView) convertView.findViewById(R.id.mine_list_qian);
        Button button3 = (Button) convertView.findViewById(R.id.mine_list_button3);
        Button button2 = (Button) convertView.findViewById(R.id.mine_list_button2);
        Button button1 = (Button) convertView.findViewById(R.id.mine_list_button1);
        final RelativeLayout nn2 = (RelativeLayout) convertView.findViewById(R.id.nn2);
        storename.setText(m.getStorename());
        Glide.with(context).load(m.getImgurlone()).into(imgone);
        Glide.with(context).load(m.getImgurltwo()).into(imgtwo);
        Glide.with(context).load(m.getImgurlthree()).into(imgthree);
        jianshu.setText(m.getThingnum());
        money.setText("¥" + m.getMoneynum());

        //点击商品
        nn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MineThingList.class);
                context.startActivity(intent);
            }
        });


        if (Integer.parseInt(m.getThingnum()) <= 3) {
            sandian.setVisibility(View.GONE);
        }

        switch (m.getId()) {

            case 1:

                button3.setVisibility(View.VISIBLE);
                button3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        new SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE)
                                .setTitleText("取消订单")
                                .setContentText("确定取消这个订单么?")
                                .setCancelText("返回")
                                .setConfirmText("确定")
                                .showCancelButton(true)
                                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                    @Override
                                    public void onClick(SweetAlertDialog sDialog) {
                                        sDialog.dismissWithAnimation();
                                        datas.remove(position);
                                        notifyDataSetChanged();
                                    }
                                })

                                .show();


                    }
                });
                button2.setText("去支付");
                break;
            case 2:
                button3.setVisibility(View.GONE);
                button2.setText("去评价");
                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, EvaluateActivity.class);
                        context.startActivity(intent);
                    }
                });
                break;
            case 3:
                button3.setVisibility(View.GONE);
                button2.setText("再次购买");
                break;
            case 4:
                button3.setVisibility(View.GONE);
                button2.setText("再次购买");
                break;
        }

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, OrderDetailActivity.class);
                switch (m.getId()) {

                    case 1:
                        intent.putExtra("id", "1");
                        context.startActivity(intent);
                        break;
                    case 2:
                        intent.putExtra("id", "2");
                        context.startActivity(intent);
                        break;
                    case 3:
                        intent.putExtra("id", "3");
                        context.startActivity(intent);
                        break;
                    case 4:
                        intent.putExtra("id", "4");
                        context.startActivity(intent);
                        break;

                }
            }
        });

        return convertView;
    }


}
