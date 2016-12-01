package com.weblink.zbcommunity.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;

import com.weblink.zbcommunity.R;
import com.weblink.zbcommunity.bean.RepairServiceBean;
import com.weblink.zbcommunity.utils.ToastUtils;

import java.util.List;

/**
 * Created by swq on 2016/12/1.
 */
public class RepairServiceAdapter extends SimpleAdapter<RepairServiceBean> {


    private Context context;
    public RepairServiceAdapter(Context context, int layoutId, List<RepairServiceBean> datas) {
        super(context, layoutId, datas);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder viewHoder, RepairServiceBean item) {


        viewHoder.getSimpleDraweeView(R.id.sd_img).setImageURI(Uri.parse(item.getImg()));
        viewHoder.getTextView(R.id.tv_name).setText(item.getName());
        viewHoder.getTextView(R.id.tv_price).setText("¥  " + item.getPrice());

        viewHoder.getButton(R.id.btn_buy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ToastUtils.showToast(context,"跳转到订单界面");
            }
        });
    }
}
