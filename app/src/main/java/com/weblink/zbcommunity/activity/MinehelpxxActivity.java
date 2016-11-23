package com.weblink.zbcommunity.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.weblink.zbcommunity.R;

/**
 * Created by Administrator on 2016/11/16.
 */
public class MinehelpxxActivity extends Activity {
    TextView title;
    TextView back;
    ImageButton backk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine_help_xiangxi);
        title=(TextView) findViewById(R.id.tv_title);
        title.setText("常见问题");
        back=(TextView) findViewById(R.id.tv_left);
        backk=(ImageButton)findViewById(R.id.iv_left);
        backk.setVisibility(View.VISIBLE);
        back.setVisibility(View.GONE);
        backk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
