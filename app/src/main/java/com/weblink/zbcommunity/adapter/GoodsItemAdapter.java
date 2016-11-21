package com.weblink.zbcommunity.adapter;

import android.content.Context;
import android.net.Uri;

import com.weblink.zbcommunity.R;
import com.weblink.zbcommunity.bean.SearchResultBean;

import java.util.List;

/**
 * Created by swq on 2016/11/21.
 */
public class GoodsItemAdapter extends SimpleAdapter<SearchResultBean> {


    public GoodsItemAdapter(Context context, int layoutId, List<SearchResultBean> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(BaseViewHolder viewHoder, SearchResultBean item) {

        viewHoder.getSimpleDraweeView(R.id.sd_img).setImageURI(Uri.parse(item.getImgUrl()));
        viewHoder.getTextView(R.id.tv_name).setText(item.getShopName());
        viewHoder.getTextView(R.id.tv_price).setText("¥ 9.9");
    }
}
