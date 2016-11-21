package com.weblink.zbcommunity.activity;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.weblink.zbcommunity.BaseActivity;
import com.weblink.zbcommunity.R;
import com.weblink.zbcommunity.adapter.BaseAdapter;
import com.weblink.zbcommunity.adapter.SearchHistoryAdapter;
import com.weblink.zbcommunity.utils.ToastUtils;
import com.weblink.zbcommunity.views.MyLinearLayoutManager;
import com.weblink.zbcommunity.widget.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by swq on 2016/11/21.
 */
public class SearchActivity extends BaseActivity implements View.OnClickListener {


    @BindView(R.id.ibtn_back)
    ImageButton ibtnBack;
    @BindView(R.id.et_key)
    EditText etKey;
    @BindView(R.id.btn_search)
    Button btnSearch;
    @BindView(R.id.rv_search)
    RecyclerView rvSearch;


    private List<String> list = new ArrayList<>();

    @Override
    public void setContent() {

        setContentView(R.layout.activity_search);
    }

    @Override
    public void initView() {

        ibtnBack.setOnClickListener(this);
        btnSearch.setOnClickListener(this);


        list.add("白菜");
        list.add("苹果");
        list.add("火龙果");
        final SearchHistoryAdapter adapter = new SearchHistoryAdapter(SearchActivity.this, R.layout.search_history_item, list);
        rvSearch.setLayoutManager(new MyLinearLayoutManager(SearchActivity.this));
        rvSearch.addItemDecoration(new DividerItemDecoration(SearchActivity.this, DividerItemDecoration.VERTICAL_LIST));
        rvSearch.setAdapter(adapter);

        adapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                ToastUtils.showToast(SearchActivity.this, adapter.getItem(position));
            }
        });
    }

    @Override
    public void initNet() {

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.ibtn_back:
                finish();
                break;

            case R.id.btn_search:

                if ("".equals(etKey.getText().toString())) {
                    ToastUtils.showToast(SearchActivity.this, "请输入搜索关键字");
                } else {
                    Intent intent = new Intent(SearchActivity.this, SearchResultActivity.class);
                    intent.putExtra("nameKey", etKey.getText().toString());
                    startActivity(intent);
                }

        }
    }
}
