package com.weblink.zbcommunity.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.weblink.zbcommunity.R;
import com.weblink.zbcommunity.adapter.CommkindlvAdapter;
import com.weblink.zbcommunity.bean.CommkindlvBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/16.
 */
public class CommkindActivity extends Activity  {
    List<CommkindlvBean> datas=new ArrayList<>();
    TextView kind_back;
    CommkindlvBean ccc=new CommkindlvBean();
    CommkindlvBean bbb=new CommkindlvBean();
    ListView lv;
    CommkindlvAdapter commkindlvAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comm_kind);
        intdata();
        lv=(ListView)findViewById(R.id.kind_lv);
        kind_back=(TextView)findViewById(R.id.kind_back);
        kind_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        commkindlvAdapter=new CommkindlvAdapter(this,datas);
        lv.setAdapter(commkindlvAdapter);

    }
    public void intdata(){
        ccc.setPrice1("1.20");ccc.setPrice2("2.60");ccc.setPrice3("0.50");
        ccc.setThingname1("大白菜");ccc.setThingname2("小白菜");ccc.setThingname3("优质白菜");
        ccc.setUrl1("http://i2.s2.dpfile.com/pc/fb7ea132e22ec7efa592a60f03a04205%28700x700%29/thumb.jpg");
        ccc.setUrl2("http://img.web07.cn/uploads/Photo/c101115/12YN19531F-54937.jpg");
        ccc.setUrl3("http://pic16.nipic.com/20110925/4666865_173608655000_2.jpg");
        ccc.setUrl4("http://i1.dpfile.com/2010-06-03/4432486_b.jpg%28700x700%29/thumb.jpg");
        ccc.setShopname("谭梦石超市");

        bbb.setPrice1("4.20");bbb.setPrice2("4.20");bbb.setPrice3("55.00");
        bbb.setThingname1("优质大白菜");bbb.setThingname2("大白菜");bbb.setThingname3("白菜");
        bbb.setUrl1("http://p0.55tuanimg.com/p1/M01/12/00/rBAZIlTwHxWAaaHtAAATScyUY7A173.png");
        bbb.setUrl2("http://img.web07.cn/uploads/Photo/c101115/12YN19531F-54937.jpg");
        bbb.setUrl3("http://pic16.nipic.com/20110925/4666865_173608655000_2.jpg");
        bbb.setUrl4("http://i1.dpfile.com/2010-06-03/4432486_b.jpg%28700x700%29/thumb.jpg");
        bbb.setShopname("刘璇超市");

        datas.add(ccc);
        datas.add(bbb);
    }
}
