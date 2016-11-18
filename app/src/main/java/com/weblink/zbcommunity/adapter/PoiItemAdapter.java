package com.weblink.zbcommunity.adapter;

import android.content.Context;

import com.amap.api.services.core.PoiItem;
import com.weblink.zbcommunity.R;

import java.util.List;

/**
 * Created by swq on 2016/11/17.
 */
public class PoiItemAdapter extends SimpleAdapter<PoiItem> {


    public PoiItemAdapter(Context context, List<PoiItem> datas) {

        super(context, R.layout.sea_loc_item, datas);


    }

    @Override
    protected void convert(BaseViewHolder viewHoder, PoiItem item) {


        viewHoder.getTextView(R.id.loc_tittle).setText(item.getTitle());
        viewHoder.getTextView(R.id.loc_snippet).setText(item.getAdName() + "  " + item.getSnippet());
    }
}
