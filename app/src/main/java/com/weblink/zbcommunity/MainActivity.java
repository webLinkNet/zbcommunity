package com.weblink.zbcommunity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;


import com.weblink.zbcommunity.bean.Tab;
import com.weblink.zbcommunity.fragment.CartFragment;
import com.weblink.zbcommunity.fragment.CommodtityFragment;
import com.weblink.zbcommunity.fragment.HomeFragment;
import com.weblink.zbcommunity.fragment.MineFragment;
import com.weblink.zbcommunity.utils.ToastUtils;
import com.weblink.zbcommunity.widget.FragmentTabHost;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class MainActivity extends BaseActivity {

    @BindView(R.id.fl_tab_content)
    FrameLayout flTabContent;
    @BindView(android.R.id.tabcontent)
    FrameLayout tabcontent;
    @BindView(R.id.tab_host)
    FragmentTabHost tabHost;


    private LayoutInflater mInflater;

    private List<Tab> mTabs = new ArrayList<>();

    private long currentTime = 0;
    private long PRESS_BACK_INTERVAL = 2000;

    @Override
    public void setContent() {

        setContentView(R.layout.activity_main);

        //动态添加定位权限for6.0
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new
                            String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
        }


    }

    @Override
    public void initView() {
        initTab();
    }

    @Override
    public void initNet() {

    }

    private void initTab() {


        Tab tabHome = new Tab(R.string.home, R.drawable.selector_home, HomeFragment.class);
        Tab tabCommodity = new Tab(R.string.commodity, R.drawable.selector_commodity, CommodtityFragment.class);
        Tab tabCart = new Tab(R.string.cart, R.drawable.selector_cart, CartFragment.class);
        Tab tabMine = new Tab(R.string.mine, R.drawable.selector_mine, MineFragment.class);

        mTabs.add(tabHome);
        mTabs.add(tabCommodity);
        mTabs.add(tabCart);
        mTabs.add(tabMine);

        tabHost.setup(this, getSupportFragmentManager(), R.id.fl_tab_content);
        mInflater = LayoutInflater.from(this);

        for (Tab tab : mTabs) {

            TabHost.TabSpec tabSpec = tabHost.newTabSpec(getString(tab.getTitle()));
            tabSpec.setIndicator(buildIndicator(tab));
            tabHost.addTab(tabSpec, tab.getFragment(), null);
        }


        tabHost.setCurrentTab(0);

        tabHost.getTabWidget().setDividerDrawable(null);//去掉分割线
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                if (tabId == getString(R.string.home)) {

                    Log.i("info", "首页");
                } else if (tabId == getString(R.string.commodity)) {
                    Log.i("info", "商品");
                } else if (tabId == getString(R.string.cart)) {
                    Log.i("info", "购物车");
                } else {
                    Log.i("info", "我的");
                }
            }
        });
    }


    /**
     * 创建indicator指示器
     *
     * @param tab
     * @return
     */
    private View buildIndicator(Tab tab) {

        View view = mInflater.inflate(R.layout.tab_indicator, null);
        ImageView ivIndicator = (ImageView) view.findViewById(R.id.iv_indicator);
        TextView tvIndicator = (TextView) view.findViewById(R.id.tv_indicator);
        ivIndicator.setBackgroundResource(tab.getIcon());
        tvIndicator.setText(tab.getTitle());


        return view;
    }


    @Override
    public void onBackPressed() {

        if (System.currentTimeMillis() - currentTime > PRESS_BACK_INTERVAL) {

            ToastUtils.showToast(this, "再按一次退出程序");

            currentTime = System.currentTimeMillis();
        } else {

            finish();
        }
    }

}
