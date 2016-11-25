package com.weblink.zbcommunity.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.weblink.zbcommunity.R;
import com.weblink.zbcommunity.adapter.CommKindThingAdpter;
import com.weblink.zbcommunity.bean.ChildBean;
import com.weblink.zbcommunity.bean.requestbean.CommKindThingBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/16.
 */
public class CommkindActivity extends Activity  {

    TextView kind_back;
    TextView kind_title;
    ExpandableListView kindexlv;
    CommKindThingAdpter ad;
    List<CommKindThingBean> data =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comm_kind);
        intdata();

        //上次界面传来的信息
        Intent intent=getIntent();
        String sousuo=intent.getStringExtra("sousuo");
        kind_title=(TextView)findViewById(R.id.kind_title);
        kind_title.setText(sousuo);
        kind_back=(TextView)findViewById(R.id.kind_back);
        kind_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        kindexlv=(ExpandableListView)findViewById(R.id.kind_exlv);
        ad=new CommKindThingAdpter(this,data);
        kindexlv.setAdapter(ad);
        for(int i = 0; i < ad.getGroupCount(); i++){

            kindexlv.expandGroup(i);

        }
        kindexlv.setGroupIndicator(null);




    }
    public void intdata(){
        CommKindThingBean a1=new CommKindThingBean();
        List<ChildBean> de= new ArrayList<>();
        ChildBean aa1 = new ChildBean();
        aa1.setChildimg("http://img3.imgtn.bdimg.com/it/u=2224327666,519762971&fm=23&gp=0.jpg");
        aa1.setJieshao("国服第一白菜");
        aa1.setPrice("3.02");
        ChildBean aa2 = new ChildBean();
        aa2.setChildimg("http://pic.58pic.com/58pic/15/35/32/90g58PICqsN_1024.jpg");
        aa2.setJieshao("大白菜");
        aa2.setPrice("3.02");
        ChildBean aa3 = new ChildBean();
        aa3.setChildimg("http://img.web07.cn/uploads/Photo/c101115/12YN19531F-54937.jpg");
        aa3.setJieshao("优质白菜");
        aa3.setPrice("3.02");
        de.add(aa1);
        de.add(aa2);
        de.add(aa3);
        a1.setChildlist(de);
        a1.setFatherimg("http://www.yijiafu.com.cn/upload/2010/05/07/4w3izmfozctrv1273217356.jpg");
        a1.setFathername("沃尔玛");


        CommKindThingBean a2=new CommKindThingBean();
        List<ChildBean> dee= new ArrayList<>();
        ChildBean aaa1 = new ChildBean();
        aaa1.setChildimg("http://img.taopic.com/uploads/allimg/120323/2257-12032322592969.jpg");
        aaa1.setJieshao("炫酷的茄子");
        aaa1.setPrice("3.02");
        ChildBean aaa2 = new ChildBean();
        aaa2.setChildimg("http://img05.tooopen.com/images/20140828/sy_69764819978.jpg");
        aaa2.setJieshao("国产茄子5元每斤");
        aaa2.setPrice("3.02");
        dee.add(aaa1);
        dee.add(aaa2);
        a2.setChildlist(dee);
        a2.setFatherimg("http://pic17.nipic.com/20111013/7775308_122510510124_2.jpg");
        a2.setFathername("茄子专卖店");

        data.add(a1);
        data.add(a2);



    }
}
