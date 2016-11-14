package com.weblink.zbcommunity.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.weblink.zbcommunity.R;
import com.weblink.zbcommunity.bean.HomeGVBean;

import java.util.List;

/**
 * Created by swq on 2016/11/4.
 */
public class RvHomeTopAdapter extends RecyclerView.Adapter<RvHomeTopAdapter.RvHomeTopHolder> {


    private Context context;
    private List<HomeGVBean> list;

    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener) {

        this.listener = listener;
    }

    public RvHomeTopAdapter(Context context, List<HomeGVBean> list) {

        this.context = context;
        this.list = list;

    }

    @Override
    public RvHomeTopAdapter.RvHomeTopHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(context).inflate(R.layout.item_gradview_home, parent, false);
        RvHomeTopHolder holder = new RvHomeTopHolder(inflate);

        return holder;
    }

    @Override
    public void onBindViewHolder(RvHomeTopAdapter.RvHomeTopHolder holder, int position) {

        holder.image.setImageURI(Uri.parse(list.get(position).getImgUrl()));
        holder.tvName.setText(list.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public interface OnItemClickListener {

        void onClick(View v, HomeGVBean bean);
    }


    class RvHomeTopHolder extends RecyclerView.ViewHolder {

        private SimpleDraweeView image;
        private TextView tvName;

        public RvHomeTopHolder(View itemView) {
            super(itemView);


            image = (SimpleDraweeView) itemView.findViewById(R.id.image);
            tvName = (TextView) itemView.findViewById(R.id.text);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(v, list.get(getLayoutPosition()));
                }
            });


            //附加功能，设置图形为圆形
            setCircleBitmap(image);


        }
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
