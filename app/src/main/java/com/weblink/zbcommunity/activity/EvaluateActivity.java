package com.weblink.zbcommunity.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.weblink.zbcommunity.BaseActivity;
import com.weblink.zbcommunity.R;
import com.weblink.zbcommunity.adapter.EvaluateAdpter;
import com.weblink.zbcommunity.bean.CommodgvBean;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2016/11/22.
 */
public class EvaluateActivity extends BaseActivity {
    ListView lv;
    TextView top;
    ImageButton back;
    TextView backk;
    EvaluateAdpter evad;
    //测试数据删除
    List<CommodgvBean> dadas = new ArrayList<>();
    private CommodgvBean commodgvBean = new CommodgvBean();
    private CommodgvBean commodgvBean1 = new CommodgvBean();
    private CommodgvBean commodgvBean2 = new CommodgvBean();
    private CommodgvBean commodgvBean3 = new CommodgvBean();
    private CommodgvBean commodgvBean4 = new CommodgvBean();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContent();
        initView();
        evad = new EvaluateAdpter(this, dadas);
        lv.setAdapter(evad);
    }

    @Override
    public void setContent() {
        setContentView(R.layout.evaluate);
        lv = (ListView) findViewById(R.id.evalua_lv);
        top = (TextView) findViewById(R.id.tv_title);
        backk=(TextView)findViewById(R.id.tv_left);

        backk.setVisibility(View.GONE);
        top.setText("评价");
        back = (ImageButton) findViewById(R.id.iv_left);
        back.setVisibility(View.VISIBLE);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void initView() {


        commodgvBean.setKintext("国服第一茄子");
        commodgvBean.setKinurl("http://www.tao47.cn/images/201605/goods_img/3267_P_1464335474911.jpg");
        dadas.add(commodgvBean);
        commodgvBean1.setKintext("测试数据");
        commodgvBean1.setKinurl("http://desk.fd.zol-img.com.cn/t_s960x600c5/g4/M00/0D/01/Cg-4y1ULoXCII6fEAAeQFx3fsKgAAXCmAPjugYAB5Av166.jpg");
        dadas.add(commodgvBean1);

        commodgvBean2.setKintext("炫酷西红柿");
        commodgvBean2.setKinurl("http://homemade.keliren.cn/tuku/a/20160405/5703c56a43842.jpg_600.jpg");
        dadas.add(commodgvBean2);
        commodgvBean3.setKintext("红烧小菜椒");
        commodgvBean3.setKinurl("http://pic3.nipic.com/20090713/2343681_131215028_2.jpg");
        dadas.add(commodgvBean3);
        commodgvBean4.setKintext("呵呵你个大白菜");
        commodgvBean4.setKinurl("http://pic.58pic.com/58pic/15/40/30/63D58PICdSQ_1024.jpg");
        dadas.add(commodgvBean4);
    }

    @Override
    public void initNet() {

    }
}
