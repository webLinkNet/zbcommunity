package com.weblink.zbcommunity.adapter;

import android.content.Context;

import java.util.List;

/**
 * Created by swq on 2016/11/17.
 */
public abstract class SimpleAdapter<T> extends BaseAdapter<T,BaseViewHolder> {
    public SimpleAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    public SimpleAdapter(Context context, int layoutId, List<T> datas) {
        super(context, layoutId, datas);
    }
}
