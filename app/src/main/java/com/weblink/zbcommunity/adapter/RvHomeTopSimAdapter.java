package com.weblink.zbcommunity.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;

import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.weblink.zbcommunity.R;
import com.weblink.zbcommunity.bean.HomeGVBean;
import com.weblink.zbcommunity.utils.ToastUtils;

import java.util.List;

/**
 * Created by swq on 2016/11/17.
 */
public class RvHomeTopSimAdapter extends SimpleAdapter<HomeGVBean> {


    private Context context;

    public RvHomeTopSimAdapter(Context context, List<HomeGVBean> datas) {
        super(context, R.layout.item_gradview_home, datas);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder viewHoder, final HomeGVBean item) {

        viewHoder.getTextView(R.id.text).setText(item.getName());
        viewHoder.getSimpleDraweeView(R.id.image).setImageURI(Uri.parse(item.getImgUrl()));
        //附加功能，设置图形为圆形
        setCircleBitmap(viewHoder.getSimpleDraweeView(R.id.image));

        viewHoder.getSimpleDraweeView(R.id.image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showToast(context, item.getName() + "图片");
            }
        });
    }

    private void setCircleBitmap(SimpleDraweeView image) {
        //获取GenericDraweeHierarchy对象
        GenericDraweeHierarchy hierarchy = GenericDraweeHierarchyBuilder.newInstance(context.getResources())
                //设置圆形圆角参数；RoundingParams.asCircle()是将图像设置成圆形
                .setRoundingParams(RoundingParams.asCircle())
                //设置淡入淡出动画持续时间(单位：毫秒ms)
                .setFadeDuration(3000)
                //构建
                .build();

        image.setHierarchy(hierarchy);
    }
}
