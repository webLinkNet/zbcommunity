package com.weblink.zbcommunity.adapter;

/**
 * Created by Administrator on 2016/11/24.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;



import com.bumptech.glide.Glide;
import com.weblink.zbcommunity.R;
import com.weblink.zbcommunity.bean.ChildBean;
import com.weblink.zbcommunity.bean.requestbean.CommKindThingBean;

import java.util.List;
/**
 * Created by Administrator on 2016/11/22.
 */

public class CommKindThingAdpter extends BaseExpandableListAdapter {
    Context context;
    List<CommKindThingBean> data;
    public  CommKindThingAdpter(Context context,List<CommKindThingBean> data){

        this.context=context;
        this.data=data;
    }
    @Override
    public int getGroupCount() {
        return data.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return data.get(groupPosition).getChildlist().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return data.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return data.get(groupPosition).getChildlist().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        CommKindThingBean c=data.get(groupPosition);
        convertView= LayoutInflater.from(context).inflate(R.layout.father,parent,false);
        ImageView fatherimg = (ImageView)convertView.findViewById(R.id.father_img);
        TextView fathername=(TextView) convertView.findViewById(R.id.father_name);

        Glide.with(context).load(c.getFatherimg()).into(fatherimg);
        fathername.setText(c.getFathername());


        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

       ChildBean g= data.get(groupPosition).getChildlist().get(childPosition);

        convertView=LayoutInflater.from(context).inflate(R.layout.child,parent,false);
        ImageView childimg=(ImageView)convertView.findViewById(R.id.child_img);
        TextView childjieshao=(TextView)convertView.findViewById(R.id.child_jieshao);
        TextView childprice =(TextView)convertView.findViewById(R.id.child_price);

        Glide.with(context).load(g.getChildimg()).into(childimg);
        childjieshao.setText(g.getJieshao());
        childprice.setText("¥"+g.getPrice());

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
