package com.weblink.zbcommunity.activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.weblink.zbcommunity.R;
import com.weblink.zbcommunity.adapter.BaseAdapter;
import com.weblink.zbcommunity.adapter.SearchResultAdapter;
import com.weblink.zbcommunity.bean.SearchResultBean;
import com.weblink.zbcommunity.utils.ToastUtils;
import com.weblink.zbcommunity.views.MyLinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by swq on 2016/11/21.
 */
public class SearchResultActivity extends BaseActivity implements View.OnClickListener {


    @BindView(R.id.iv_back)
    ImageButton ivBack;
    @BindView(R.id.tv_search)
    TextView tvSearch;
    @BindView(R.id.rv_shop)
    RecyclerView rvShop;

    private List<SearchResultBean> list = new ArrayList<>();

    @Override
    public void setContent() {

        setContentView(R.layout.activity_search_result);
    }

    @Override
    public void initView() {

        tvSearch.setText(getIntent().getStringExtra("nameKey"));
        ivBack.setOnClickListener(this);
        tvSearch.setOnClickListener(this);

        rvShop.setLayoutManager(new MyLinearLayoutManager(this));


        final SearchResultAdapter adapter = new SearchResultAdapter(this, R.layout.search_adapter_item, list);
        rvShop.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                ToastUtils.showToast(SearchResultActivity.this, adapter.getItem(position).getShopName());
            }
        });
    }

    @Override
    public void initNet() {

        SearchResultBean bean4 = new SearchResultBean();
        bean4.setImgUrl("http://pic.58pic.com/58pic/13/88/43/47m58PIC28t_1024.jpg");
        bean4.setShopName("草莓");
        SearchResultBean bean5 = new SearchResultBean();
        bean5.setImgUrl("http://image24.360doc.com/DownloadImg/2011/03/0815/9798933_5.jpg");
        bean5.setShopName("菠萝");
        SearchResultBean bean6 = new SearchResultBean();
        bean6.setImgUrl("http://img0.imgtn.bdimg.com/it/u=3790477612,1119807870&fm=21&gp=0.jpg");
        bean6.setShopName("苹果");
        List<SearchResultBean> listItem1 = new ArrayList<>();
        List<SearchResultBean> listItem2 = new ArrayList<>();
        List<SearchResultBean> listItem3 = new ArrayList<>();
        listItem1.add(bean4);
        listItem1.add(bean5);
        listItem1.add(bean6);

        listItem2.add(bean4);
        listItem2.add(bean6);

        listItem3.add(bean6);


        SearchResultBean bean1 = new SearchResultBean();
        bean1.setImgUrl("http://pic32.nipic.com/20130817/9745430_101836881000_2.jpg");
        bean1.setShopName("牛牛超市");
        bean1.setList(listItem1);

        SearchResultBean bean2 = new SearchResultBean();
        bean2.setImgUrl("http://pic42.nipic.com/20140607/18593452_165938662126_2.jpg");
        bean2.setShopName("妞妞超市");
        bean2.setList(listItem2);

        SearchResultBean bean3 = new SearchResultBean();
        bean3.setImgUrl("http://homemade.keliren.cn/tuku/a/20160331/56fc2bbdd2688.jpg_600.jpg");
        bean3.setShopName("呱呱超市");
        bean3.setList(listItem3);

        list.add(bean1);
        list.add(bean2);
        list.add(bean3);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.iv_back:
                onBackPressed();
                break;

            case R.id.tv_search:
                onBackPressed();
                break;


        }
    }
}
