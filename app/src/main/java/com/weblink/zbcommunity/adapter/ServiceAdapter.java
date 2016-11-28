package com.weblink.zbcommunity.adapter;

import android.content.Context;
import android.net.Uri;

import com.weblink.zbcommunity.R;
import com.weblink.zbcommunity.bean.BasicBean;

import java.util.List;

/**
 * Created by swq on 2016/11/28.
 */
public class ServiceAdapter extends SimpleAdapter<BasicBean> {


    private Context mContext;
    private int mLayoutId;
    private List<BasicBean> mDatas;

    public ServiceAdapter(Context context, int layoutId, List<BasicBean> datas) {
        super(context, layoutId, datas);

        this.mContext = context;
        this.mLayoutId = layoutId;
        this.mDatas = datas;
    }

    @Override
    protected void convert(BaseViewHolder viewHoder, BasicBean item) {


        viewHoder.getSimpleDraweeView(R.id.sd_img).setImageURI(Uri.parse(item.toString()));

        viewHoder.getTextView(R.id.tv_category).setText(item.getName());

    }

}
