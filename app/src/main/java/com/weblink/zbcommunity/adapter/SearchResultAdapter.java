package com.weblink.zbcommunity.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;

import com.weblink.zbcommunity.R;
import com.weblink.zbcommunity.bean.SearchResultBean;
import com.weblink.zbcommunity.views.MyLinearLayoutManager;

import java.util.List;

/**
 * Created by swq on 2016/11/21.
 */
public class SearchResultAdapter extends SimpleAdapter<SearchResultBean> {


    private Context context;

    public SearchResultAdapter(Context context, int layoutId, List<SearchResultBean> datas) {
        super(context, layoutId, datas);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder viewHoder, SearchResultBean item) {

        viewHoder.getSimpleDraweeView(R.id.sd_img).setImageURI(Uri.parse(item.getImgUrl()));
        viewHoder.getTextView(R.id.tv_name).setText(item.getShopName());

        RecyclerView rvGoods = (RecyclerView) viewHoder.getView(R.id.rv_goods);

        GoodsItemAdapter adapter = new GoodsItemAdapter(context, R.layout.item_goods, item.getList());
        rvGoods.setLayoutManager(new MyLinearLayoutManager(context));
        rvGoods.setAdapter(adapter);

    }
}
