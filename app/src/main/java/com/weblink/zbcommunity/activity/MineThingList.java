package com.weblink.zbcommunity.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import com.weblink.zbcommunity.R;
import com.weblink.zbcommunity.adapter.MineThingAdpter;
import com.weblink.zbcommunity.bean.MineThingListBean;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/23.
 */

public class MineThingList extends Activity {

    MineThingAdpter ad;
    List<MineThingListBean> data=new ArrayList<>();
    MineThingListBean da1=new MineThingListBean();
    MineThingListBean da2=new MineThingListBean();
    MineThingListBean da3=new MineThingListBean();
    MineThingListBean da4=new MineThingListBean();
    ListView listView;
    TextView text;
    TextView top;
    ImageButton im;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.mine_order_thing);

        top=(TextView)findViewById(R.id.tv_title);
        top.setText("商品清单");
        text=(TextView)findViewById(R.id.tv_left);
        text.setVisibility(View.GONE);
        im=(ImageButton)findViewById(R.id.iv_left);
        im.setVisibility(View.VISIBLE);
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        listView = (ListView) findViewById(R.id.mine_thing_lv);
        initView();
        ad=new MineThingAdpter(this,data);
        listView.setAdapter(ad);

    }
        public void initView(){

            da1.setImg("http://pic44.nipic.com/20140716/5624623_145624181000_2.jpg");
            da1.setShopname("布尼斯并欺凌蛋糕");
            da1.setPrice("206.1");
            da1.setNum("3");
            da1.setZong("1023.24");
            data.add(da1);
            da2.setImg("http://www.xitongcheng.cc/uploads/allimg/151113/1-151113152024.jpg");
            da2.setShopname("张小二笔记本重装");
            da2.setPrice("3.20");
            da2.setNum("4");
            da2.setZong("12.80");
            data.add(da2);
            da3.setImg("http://pic.58pic.com/58pic/13/68/60/86458PICFGJ_1024.jpg");
            da3.setShopname("布尼斯并欺凌蛋糕");
            da3.setPrice("206.1");
            da3.setNum("3");
            da3.setZong("1023.24");
            data.add(da3);
            da4.setImg("http://www.xitongcheng.cc/uploads/allimg/151113/1-151113152024.jpg");
            da4.setShopname("张小二笔记本重装");
            da4.setPrice("3.20");
            da4.setNum("4");
            da4.setZong("12.80");
            data.add(da4);

        }
    }



