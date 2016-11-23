package com.weblink.zbcommunity.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.weblink.zbcommunity.R;
import com.weblink.zbcommunity.adapter.MyhelpLvAdpter;


/**
 * Created by Administrator on 2016/11/11.
 */
public class MinehelpActivity extends Activity implements View.OnClickListener {
    ListView li;
    TextView mine_help_back;
    ImageButton mine_help_backk;
    TextView title;
    String[] ss={"为什么订单还没有到","测试数据","测试数据","测试数据","测试数据","测试数据","测试数据","测试数据","测试数据"};
    MyhelpLvAdpter ma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine_help);
        li=(ListView) findViewById(R.id.mine_help_listview);
        mine_help_backk=(ImageButton)findViewById(R.id.iv_left);
        mine_help_backk.setVisibility(View.VISIBLE);
        mine_help_back=(TextView) findViewById(R.id.tv_left);
        mine_help_back.setVisibility(View.GONE);
        mine_help_backk.setOnClickListener(this);
        title=(TextView)findViewById(R.id.tv_title);
        title.setText("帮助与反馈");
        ma=new MyhelpLvAdpter(this,ss);
        li.setAdapter(ma);
        li.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

         Intent intent = new Intent(MinehelpActivity.this,MinehelpxxActivity.class);

                startActivity(intent);

            }
        });
    }
    @Override
    public void onClick(View v) {

        if(v==mine_help_backk)
        {
            finish();
        }

    }
}
