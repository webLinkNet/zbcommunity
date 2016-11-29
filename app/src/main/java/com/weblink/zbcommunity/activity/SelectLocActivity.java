package com.weblink.zbcommunity.activity;

import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.weblink.zbcommunity.R;
import com.weblink.zbcommunity.adapter.BaseAdapter;
import com.weblink.zbcommunity.adapter.PoiItemAdapter;
import com.weblink.zbcommunity.bean.LocationBean;
import com.weblink.zbcommunity.utils.ToastUtils;
import com.weblink.zbcommunity.views.MyLinearLayoutManager;
import com.weblink.zbcommunity.widget.DividerItemDecoration;
import com.weblink.zbcommunity.widget.LocationEvent;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * Created by swq on 2016/11/11.
 */
public class SelectLocActivity extends BaseActivity implements TextWatcher, PoiSearch.OnPoiSearchListener {
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
//    @BindView(R.id.spinner_city)
//    Spinner spinnerCity;
//    @BindView(R.id.spinner_town)
//    Spinner spinnerTown;
//    @BindView(R.id.ll_city)
//    LinearLayout llCity;
    @BindView(R.id.tv_search)
    AutoCompleteTextView keyWorldsView;
    @BindView(R.id.locts)
    RecyclerView lvLocts;

    private ArrayAdapter cityAdapter;
    private ArrayAdapter townAdapter;
    private List<String> cityList;
    private List<String> townList;
    private PoiItemAdapter poiItemAdapter;


    @Override
    public void setContent() {
        setContentView(R.layout.activity_selectloc);

    }

    @Override
    public void initView() {


        tvTitle.setText("定位选择");
        tvTitle.setVisibility(View.VISIBLE);
        ivLeft.setVisibility(View.VISIBLE);
        ivLeft.setImageResource(R.drawable.back_normal);
        tvCurrLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AMapLocation aMapLocation = LocationBean.getInstance().getAmapLocation();
                EventBus.getDefault().post(new LocationEvent(aMapLocation.getCity(), aMapLocation.getPoiName()));

                finish();
            }
        });


//        initSpinner();

        initAutoSearch();

        initPoiSearch();

        initLocDatas();

    }

    private void initLocDatas() {
        MyLinearLayoutManager linearLayoutManager = new MyLinearLayoutManager(this);
        lvLocts.setLayoutManager(linearLayoutManager);
        lvLocts.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));

        poiItemAdapter = new PoiItemAdapter(this, poiItems);
        lvLocts.setAdapter(poiItemAdapter);

        poiItemAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {


                EventBus.getDefault().post(new LocationEvent(poiItems.get(position).getCityName(),
                        poiItems.get(position).getTitle()));

                finish();
            }
        });
    }

    private void initPoiSearch() {


    }


    private void initAutoSearch() {

//        String [] arr={"aa","aab","aac","aac","aac","aac","aac","aac","aac","aac","aac","aac","aac"};
//        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arr);
//        keyWorldsView.setThreshold(1);
//        keyWorldsView.setAdapter(arrayAdapter);


        keyWorldsView.addTextChangedListener(this);// 添加文本输入框监听事件
    }

//    private void initSpinner() {
//        cityList = new ArrayList<>();
//        cityList.add("淄博");
//        cityList.add("济南");
//        cityList.add("青岛");
//
//        townList = new ArrayList<>();
//        townList.add("张店区");
//
//
//        //适配器
//        cityAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cityList);
//        //设置样式
//        cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        //加载适配器
//        spinnerCity.setAdapter(cityAdapter);
//
//
//        //适配器
//        townAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, townList);
//        //设置样式
//        townAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        //加载适配器
//        spinnerTown.setAdapter(townAdapter);
//
//        spinnerCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//                ToastUtils.showToast(SelectLocActivity.this, parent.getItemAtPosition(position).toString());
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//
//
//        spinnerTown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//                ToastUtils.showToast(SelectLocActivity.this, parent.getItemAtPosition(position).toString());
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//    }

    @Override
    public void initNet() {

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

        String newText = s.toString().trim();
        doSearchQuery(newText);

    }

    private int currentPage;
    private PoiSearch.Query query;// Poi查询条件类
    private PoiSearch poiSearch;// POI搜索
    private PoiResult poiResult; // poi返回的结果
    private List<PoiItem> poiItems = new ArrayList<PoiItem>();

    public void doSearchQuery(String key) {
//        showProgressDialog();// 显示进度框
        currentPage = 0;
        query = new PoiSearch.Query(key, "", "淄博市");// 第一个参数表示搜索字符串，第二个参数表示poi搜索类型，第三个参数表示poi搜索区域（空字符串代表全国）
        query.setPageSize(100);// 设置每页最多返回多少条poiitem
        query.setPageNum(0);// 设置查第一页
        poiSearch = new PoiSearch(this, query);
        poiSearch.setOnPoiSearchListener(this);
        poiSearch.searchPOIAsyn();
    }

    @Override
    public void onPoiSearched(PoiResult result, int rCode) {

        if (rCode == 1000) {
            if (result != null && result.getQuery() != null) {// 搜索poi的结果
                poiResult = result;
                // 取得搜索到的poiitems有多少页
                poiItems.clear();
                List<PoiItem> pois = poiResult.getPois();// 取得第一页的poiitem数据，页数从数字0开始

                if (pois != null && pois.size() > 0)
                    poiItems.addAll(pois);
                poiItemAdapter.notifyDataSetChanged();
            }
        } else {

            ToastUtils.showToast(this, "请检查您的网络");
        }
    }

    @Override
    public void onPoiItemSearched(PoiItem poiItem, int rCode) {

    }
}
