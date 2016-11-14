package com.weblink.zbcommunity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.Poi;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.weblink.zbcommunity.Constants;
import com.weblink.zbcommunity.R;
import com.weblink.zbcommunity.activity.SelectLocActivity;
import com.weblink.zbcommunity.adapter.RvHomeAdapter;
import com.weblink.zbcommunity.adapter.RvHomeTopAdapter;
import com.weblink.zbcommunity.bean.BannerBean;
import com.weblink.zbcommunity.bean.CommunityBean;
import com.weblink.zbcommunity.bean.HomeGVBean;
import com.weblink.zbcommunity.bean.LocationBean;
import com.weblink.zbcommunity.utils.ToastUtils;
import com.weblink.zbcommunity.views.MyGridLayoutManager;
import com.weblink.zbcommunity.views.MyLinearLayoutManager;
import com.weblink.zbcommunity.widget.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by swq on 2016/10/31.
 */
public class HomeFragment extends BaseFragment {

    @BindView(R.id.iv_loc)
    ImageView ivLoc;
    @BindView(R.id.slider)
    SliderLayout sliderShow;
    @BindView(R.id.rv_top)
    RecyclerView rvTop;
    @BindView(R.id.rv_home)
    RecyclerView rvHome;
    @BindView(R.id.tv_loc)
    TextView tvLoc;
    @BindView(R.id.refresh)
    MaterialRefreshLayout refreshLayout;
    @BindView(R.id.ll_loc)
    LinearLayout llLoc;

    //轮播图数据
    private List<BannerBean> bannerBeanList = new ArrayList<>();
    //上面的横向数据
    private List topList = new ArrayList();

    //下面的竖直方向的数据
    private List<CommunityBean> bottomList = new ArrayList<>();


    private TextSliderView textSliderView;

    private LocationClient mLocationClient;
    public BDLocationListener myListener = new MyLocationListener();

    private List<CommunityBean.DetailInfoBean> deatilBeanList = new ArrayList<>();


    @Override
    public View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void initView() {

        //初始化轮播图view
        initSlideView();


        //初始化下面列表展示
        initRecycleView();

        //初始化定位
        initLocation();

        //初始化刷新，加载
        initRefresh();
    }


    private void initRefresh() {
        refreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {

                refreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        refreshLayout.finishRefresh();

                    }
                }, 3000);
            }

            @Override
            public void onfinish() {
                ToastUtils.showToast(getActivity(), "刷新完成");
            }


            @Override
            public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {


                refreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        refreshLayout.finishRefreshLoadMore();
                    }
                }, 3000);


            }
        });
    }


    public class MyLocationListener implements BDLocationListener {

        @Override
        public void onReceiveLocation(BDLocation location) {
            StringBuffer sb = new StringBuffer(256);
            sb.append("time : ");
            sb.append(location.getTime());
            sb.append("\nerror code : ");
            sb.append(location.getLocType());
            sb.append("\nlatitude : ");
            sb.append(location.getLatitude());
            sb.append("\nlontitude : ");
            sb.append(location.getLongitude());
            sb.append("\nradius : ");
            sb.append(location.getRadius());
            sb.append(location.getCity() + location.getLocationDescribe());
            if (location.getLocType() == BDLocation.TypeGpsLocation) {// GPS定位结果
                sb.append("\nspeed : ");
                sb.append(location.getSpeed());// 单位：公里每小时
                sb.append("\nsatellite : ");
                sb.append(location.getSatelliteNumber());
                sb.append("\nheight : ");
                sb.append(location.getAltitude());// 单位：米
                sb.append("\ndirection : ");
                sb.append(location.getDirection());// 单位度
                sb.append("\naddr : ");
                sb.append(location.getAddrStr());
                sb.append("\ndescribe : ");
                sb.append("gps定位成功");

            } else if (location.getLocType() == BDLocation.TypeNetWorkLocation) {// 网络定位结果
                sb.append("\naddr : ");
                sb.append(location.getAddrStr());
                //运营商信息
                sb.append("\noperationers : ");
                sb.append(location.getOperators());
                sb.append("\ndescribe : ");
                sb.append("网络定位成功");
            } else if (location.getLocType() == BDLocation.TypeOffLineLocation) {// 离线定位结果
                sb.append("\ndescribe : ");
                sb.append("离线定位成功，离线定位结果也是有效的");
            } else if (location.getLocType() == BDLocation.TypeServerError) {
                sb.append("\ndescribe : ");
                sb.append("服务端网络定位失败，可以反馈IMEI号和大体定位时间到loc-bugs@baidu.com，会有人追查原因");
            } else if (location.getLocType() == BDLocation.TypeNetWorkException) {
                sb.append("\ndescribe : ");
                sb.append("网络不同导致定位失败，请检查网络是否通畅");
            } else if (location.getLocType() == BDLocation.TypeCriteriaException) {
                sb.append("\ndescribe : ");
                sb.append("无法获取有效定位依据导致定位失败，一般是由于手机的原因，处于飞行模式下一般会造成这种结果，可以试着重启手机");
            }
            sb.append("\nlocationdescribe : ");
            sb.append(location.getLocationDescribe());// 位置语义化信息
            List<Poi> list = location.getPoiList();// POI数据
            if (list != null) {
                sb.append("\npoilist size = : ");
                sb.append(list.size());
                for (Poi p : list) {
                    sb.append("\npoi= : ");
                    sb.append(p.getId() + " " + p.getName() + " " + p.getRank());
                }
            }
            Log.i("BaiduLocationApiDem", sb.toString());


            tvLoc.setText(location.getCity().replace("市", "") + "  " + list.get(0).getName());

            LocationBean.getInstance().setLocation(location);
        }

    }


    private void initLocation() {


        // 定位初始化
        mLocationClient = new LocationClient(getActivity());
        mLocationClient.registerLocationListener(myListener);

        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy
        );//可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        option.setCoorType("bd09ll");//可选，默认gcj02，设置返回的定位结果坐标系
        int span = 0;
        option.setScanSpan(span);//可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
        option.setIsNeedAddress(true);//可选，设置是否需要地址信息，默认不需要
        option.setOpenGps(true);//可选，默认false,设置是否使用gps
        option.setLocationNotify(true);//可选，默认false，设置是否当GPS有效时按照1S/1次频率输出GPS结果
        option.setIsNeedLocationDescribe(true);//可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
        option.setIsNeedLocationPoiList(true);//可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
        option.setIgnoreKillProcess(false);//可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
        option.SetIgnoreCacheException(false);//可选，默认false，设置是否收集CRASH信息，默认收集
        option.setEnableSimulateGps(false);//可选，默认false，设置是否需要过滤GPS仿真结果，默认需要
        mLocationClient.setLocOption(option);

        mLocationClient.start();


        llLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), SelectLocActivity.class);
                startActivityForResult(intent, Constants.REQUEST);
            }
        });

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Constants.REQUEST && null != data) {

            ToastUtils.showToast(getActivity(), data.toString());
        }

    }

    @Override
    public void initNet() {

//        Map<String, Object> params = new HashMap<>();
//        params.put("tag", "yhoQ9arXKRk3AqpwPGwklOAb/ghFcjxlx0uZNXuiOhXg6sItA%2BuIMWLFLQzyVfRCP1db%2B11CZSVvwzQvNR8xKgpkH2h9VTHRsN%2BYmHqkIAyzz7k43NkbGG2outTo4jPx0rDNeDIv91zUyzcydmIpte201BBf%2BT9BPLyNvyF4J7OVxLARErSu64ttbf3HSJ5uPnMk%2B8ku6zn61Fg413ySmjaV61gBdMqBvXls83JOo9Oxc1WSrCpmdFaHuE6PhTV%2BI/2hz8iZWVjwemEepUKcF2vZdcpJEm6KCnHbU2n3MHvMNmQUgJtD9FZrnrMwhUNkX/3PRe3YuM3G8wiaJjubDLdg6gIx3JXwa8vcogM5DZ76PlkGK8qN0PJc0FGStks8LV7cDsi6CCKUkA%2BHun9p39G4JVSmmQS89tKiGKCE3rldZ5oFtqJyYG4FSx0B%2B999y%2BZHvM13mjm0L2iud/ufS1lWvO4FmkfwK1B9LE9BJdJtfw7bQeRI1gVd2JyxbXND479CHBEG7JCbBGCsqvQYq81JM4uuNSVPfEVGKG0IWge0f2226revj9Tw/W27J12uaAR%2BNnG508TCFMtR%2BvnFa16oCm7p8Nv0u7FeRHFlllDWcDrWDu78en5I8npEoCy55FyJpJgK2qnAdj504/abnne5JWs0vNwtWKzrFFwQ12H88gcF5ik9ILFhRiIMGXXi0Et/nQpnwp%2Bn4%2BRgMEEwPj8qL8Lx0E0iSE/aU4Q6NDBe%2BpRf1BWKrgeIANpb0NoCsbaSQRS7JhS4Nn8GUlUWagIQ6%2BOcLmV8ofmERnpOU4xitaUu5UlyP7z42m9W%2BzEzSK4tr1GhxgdyzZ56NkXcSeYtnhUNAwAdJn4tT4K8Yl1ZrsAguYwjREFolE60eeAJHkIhN/NFs6j8gcqCJ8CJmPb/QbRlyyhj8sejOg6Dkoe4zH9THyh9iqhB2y4NODmBNDRZnrg5UqR5m%2BzsbB6pdL5dchCa%2BT7OnD2aCj591YgRbDQPMnKKZ/O3tkbJHvjveOBx/Gd6QpQ9RI9budRT7c%2BQWpvYFyDOFi6%2BVY4C5zkBAWD6ZRvMoCRJ6tgXrLCLjrhGHoVw4iG5sTwiqTxVeeZqYUi1%2B8voGcCTmjU2HqlNEVP55pRP6C1daSMYfhRml8ZE%2Bja%2Bkz4Ict2KzGciSoB9fhXCf7EIPIy45BZKFKei3%2BA%2B4cKoWw%3D%3D");
//
//        Call rcall = RestClient.getClient().checkStatus(params);
//        rcall.enqueue(new Callback<ResultBean<LoanInitBean>>() {//这里不用解析json，所以随便传一个bean进去就可以
//            @Override
//            public void onResponse(Response<ResultBean<LoanInitBean>> response, Retrofit retrofit) {
//
//                ToastUtils.showToast(getActivity(), response.body().getApiResult().getMessage());
//                if (response.isSuccess()) {
//
//
//                }
//
//
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//
//                ToastUtils.showToast(getActivity(), t.toString());
////                showNetErr();
//
//            }
//        });
    }


    private void initSlideView() {


        BannerBean bean1 = new BannerBean();
        bean1.setDescription("新鲜蔬菜");
        bean1.setImagUrl("http://pic1.nipic.com/2008-08-12/2008812172217780_2.jpg");


        BannerBean bean2 = new BannerBean();
        bean2.setDescription("新鲜水果");
        bean2.setImagUrl("http://pic2.ooopic.com/10/34/82/00bOOOPIC2b.jpg");


        BannerBean bean3 = new BannerBean();
        bean3.setDescription("医疗药品");
        bean3.setImagUrl("http://img.daimg.com/uploads/allimg/150413/3-150413221523.jpg");
        bannerBeanList.add(bean1);
        bannerBeanList.add(bean2);
        bannerBeanList.add(bean3);


        for (BannerBean bean : bannerBeanList) {

            textSliderView = new TextSliderView(this.getActivity());
            textSliderView.description(bean.getDescription())
                    .image(bean.getImagUrl());
            sliderShow.addSlider(textSliderView);


            textSliderView.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(BaseSliderView slider) {


                    ToastUtils.showToast(getActivity(), slider.getDescription());
                }
            });
        }


        sliderShow.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderShow.setPresetTransformer(SliderLayout.Transformer.RotateUp);
        sliderShow.setCustomAnimation(new DescriptionAnimation());
//        sliderShow.setCustomIndicator(pagerIndicator);
        sliderShow.setDuration(3000);

    }


    private void initRecycleView() {

        //上面的view 横着的
        topRecycleViewInit();

        //下面的view，竖直的
        bottomRecycleViewInit();


    }

    private void topRecycleViewInit() {
        //新建List
        topList = new ArrayList<HomeGVBean>();
        //获取数据
        HomeGVBean bean1 = new HomeGVBean();
        bean1.setName("蔬菜");
        bean1.setImgUrl("http://pic1.nipic.com/2008-08-12/2008812172217780_2.jpg");

        HomeGVBean bean2 = new HomeGVBean();
        bean2.setName("水果");
        bean2.setImgUrl("http://pic2.ooopic.com/10/34/82/00bOOOPIC2b.jpg");

        HomeGVBean bean3 = new HomeGVBean();
        bean3.setName("医药");
        bean3.setImgUrl("http://img.daimg.com/uploads/allimg/150413/3-150413221523.jpg");


        HomeGVBean bean4 = new HomeGVBean();
        bean4.setName("超市");
        bean4.setImgUrl("http://pic2.ooopic.com/10/34/82/00bOOOPIC2b.jpg");

        HomeGVBean bean5 = new HomeGVBean();
        bean5.setName("鲜花");
        bean5.setImgUrl("http://img.daimg.com/uploads/allimg/150413/3-150413221523.jpg");


        topList.add(bean1);
        topList.add(bean2);
        topList.add(bean3);
        topList.add(bean4);
        topList.add(bean5);


        MyGridLayoutManager gridLayoutManager = new MyGridLayoutManager(this.getActivity(), 5);
        gridLayoutManager.setScrollEnabled(false);
        rvTop.setLayoutManager(gridLayoutManager);
        rvTop.setNestedScrollingEnabled(false);

        RvHomeTopAdapter adapter = new RvHomeTopAdapter(getActivity(), topList);

        adapter.setOnItemClickListener(new RvHomeTopAdapter.OnItemClickListener() {
            @Override
            public void onClick(View v, HomeGVBean bean) {

                ToastUtils.showToast(getActivity(), bean.getName());
            }
        });

        rvTop.setAdapter(adapter);
    }

    private void bottomRecycleViewInit() {


        bottomDatasInit();


        RvHomeAdapter rvAdapter = new RvHomeAdapter(bottomList, getActivity());

        rvAdapter.setOnItemClickListenter(new RvHomeAdapter.onItemClickListener() {
            @Override
            public void onClick(View v, CommunityBean bean) {

                ToastUtils.showToast(getActivity(), bean.getName());
            }
        });


        rvHome.setAdapter(rvAdapter);

        MyLinearLayoutManager linearLayoutManager = new MyLinearLayoutManager(this.getActivity());
        linearLayoutManager.setScrollEnabled(false);

        rvHome.setLayoutManager(linearLayoutManager);

        rvHome.addItemDecoration(new DividerItemDecoration(this.getActivity(),
                DividerItemDecoration.VERTICAL_LIST));

    }


    //添加假数据
    private void bottomDatasInit() {


        CommunityBean bean1 = new CommunityBean();

        bean1.setImgUrl("http://pic.58pic.com/58pic/17/45/92/87Q58PICbPt_1024.jpg");
        bean1.setName("水果兄弟");
        bean1.setSalesNum("月售36笔");
        bean1.setFullDetail("满30减25");
        bean1.setCoupon("新店开张。消费满20送10元代金券");
        bean1.setNotification("品牌鲜果，下单即达。");


        CommunityBean.DetailInfoBean bean11 = new CommunityBean.DetailInfoBean();
        CommunityBean.DetailInfoBean bean12 = new CommunityBean.DetailInfoBean();
        CommunityBean.DetailInfoBean bean13 = new CommunityBean.DetailInfoBean();
        CommunityBean.DetailInfoBean bean14 = new CommunityBean.DetailInfoBean();
        bean11.setImgSingle("http://img.ivsky.com/img/tupian/t/201101/22/shuiguo_daquan.jpg");
        bean11.setPrice("¥ 12.90");
        bean12.setImgSingle("http://img.ivsky.com/img/tupian/t/201101/22/shuiguo_daquan-006.jpg");
        bean12.setPrice("¥ 8.90");
        bean13.setImgSingle("http://img.ivsky.com/img/tupian/t/201101/22/shuiguo_daquan-012.jpg");
        bean13.setPrice("¥ 7.50");
        bean14.setImgSingle("http://img.ivsky.com/img/tupian/t/201101/22/shuiguo_daquan-015.jpg");
        bean14.setPrice("¥ 6.00");


        deatilBeanList.add(bean11);
        deatilBeanList.add(bean12);
        deatilBeanList.add(bean13);
        deatilBeanList.add(bean14);
        bean1.setDetailInfoBeanList(deatilBeanList);


        CommunityBean bean2 = new CommunityBean();

        bean2.setImgUrl("http://pic.58pic.com/58pic/17/45/92/87Q58PICbPt_1024.jpg");
        bean2.setName("凯德mall");
        bean2.setSalesNum("月售87笔");
        bean2.setFullDetail("满50减5");
        bean2.setCoupon("新店开张。消费满20送10元代金券");
        bean2.setNotification("周年店庆，满100减99");


        bottomList.add(bean1);
        bottomList.add(bean2);


    }

    @Override
    public void onStop() {
        super.onStop();
        sliderShow.stopAutoCycle();
    }


    @Override
    public void onResume() {
        super.onResume();
        sliderShow.startAutoCycle();
    }

    @Override
    public void onDestroy() {

        super.onDestroy();
        mLocationClient.stop();
    }
}
