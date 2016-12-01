package com.weblink.zbcommunity.activity;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.weblink.zbcommunity.R;
import com.weblink.zbcommunity.adapter.BaseAdapter;
import com.weblink.zbcommunity.adapter.RvHomeAdapter;
import com.weblink.zbcommunity.adapter.ServiceAdapter;
import com.weblink.zbcommunity.bean.BannerBean;
import com.weblink.zbcommunity.bean.BasicBean;
import com.weblink.zbcommunity.bean.CommunityBean;
import com.weblink.zbcommunity.utils.ToastUtils;
import com.weblink.zbcommunity.views.MyGridLayoutManager;
import com.weblink.zbcommunity.views.MyLinearLayoutManager;
import com.weblink.zbcommunity.views.MyScrollview;
import com.weblink.zbcommunity.widget.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by swq on 2016/11/23.
 *
 * 上门服务
 */
public class CallServiceActivity extends BaseActivity implements View.OnClickListener {


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
    @BindView(R.id.slider)
    SliderLayout sliderShow;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.scrollview)
    MyScrollview scrollView;
    @BindView(R.id.rv_call_service)
    RecyclerView rvCallService;

    //轮播图数据
    private List<BannerBean> bannerBeanList = new ArrayList<>();
    private TextSliderView textSliderView;

    private List<CommunityBean.DetailInfoBean> deatilBeanList = new ArrayList<>();
    //下面的竖直方向的数据
    private List<CommunityBean> bottomList = new ArrayList<>();

    @Override
    public void setContent() {

        setContentView(R.layout.activity_channel);
    }

    @Override
    public void initView() {

//        String channelName = getIntent().getStringExtra("channelName");

        ivLeft.setVisibility(View.VISIBLE);
        tvTitle.setText("上门频道");
        ivRight.setVisibility(View.VISIBLE);
        ivRight.setImageResource(R.drawable.icon_search);
        //scrollview滑动到顶部
        scrollView.smoothScrollTo(0, 0);
        ivLeft.setOnClickListener(this);
        ivRight.setOnClickListener(this);

        initSlideView();


        serviceRecycleViewInit();
        bottomRecycleViewInit();

    }


    private void serviceRecycleViewInit() {

        rvCallService.setVisibility(View.VISIBLE);
        rvCallService.setLayoutManager(new MyGridLayoutManager(this, 2));
        rvCallService.setNestedScrollingEnabled(false);


        List<BasicBean> list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {

            list.add(new BasicBean("http://i3.s1.dpfile.com/pc/72e62fe94c3114358d67ad48c0497a19%28700x700%29/thumb.jpg", "电脑维修" + i));
        }

        final ServiceAdapter adapter = new ServiceAdapter(this, R.layout.service_item, list);
        rvCallService.setAdapter(adapter);

        adapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                ToastUtils.showToast(CallServiceActivity.this, adapter.getItem(position).getName());


//                Intent it = new Intent(CallServiceActivity.this, ChannelActivity.class);
                Intent it = new Intent(CallServiceActivity.this, RepairServiceActivity.class);

                it.putExtra("channelName", adapter.getItem(position).getName());
                startActivity(it);
            }
        });

    }

    @Override
    public void initNet() {

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

            textSliderView = new TextSliderView(this);
            textSliderView.description(bean.getDescription())
                    .image(bean.getImagUrl());
            sliderShow.addSlider(textSliderView);


            textSliderView.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(BaseSliderView slider) {


                    ToastUtils.showToast(CallServiceActivity.this, slider.getDescription());
                }
            });
        }


        sliderShow.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderShow.setPresetTransformer(SliderLayout.Transformer.RotateUp);
        sliderShow.setCustomAnimation(new DescriptionAnimation());
//        sliderShow.setCustomIndicator(pagerIndicator);
        sliderShow.setDuration(3000);

    }


    private void bottomRecycleViewInit() {


        bottomDatasInit();


        RvHomeAdapter rvAdapter = new RvHomeAdapter(bottomList, CallServiceActivity.this);

        rvAdapter.setOnItemClickListenter(new RvHomeAdapter.onItemClickListener() {
            @Override
            public void onClick(View v, CommunityBean bean) {

                ToastUtils.showToast(CallServiceActivity.this, bean.getName());
            }
        });


        recyclerView.setAdapter(rvAdapter);

        MyLinearLayoutManager linearLayoutManager = new MyLinearLayoutManager(CallServiceActivity.this);
        linearLayoutManager.setScrollEnabled(false);

        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.addItemDecoration(new DividerItemDecoration(CallServiceActivity.this,
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


        CommunityBean bean3 = new CommunityBean();

        bean3.setImgUrl("http://pic.58pic.com/58pic/17/45/92/87Q58PICbPt_1024.jpg");
        bean3.setName("水果兄弟");
        bean3.setSalesNum("月售36笔");
        bean3.setFullDetail("满30减25");
        bean3.setCoupon("新店开张。消费满20送10元代金券");
        bean3.setNotification("品牌鲜果，下单即达。");


        CommunityBean.DetailInfoBean bean31 = new CommunityBean.DetailInfoBean();
        CommunityBean.DetailInfoBean bean32 = new CommunityBean.DetailInfoBean();
        CommunityBean.DetailInfoBean bean33 = new CommunityBean.DetailInfoBean();
        CommunityBean.DetailInfoBean bean34 = new CommunityBean.DetailInfoBean();
        bean31.setImgSingle("http://img.ivsky.com/img/tupian/t/201101/22/shuiguo_daquan.jpg");
        bean31.setPrice("¥ 12.90");
        bean32.setImgSingle("http://img.ivsky.com/img/tupian/t/201101/22/shuiguo_daquan-006.jpg");
        bean32.setPrice("¥ 8.90");
        bean33.setImgSingle("http://img.ivsky.com/img/tupian/t/201101/22/shuiguo_daquan-012.jpg");
        bean33.setPrice("¥ 7.50");
        bean34.setImgSingle("http://img.ivsky.com/img/tupian/t/201101/22/shuiguo_daquan-015.jpg");
        bean34.setPrice("¥ 6.00");

        deatilBeanList.clear();
        deatilBeanList.add(bean31);
        deatilBeanList.add(bean32);
        deatilBeanList.add(bean33);
        deatilBeanList.add(bean34);
        bean3.setDetailInfoBeanList(deatilBeanList);

        bottomList.add(bean1);
        bottomList.add(bean2);
        bottomList.add(bean3);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.iv_left:
                finish();
                break;

            case R.id.iv_right:
                Intent it = new Intent(CallServiceActivity.this, SearchActivity.class);
                startActivity(it);


        }

    }
}
