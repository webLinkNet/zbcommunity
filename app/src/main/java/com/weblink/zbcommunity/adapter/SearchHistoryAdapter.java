package com.weblink.zbcommunity.adapter;

import android.content.Context;

import com.weblink.zbcommunity.R;

import java.util.List;

/**
 * Created by swq on 2016/11/21.
 */
public class SearchHistoryAdapter extends SimpleAdapter<String> {


    public SearchHistoryAdapter(Context context, int layoutId, List<String> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(BaseViewHolder viewHoder, String item) {


        viewHoder.getTextView(R.id.tv_name).setText(item);
    }
}
