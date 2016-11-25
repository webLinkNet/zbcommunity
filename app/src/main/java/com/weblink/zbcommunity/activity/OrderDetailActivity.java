package com.weblink.zbcommunity.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.weblink.zbcommunity.R;
import com.weblink.zbcommunity.adapter.OrderDetailAdpter;
import com.weblink.zbcommunity.bean.OrderDetailBean;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/24.
 */
public class OrderDetailActivity extends Activity {

    List<OrderDetailBean> data = new ArrayList<>();
    OrderDetailAdpter ad;
    ListView orderdelv;
    ScrollView rrr4;
    String po;
    @BindView(R.id.iv_left)
    ImageButton ivLeft;
    @BindView(R.id.tv_left)
    TextView tvLeft;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.orderd_r1_text)
    TextView orderdR1Text;
    @BindView(R.id.orderd_order_num)
    TextView orderdOrderNum;
    @BindView(R.id.orderd_user_name)
    TextView orderdUserName;
    @BindView(R.id.orderd_user_phone)
    TextView orderdUserPhone;
    @BindView(R.id.orderd_adress)
    TextView orderdAdress;
    @BindView(R.id.order_re_time)
    TextView orderReTime;
    @BindView(R.id.order_xiadantime)
    TextView orderXiadantime;
    @BindView(R.id.order_xiadan)
    TextView orderXiadan;
    @BindView(R.id.order_zhifutime)
    TextView orderZhifutime;
    @BindView(R.id.order_re2)
    RelativeLayout orderRe2;
    @BindView(R.id.orderd_quxiaotime)
    TextView orderdQuxiaotime;
    @BindView(R.id.orderd_quxiaotimeee)
    TextView orderdQuxiaotimeee;
    @BindView(R.id.order_re3)
    RelativeLayout orderRe3;
    @BindView(R.id.order_pingjia)
    TextView orderPingjia;
    @BindView(R.id.orderd_price)
    TextView orderdPrice;
    Button orderr_button;
    ImageView iv_r_phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orderdetail);
        ButterKnife.bind(this);
        orderr_button = (Button) findViewById(R.id.orderr_button);
        orderdelv = (ListView) findViewById(R.id.orderdelv);
        iv_r_phone=(ImageView)findViewById(R.id.iv_right);
        iv_r_phone.setVisibility(View.VISIBLE);
        iv_r_phone.setBackgroundResource(R.drawable.detal_phone);
        iv_r_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 10086));
                startActivity(intent);
            }
        });
        rrr4=(ScrollView)findViewById(R.id.rrrr6);

        ivLeft.setVisibility(View.VISIBLE);
        ivLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tvLeft.setVisibility(View.GONE);
        Intent intent = getIntent();
        po = intent.getStringExtra("id");
        int type = Integer.valueOf(po);
        switch (type) {
            case 1:
                tvTitle.setText("待支付订单详情");
                orderPingjia.setVisibility(View.GONE);
                orderXiadan.setVisibility(View.GONE);
                orderZhifutime.setVisibility(View.GONE);
                orderdQuxiaotime.setVisibility(View.GONE);
                orderdQuxiaotimeee.setVisibility(View.GONE);
                break;
            case 2:
                tvTitle.setText("待评价订单详情");
                orderPingjia.setVisibility(View.GONE);
                orderdQuxiaotime.setVisibility(View.GONE);
                orderdQuxiaotimeee.setVisibility(View.GONE);
                orderr_button.setText("去评价");
                break;
            case 3:
                tvTitle.setText("已完成订单详情");
                orderdQuxiaotime.setText("评价时间：");
                orderr_button.setText("再次购买");


                break;
            case 4:
                tvTitle.setText("已取消订单详情");
                orderXiadan.setVisibility(View.GONE);
                orderZhifutime.setVisibility(View.GONE);
                orderr_button.setText("再次购买");
                break;
        }
        initview();
        ad = new OrderDetailAdpter(this, data);
        orderdelv.setAdapter(ad);
        setListViewHeightBasedOnChildren(orderdelv);
        //显示到顶部
        android.os.Handler handler = new android.os.Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
               rrr4.fullScroll(ScrollView.FOCUS_UP);
            }
        });


    }

     //解决list显示一行
    private void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }
        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight
                + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

    void initview() {
        OrderDetailBean ord = new OrderDetailBean();
        ord.setBeizhu("不要香菜，不要辣椒，尽快送达");
        ord.setImg1("http://img4.imgtn.bdimg.com/it/u=4256098733,1940854509&fm=23&gp=0.jpg");
        ord.setImg2("http://pic.58pic.com/58pic/15/42/64/49K58PICZNx_1024.jpg");
        ord.setImg3("http://www.k618.cn/ygmp/dzrmp/zwtd/201206/W020120605506019775905.jpg");
        ord.setNum("3");
        ord.setPrice1("202");
        ord.setPrice2("3.20");
        ord.setPrice3("1.2");
        ord.setPrice4("0.5");
        ord.setPrice5("26");
        ord.setPrice6("125");
        ord.setShopname("测试数据超市");
        data.add(ord);

        OrderDetailBean ordd = new OrderDetailBean();
        ordd.setBeizhu("尽快送达 谢谢");
        ordd.setImg1("http://pic67.nipic.com/file/20150512/18138004_183531555000_2.jpg");
        ordd.setImg2("http://pic67.nipic.com/file/20150512/18138004_183531555000_2.jpg");
        ordd.setImg3("http://pic67.nipic.com/file/20150512/18138004_183531555000_2.jpg");
        ordd.setNum("3");
        ordd.setPrice1("202");
        ordd.setPrice2("202");
        ordd.setPrice3("202");
        ordd.setPrice4("202");
        ordd.setPrice5("202");
        ordd.setPrice6("202");
        ordd.setShopname("沃尔玛超市");
        data.add(ordd);

        OrderDetailBean orddd = new OrderDetailBean();
        orddd.setBeizhu("不要香菜 多放辣椒");
        orddd.setImg1("http://pic67.nipic.com/file/20150512/18138004_183531555000_2.jpg");
        orddd.setImg2("http://pic67.nipic.com/file/20150512/18138004_183531555000_2.jpg");
        orddd.setImg3("http://pic67.nipic.com/file/20150512/18138004_183531555000_2.jpg");
        orddd.setNum("3");
        orddd.setPrice1("202");
        orddd.setPrice2("202");
        orddd.setPrice3("202");
        orddd.setPrice4("202");
        orddd.setPrice5("202");
        orddd.setPrice6("202");
        orddd.setShopname("银座超市");
        data.add(orddd);


    }
}
