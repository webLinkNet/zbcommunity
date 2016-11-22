package com.weblink.zbcommunity.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import com.weblink.zbcommunity.R;
import com.weblink.zbcommunity.adapter.MmyorlvAdpter;
import com.weblink.zbcommunity.bean.MinedingdanBean;
import java.util.ArrayList;
import java.util.List;


public class MyorderActivity extends Activity implements OnClickListener {
    MmyorlvAdpter ad;
    ImageButton mine_myorder_back;
    TextView title;
    Button btn_daizhi;
    Button btn_daiping;
    Button btn_yiping;
    Button btn_yiqu;
    ListView mine_myroder_list;
    List<MinedingdanBean> data = new ArrayList<MinedingdanBean>();
    List<MinedingdanBean> dataa = new ArrayList<MinedingdanBean>();
    List<MinedingdanBean> dataaa = new ArrayList<MinedingdanBean>();
    List<MinedingdanBean> dataaaa = new ArrayList<MinedingdanBean>();
    MinedingdanBean data1 = new MinedingdanBean();
    MinedingdanBean data2 = new MinedingdanBean();
    MinedingdanBean data3 = new MinedingdanBean();
    MinedingdanBean data4 = new MinedingdanBean();
    MinedingdanBean data5 = new MinedingdanBean();
    MinedingdanBean data6 = new MinedingdanBean();
    MinedingdanBean data7 = new MinedingdanBean();
    MinedingdanBean data8 = new MinedingdanBean();
    MinedingdanBean data9 = new MinedingdanBean();
    MinedingdanBean data12 = new MinedingdanBean();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine_myorder);
        initdate();
        intdata();
        add(data);


    }

    void add(List<MinedingdanBean> dada) {
        ad = new MmyorlvAdpter(this, dada);
        mine_myroder_list.setAdapter(ad);
    }

    void intdata() {

        data1.setId(1);
        data1.setImgurlone("http://hgyj.studioartiz.com/uploads/allimg/161021/1-161021161524.jpg");
        data1.setImgurltwo("http://hgyj.studioartiz.com/uploads/allimg/161021/1-161021161524-50.jpg");
        data1.setImgurlthree("http://hgyj.studioartiz.com/uploads/allimg/161021/1-161021161525.jpg");
        data1.setStorename("谭梦石超市");
        data1.setMoneynum("12100");
        data1.setThingnum("9");

        data2.setId(1);
        data2.setImgurlone("http://pic67.nipic.com/file/20150512/18138004_183531555000_2.jpg");
        data2.setImgurltwo("http://pic60.nipic.com/file/20150208/9885883_102238823000_2.jpg");
        data2.setImgurlthree("");
        data2.setStorename("宋文强超市");
        data2.setMoneynum("500");
        data2.setThingnum("2");


        data3.setId(1);
        data3.setImgurlone("http://hgyj.studioartiz.com/uploads/allimg/161021/1-161021161524.jpg");
        data3.setImgurltwo("http://hgyj.studioartiz.com/uploads/allimg/161021/1-161021161524-50.jpg");
        data3.setImgurlthree("http://hgyj.studioartiz.com/uploads/allimg/161021/1-161021161525.jpg");
        data3.setStorename("刘璇超市");
        data3.setMoneynum("32332100");
        data3.setThingnum("110");


        data4.setId(1);
        data4.setImgurlone("http://pic67.nipic.com/file/20150512/18138004_183531555000_2.jpg");
        data4.setImgurltwo("http://pic60.nipic.com/file/20150208/9885883_102238823000_2.jpg");
        data4.setImgurlthree("http://pic31.nipic.com/20130719/9422601_112816909000_2.jpg");
        data4.setStorename("焦泽超市");
        data4.setMoneynum("1433500");
        data4.setThingnum("121");

        data5.setId(2);
        data5.setImgurlone("http://hgyj.studioartiz.com/uploads/allimg/161021/1-161021161524.jpg");
        data5.setImgurltwo("http://hgyj.studioartiz.com/uploads/allimg/161021/1-161021161524-50.jpg");
        data5.setImgurlthree("http://hgyj.studioartiz.com/uploads/allimg/161021/1-161021161525.jpg");
        data5.setStorename("尉超超市");
        data5.setMoneynum("2100");
        data5.setThingnum("10");

        data6.setId(2);
        data6.setImgurlone("http://pic67.nipic.com/file/20150512/18138004_183531555000_2.jpg");
        data6.setImgurltwo("http://pic60.nipic.com/file/20150208/9885883_102238823000_2.jpg");
        data6.setImgurlthree("http://pic31.nipic.com/20130719/9422601_112816909000_2.jpg");
        data6.setStorename("淄博网汇网络科技");
        data6.setMoneynum("14500");
        data6.setThingnum("12");

        data7.setId(2);
        data7.setImgurlone("http://hgyj.studioartiz.com/uploads/allimg/161021/1-161021161524.jpg");
        data7.setImgurltwo("http://hgyj.studioartiz.com/uploads/allimg/161021/1-161021161524-50.jpg");
        data7.setImgurlthree("http://hgyj.studioartiz.com/uploads/allimg/161021/1-161021161525.jpg");
        data7.setStorename("谭梦石超市");
        data7.setMoneynum("12100");
        data7.setThingnum("9");


        data8.setId(3);
        data8.setImgurlone("http://pic67.nipic.com/file/20150512/18138004_183531555000_2.jpg");
        data8.setImgurltwo("http://pic60.nipic.com/file/20150208/9885883_102238823000_2.jpg");
        data8.setImgurlthree("");
        data8.setStorename("宋文强超市");
        data8.setMoneynum("500");
        data8.setThingnum("2");

        data9.setId(3);
        data9.setImgurlone("http://hgyj.studioartiz.com/uploads/allimg/161021/1-161021161524.jpg");
        data9.setImgurltwo("http://hgyj.studioartiz.com/uploads/allimg/161021/1-161021161524-50.jpg");
        data9.setImgurlthree("http://hgyj.studioartiz.com/uploads/allimg/161021/1-161021161525.jpg");
        data9.setStorename("谭梦石超市");
        data9.setMoneynum("12100");
        data9.setThingnum("9");


        data12.setId(4);
        data12.setImgurlone("http://pic67.nipic.com/file/20150512/18138004_183531555000_2.jpg");
        data12.setImgurltwo("http://pic60.nipic.com/file/20150208/9885883_102238823000_2.jpg");
        data12.setImgurlthree("");
        data12.setStorename("宋文强超市");
        data12.setMoneynum("500");
        data12.setThingnum("2");


        data.add(data1);
        data.add(data2);
        data.add(data3);
        data.add(data4);
        dataa.add(data5);
        dataa.add(data6);
        dataa.add(data7);
        dataaa.add(data8);
        dataaa.add(data9);
        dataaaa.add(data12);


    }


    void initdate() {
        mine_myorder_back = (ImageButton) findViewById(R.id.iv_left);
        mine_myorder_back.setVisibility(View.VISIBLE);
        title = (TextView) findViewById(R.id.tv_title);
        title.setText("我的订单");
        btn_daizhi = (Button) findViewById(R.id.mine_daizhi);
        btn_daiping = (Button) findViewById(R.id.mine_daiping);
        btn_yiping = (Button) findViewById(R.id.mine_yiping);
        btn_yiqu = (Button) findViewById(R.id.mine_yiqu);
        mine_myroder_list = (ListView) findViewById(R.id.mine_myroder_list);
        //mine_myroder_list.setOnItemClickListener(listener);
        btn_daizhi.setOnClickListener(this);
        btn_daiping.setOnClickListener(this);
        btn_yiping.setOnClickListener(this);
        btn_yiqu.setOnClickListener(this);
        mine_myorder_back.setOnClickListener(this);
    }

    void colorz() {

        btn_daizhi.setTextColor(Color.parseColor("#000000"));
        btn_daiping.setTextColor(Color.parseColor("#000000"));
        btn_yiping.setTextColor(Color.parseColor("#000000"));
        btn_yiqu.setTextColor(Color.parseColor("#000000"));


    }

    @Override
    public void onClick(View v) {
        //返回
        if (v == mine_myorder_back) {
            finish();
        }
        //待支付
        if (v == btn_daizhi) {
            colorz();
            btn_daizhi.setTextColor(Color.parseColor("#FF0066"));
            add(data);

        }
        //待评价
        if (v == btn_daiping) {
            colorz();
            btn_daiping.setTextColor(Color.parseColor("#FF0066"));
            add(dataa);
        }
        //已完成
        if (v == btn_yiping) {
            colorz();
            btn_yiping.setTextColor(Color.parseColor("#FF0066"));
            add(dataaa);
        }
        //已取消
        if (v == btn_yiqu) {
            colorz();
            btn_yiqu.setTextColor(Color.parseColor("#FF0066"));
            add(dataaaa);
        }
    }

}
