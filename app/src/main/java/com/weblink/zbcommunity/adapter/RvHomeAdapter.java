package com.weblink.zbcommunity.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.weblink.zbcommunity.R;
import com.weblink.zbcommunity.bean.CommunityBean;
import com.weblink.zbcommunity.views.MyGridLayoutManager;

import java.util.List;

/**
 * Created by swq on 2016/11/3.
 */
public class RvHomeAdapter extends RecyclerView.Adapter<RvHomeAdapter.RvHomeViewHolder> {


    private List<CommunityBean> list;
    private Context context;


    private onItemClickListener listener;

    public void setOnItemClickListenter(onItemClickListener listener) {

        this.listener = listener;

    }

    public RvHomeAdapter(List<CommunityBean> list, Context context) {

        this.list = list;
        this.context = context;
    }

    @Override
    public RvHomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_home_shop, parent, false);

        RvHomeViewHolder holder = new RvHomeViewHolder(view);


        return holder;
    }


    @Override
    public void onBindViewHolder(RvHomeViewHolder holder, int position) {

        holder.sdImage.setImageURI(Uri.parse(list.get(position).getImgUrl()));
        holder.tvName.setText(list.get(position).getName());
        holder.tvSalesNum.setText(" | "+list.get(position).getSalesNum());
        holder.tvFullDetail.setText(list.get(position).getFullDetail());
        holder.tvCoupon.setText(list.get(position).getCoupon());
        holder.tvNoti.setText(list.get(position).getNotification());


        if (null != list.get(position).getDetailInfoBeanList() && list.get(position).getDetailInfoBeanList().size() > 0) {

            InfoAdapter infoAdapter = new InfoAdapter(context, list.get(position).getDetailInfoBeanList());
            holder.recycleInfo.setLayoutManager(new MyGridLayoutManager(context, 4));
            holder.recycleInfo.setAdapter(infoAdapter);
            holder.recycleInfo.setVisibility(View.VISIBLE);

        } else {

            holder.recycleInfo.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public interface onItemClickListener {

        void onClick(View v, CommunityBean bean);
    }

    class RvHomeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        SimpleDraweeView sdImage;
        TextView tvName, tvSalesNum;
        TextView tvFullDetail, tvCoupon, tvNoti;
        RecyclerView recycleInfo;

        public RvHomeViewHolder(final View itemView) {
            super(itemView);

            sdImage = (SimpleDraweeView) itemView.findViewById(R.id.sd_img);

            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvSalesNum = (TextView) itemView.findViewById(R.id.tv_sales_num);
            tvFullDetail = (TextView) itemView.findViewById(R.id.tv_full_detail);
            tvCoupon = (TextView) itemView.findViewById(R.id.tv_coupon_detail);
            tvNoti = (TextView) itemView.findViewById(R.id.tv_noti);

            recycleInfo = (RecyclerView) itemView.findViewById(R.id.recycle_info);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    if (listener != null) {


//                        ObjectAnimator animator = ObjectAnimator.ofFloat(v, "rotationX", 0.0F, 360.0F)
//                                .setDuration(200);
//                        animator.addListener(new AnimatorListenerAdapter() {
//                            @Override
//                            public void onAnimationEnd(Animator animation) {
//
                        listener.onClick(v, list.get(getLayoutPosition()));
//
//                            }
//                        });
//                        animator.start();
                    }
                }
            });


//            btnAddCart.setOnClickListener(this);
//            btnBuy.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            if (null != listener) {

//                anim(v);

            }
        }

        /*
        private void anim(final View v) {


            ObjectAnimator animator = ObjectAnimator.ofFloat(v, "rotationX", 0.0F, 360.0F)
                    .setDuration(200);
            animator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {

                    CommunityBean bean = list.get(getLayoutPosition());

                    switch (v.getId()) {

                        case R.id.btn_addcart:
                            ToastUtils.showToast(context,"购物车");
                            break;

                        case R.id.btn_buy:
                            ToastUtils.showToast(context,"购买");
                            break;

                    }

                }
            });
            animator.start();
        }

        */

    }
}
