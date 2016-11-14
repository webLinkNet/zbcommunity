package com.weblink.zbcommunity.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.weblink.zbcommunity.R;
import com.weblink.zbcommunity.bean.CommunityBean;
import com.weblink.zbcommunity.utils.ToastUtils;

import java.util.List;

/**
 * Created by swq on 2016/11/10.
 */
public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.InfoViewHolder> {


    private Context mContext;
    private List<CommunityBean.DetailInfoBean> infoBeanList;

    public InfoAdapter(Context context, List<CommunityBean.DetailInfoBean> infoBeanList) {

        this.mContext = context;
        this.infoBeanList = infoBeanList;

    }

    @Override
    public InfoAdapter.InfoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(mContext).inflate(R.layout.item_single_info, parent, false);

        InfoViewHolder holder = new InfoViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(InfoViewHolder holder, int position) {


        holder.sdImg.setImageURI(Uri.parse(infoBeanList.get(position).getImgSingle()));
        holder.tvPrice.setText(infoBeanList.get(position).getPrice());

    }


    @Override
    public int getItemCount() {
        return infoBeanList.size();
    }

    public class InfoViewHolder extends RecyclerView.ViewHolder {

        SimpleDraweeView sdImg;
        TextView tvPrice;
        LinearLayout llInfo;

        public InfoViewHolder(final View itemView) {
            super(itemView);

            llInfo = (LinearLayout) itemView.findViewById(R.id.ll_info);
            sdImg = (SimpleDraweeView) itemView.findViewById(R.id.sd_img);
            tvPrice = (TextView) itemView.findViewById(R.id.tv_price);

            llInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToastUtils.showToast(mContext, infoBeanList.get(getLayoutPosition()).getPrice());
                }
            });

        }
    }
}
