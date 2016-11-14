package com.weblink.zbcommunity.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.baidu.mapapi.search.sug.OnGetSuggestionResultListener;
import com.baidu.mapapi.search.sug.SuggestionResult;
import com.baidu.mapapi.search.sug.SuggestionSearch;
import com.baidu.mapapi.search.sug.SuggestionSearchOption;
import com.weblink.zbcommunity.BaseActivity;
import com.weblink.zbcommunity.R;
import com.weblink.zbcommunity.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by swq on 2016/11/11.
 */
public class SelectLocActivity extends BaseActivity implements OnGetSuggestionResultListener {
    @BindView(R.id.tv_left)
    TextView tvLeft;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.iv_left)
    ImageView ivLeft;
    @BindView(R.id.iv_right)
    ImageView ivRight;
    @BindView(R.id.tv_right)
    TextView tvRight;
    @BindView(R.id.tv_curr_loc)
    TextView tvCurrLoc;
    @BindView(R.id.spinner_city)
    Spinner spinnerCity;
    @BindView(R.id.spinner_town)
    Spinner spinnerTown;
    @BindView(R.id.ll_city)
    LinearLayout llCity;
    @BindView(R.id.tv_search)
    AutoCompleteTextView keyWorldsView;


    private ArrayAdapter cityAdapter;
    private ArrayAdapter townAdapter;
    private List<String> cityList;
    private List<String> townList;

    private ArrayAdapter<String> sugAdapter = null;

    private SuggestionSearch mSuggestionSearch = null;
    private List<String> suggest;


    @Override
    public void setContent() {
        setContentView(R.layout.activity_selectloc);

    }

    @Override
    public void initView() {


//        ButterKnife.bind(this);
        tvTitle.setText("定位选择");
        tvTitle.setVisibility(View.VISIBLE);
        tvLeft.setVisibility(View.VISIBLE);
        tvLeft.setBackgroundResource(R.drawable.back_normal);


        initSpinner();

        initAutoSearch();

        tvCurrLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


    private void initAutoSearch() {


        // 初始化建议搜索模块，注册建议搜索事件监听
        mSuggestionSearch = SuggestionSearch.newInstance();
        mSuggestionSearch.setOnGetSuggestionResultListener(this);


        sugAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line);
        keyWorldsView.setAdapter(sugAdapter);
        keyWorldsView.setThreshold(1);
        /**
         * 当输入关键字变化时，动态更新建议列表
         */
        keyWorldsView.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable arg0) {

            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,
                                          int arg2, int arg3) {

            }

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2,
                                      int arg3) {
                if (cs.length() <= 0) {
                    return;
                }

                /**
                 * 使用建议搜索服务获取建议列表，结果在onSuggestionResult()中更新
                 */
                mSuggestionSearch
                        .requestSuggestion((new SuggestionSearchOption())
                                .keyword(cs.toString()).city("淄博"));
            }
        });

    }

    private void initSpinner() {
        cityList = new ArrayList<>();
        cityList.add("淄博");
        cityList.add("济南");
        cityList.add("青岛");

        townList = new ArrayList<>();
        townList.add("张店区");


        //适配器
        cityAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cityList);
        //设置样式
        cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //加载适配器
        spinnerCity.setAdapter(cityAdapter);


        //适配器
        townAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, townList);
        //设置样式
        townAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //加载适配器
        spinnerTown.setAdapter(townAdapter);

        spinnerCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                ToastUtils.showToast(SelectLocActivity.this, parent.getItemAtPosition(position).toString());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spinnerTown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                ToastUtils.showToast(SelectLocActivity.this, parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void initNet() {

    }

    @Override
    public void onGetSuggestionResult(SuggestionResult res) {

        if (res == null || res.getAllSuggestions() == null) {
            return;
        }
        suggest = new ArrayList<String>();
        for (SuggestionResult.SuggestionInfo info : res.getAllSuggestions()) {
            if (info.key != null) {
                suggest.add(info.key);
            }
        }
        sugAdapter = new ArrayAdapter<String>(SelectLocActivity.this, android.R.layout.simple_dropdown_item_1line, suggest);
        keyWorldsView.setAdapter(sugAdapter);
        sugAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
