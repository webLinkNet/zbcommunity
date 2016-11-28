package com.weblink.zbcommunity.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import android.widget.BaseAdapter;


import com.weblink.zbcommunity.R;
import com.weblink.zbcommunity.activity.EditAdressActivity;
import com.weblink.zbcommunity.bean.AdressBean;

import java.util.List;


/**
 * Created by Administrator on 2016/11/28.
 */
public class ChooseadressAdpter extends BaseAdapter {
    List<AdressBean> data;
    Context context;


    public ChooseadressAdpter(Context context, List<AdressBean> data) {
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
        AdressBean a = data.get(position);

        convertView = LayoutInflater.from(context).inflate(R.layout.chooseadressitem, null);

        ImageView ived = (ImageView) convertView.findViewById(R.id.adress_edit);
        CheckBox cb = (CheckBox) convertView.findViewById(R.id.adress_moren);
        TextView andressName = (TextView) convertView.findViewById(R.id.andress_name);
        TextView andressTel = (TextView) convertView.findViewById(R.id.andress_tel);
        TextView andressAdresss = (TextView) convertView.findViewById(R.id.andress_adresss);
        final int i = a.getMoren();

        ived.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EditAdressActivity.class);
                intent.putExtra("kind","bianji");
                context.startActivity(intent);
            }
        });
        switch (i) {

            case 1:
                cb.setChecked(true);
                break;
            case 2:
                cb.setChecked(false);
                break;
        }
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 2) {
                    new AlertDialog.Builder(context)
                            .setTitle("默认地址")
                            .setMessage("确定将此项设为默认收货地址？")
                            .setPositiveButton("是", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    //传输后台设为默认地址
                                    notifyDataSetChanged();
                                }
                            })
                            .setNegativeButton("否", null)
                            .show();
                }
            }
        });


        andressName.setText(a.getAdressname());
        andressTel.setText(a.getAdressphone());
        andressAdresss.setText(a.getAdressadress());
        return convertView;
    }

}
