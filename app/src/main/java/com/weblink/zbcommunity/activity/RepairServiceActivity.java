package com.weblink.zbcommunity.activity;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.weblink.zbcommunity.R;
import com.weblink.zbcommunity.adapter.RepairServiceAdapter;
import com.weblink.zbcommunity.bean.RepairServiceBean;
import com.weblink.zbcommunity.views.MyLinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by swq on 2016/12/1.
 */
public class RepairServiceActivity extends BaseActivity {


    @BindView(R.id.iv_left)
    ImageButton ivLeft;
    @BindView(R.id.tv_left)
    TextView tvLeft;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_right)
    ImageView ivRight;
    @BindView(R.id.tv_right)
    TextView tvRight;
    @BindView(R.id.sd_bg)
    SimpleDraweeView sdBg;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;


    private List<RepairServiceBean> list = new ArrayList<>();

    @Override
    public void setContent() {

        setContentView(R.layout.activity_repair_service);
    }

    @Override
    public void initView() {

        ivLeft.setVisibility(View.VISIBLE);
        tvTitle.setText("维修服务");
        sdBg.setImageURI(Uri.parse("http://img.vlongbiz.com/news/h016/h02/img201009090950380742.jpg"));

        initRecycleData();
    }


    private void initRecycleData() {

        recyclerView.setLayoutManager(new MyLinearLayoutManager(this));
//        recyclerView.addItemDecoration(new DividerItemDecoration(this,
//                DividerItemDecoration.VERTICAL_LIST));

        recyclerView.setNestedScrollingEnabled(false);
        for (int i = 0; i < 5; i++) {
            list.add(new RepairServiceBean("http://file.youboy.com/a/136/54/3/9/789889.jpg", "电脑维修" + i, 33.35));
        }


        RepairServiceAdapter adapter = new RepairServiceAdapter(this, R.layout.item_repair_service, list);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void initNet() {

    }

}
