package com.weblink.zbcommunity.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.weblink.zbcommunity.R;
import com.weblink.zbcommunity.adapter.MinemycouponListviewAdpter;
import com.weblink.zbcommunity.bean.Mineyouhuiquan;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by ambitionjz on 2016/11/11.
 */
public class Mine_coupon extends Activity implements View.OnClickListener {
    List<Mineyouhuiquan> dataaaa=new ArrayList<Mineyouhuiquan>();
    List<Mineyouhuiquan> dataaa=new ArrayList<Mineyouhuiquan>();
    Mineyouhuiquan data1= new Mineyouhuiquan();
    Mineyouhuiquan data2= new Mineyouhuiquan();
    Mineyouhuiquan data3= new Mineyouhuiquan();
    Mineyouhuiquan data4= new Mineyouhuiquan();
    Mineyouhuiquan data5= new Mineyouhuiquan();
    Button keyong;
    Button shixiao;
    ImageView back;
    ListView mine_couponlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine_coupon);
        keyong = (Button) findViewById(R.id.mine_keyong);
        keyong.setOnClickListener(this);
        shixiao = (Button) findViewById(R.id.mine_zuofei);
        shixiao.setOnClickListener(this);
        back=(ImageView)findViewById(R.id.mine_coupon_back);
        back.setOnClickListener(this);
        mine_couponlist=(ListView)findViewById(R.id.mine_coupon_list);
        indate();
        add(dataaaa);
    }
    void add(List<Mineyouhuiquan> dada){
        MinemycouponListviewAdpter ad= new MinemycouponListviewAdpter(this, dada);
        mine_couponlist.setAdapter(ad);
    }
void indate(){
    data1.setId(1);
    data1.setJiage("005");
    data1.setLeixing("商家");
    data1.setGuize("满10减5");
    data1.setLast("2016年11月1日-2016年11月11日");
    dataaaa.add(data1);
    data2.setId(1);
    data2.setJiage("010");
    data2.setLeixing("平台");
    data2.setGuize("周六满20减10");
    data2.setLast("2016年5月5日-2016年12月11日");
    dataaaa.add(data2);
    data3.setId(1);
    data3.setJiage("110");
    data3.setLeixing("平台");
    data3.setGuize("周天满200减110");
    data3.setLast("2016年5月5日-2016年12月11日");
    dataaaa.add(data3);
    data4.setId(2);
    data4.setJiage("008");
    data4.setLeixing("平台");
    data4.setGuize("满200减8");
    data4.setLast("2015年8月8日已使用");
    dataaa.add(data4);
    data5.setId(2);
    data5.setJiage("222");
    data5.setLeixing("商家");
    data5.setGuize("周天满2000减222");
    data5.setLast("2016年5月5日已过期");
    dataaa.add(data5);

}
    void colorz(){
        keyong.setBackgroundColor(Color.parseColor("#33CC33"));
        shixiao.setBackgroundColor(Color.parseColor("#33CC33"));
    }
    @Override
    public void onClick(View v) {
        if(v==back){
            finish();

        }
        if (v == keyong) {
            colorz();
            keyong.setBackgroundColor(Color.parseColor("#FF6600"));
            add(dataaaa);
        }
        if (v == shixiao) {
            colorz();
            shixiao.setBackgroundColor(Color.parseColor("#FF6600"));
            add(dataaa);
        }
    }
}