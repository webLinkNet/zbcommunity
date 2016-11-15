package com.weblink.zbcommunity.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.weblink.zbcommunity.R;
import com.weblink.zbcommunity.adapter.Minemyhelp_ListviewAdpter;


/**
 * Created by Administrator on 2016/11/11.
 */
public class Mine_help extends Activity implements View.OnClickListener {
    ListView li;
    ImageView mine_help_back;
    String[] ss={"订单未送到","订单生成的慢","你们的app设计的真好"};
    Minemyhelp_ListviewAdpter ma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine_help);
        li=(ListView) findViewById(R.id.mine_help_listview);
        mine_help_back=(ImageView) findViewById(R.id.mine_help_back);
        mine_help_back.setOnClickListener(this);
        ma=new Minemyhelp_ListviewAdpter(this,ss);
        li.setAdapter(ma);
    }
    @Override
    public void onClick(View v) {

        if(v==mine_help_back)
        {
            finish();
        }

    }
}
