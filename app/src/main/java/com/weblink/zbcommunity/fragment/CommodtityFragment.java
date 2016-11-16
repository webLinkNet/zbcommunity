package com.weblink.zbcommunity.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.weblink.zbcommunity.R;
import com.weblink.zbcommunity.activity.CommkindActivity;
import com.weblink.zbcommunity.adapter.CommGvAdpter;
import com.weblink.zbcommunity.adapter.CommListAdapter;
import com.weblink.zbcommunity.bean.CommodgvBean;

import java.util.ArrayList;
import java.util.List;


public class CommodtityFragment extends Fragment implements OnItemClickListener {

    private String[] strs = {"蔬菜", "水果", "肉类", "水产", "熟食", "冷藏食品", "冷冻食品",
            "调料类", "烟酒饮料", "休闲食品", "粮油", "个人护理", "清理用品", "药品",
            "电子", "鲜花", "上门"};
    List<CommodgvBean> datas = new ArrayList<>();
    List<CommodgvBean> dadas = new ArrayList<>();
    private CommodgvBean commodgvBean = new CommodgvBean();
    private CommodgvBean commodgvBean1 = new CommodgvBean();
    private ListView listView;
    private GridView grid;
    private CommListAdapter adapter;
    private CommGvAdpter adapterr;
    public static int mPosition;
    private TextView tv_total;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.commodtity_fragment, container, false);
        listView = (ListView) contentView.findViewById(R.id.listview);
        tv_total=(TextView)contentView.findViewById(R.id.tv_title);
        tv_total.setText("商品");
        adapter = new CommListAdapter(getActivity(), strs);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        intdata();
        grid = (GridView) contentView.findViewById(R.id.grid);
        adptergrid(datas);
        grid.setOnItemClickListener(this);
        return contentView;
    }

    public void intdata() {

        commodgvBean.setKintext("测试");
        commodgvBean.setKinurl("http://desk.fd.zol-img.com.cn/t_s960x600c5/g5/M00/02/03/ChMkJ1bKxpWIIp3vAAimMffVdTgAALHnQMKJY0ACKZJ164.jpg");
        datas.add(commodgvBean);
        commodgvBean1.setKintext("数据");
        commodgvBean1.setKinurl( "http://desk.fd.zol-img.com.cn/t_s960x600c5/g4/M00/0D/01/Cg-4y1ULoXCII6fEAAeQFx3fsKgAAXCmAPjugYAB5Av166.jpg");
        dadas.add(commodgvBean1);
    }

    public void adptergrid(List<CommodgvBean> datass) {

        adapterr = new CommGvAdpter(getActivity(), datass);
        grid.setAdapter(adapterr);
    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

        //list的点击事件
        if (arg0 == listView) {
            mPosition = position;
            adapter.notifyDataSetChanged();

            if (position % 2 == 0) {
                adapter.notifyDataSetChanged();
                adapterr.notifyDataSetChanged();
                adptergrid(datas);
            } else {
                adptergrid(dadas);
            }
        }

        //单个条目的点击事件
        if (arg0 == grid) {
            //Toast.makeText(getActivity(),"点击了",Toast.LENGTH_SHORT).show();
            Intent intentkind =new Intent(getActivity(), CommkindActivity.class);
            startActivity(intentkind);

        }
    }

/*	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {

		mPosition = position;
		adapter.notifyDataSetChanged();
		for (int i = 0; i < strs.length; i++) {
			myFragment = new MyFragment();
			android.app.FragmentTransaction fragmentTransaction = getFragmentManager()
					.beginTransaction();
			fragmentTransaction.replace(R.id.fragment_container, myFragment);
			Bundle bundle = new Bundle();
			bundle.putString(MyFragment.TAG, strs[position]);
			myFragment.setArguments(bundle);
			fragmentTransaction.commit();
		}
	}*/
}
