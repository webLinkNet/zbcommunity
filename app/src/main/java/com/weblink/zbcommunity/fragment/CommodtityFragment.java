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
    private CommodgvBean commodgvBean2 = new CommodgvBean();
    private CommodgvBean commodgvBean3 = new CommodgvBean();
    private CommodgvBean commodgvBean4 = new CommodgvBean();
    private CommodgvBean commodgvBean5 = new CommodgvBean();
    private CommodgvBean commodgvBean6 = new CommodgvBean();
    private CommodgvBean commodgvBean7 = new CommodgvBean();
    private CommodgvBean commodgvBean8 = new CommodgvBean();
    private CommodgvBean commodgvBean9 = new CommodgvBean();
    private CommodgvBean commodgvBean10 = new CommodgvBean();
    private CommodgvBean commodgvBean11 = new CommodgvBean();
    private CommodgvBean commodgvBean12 = new CommodgvBean();
    private CommodgvBean commodgvBean13 = new CommodgvBean();
    private CommodgvBean commodgvBean14 = new CommodgvBean();
    private CommodgvBean commodgvBean15 = new CommodgvBean();


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
        tv_total = (TextView) contentView.findViewById(R.id.tv_title);
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

        commodgvBean.setKintext("茄子");
        commodgvBean.setKinurl("http://pic31.nipic.com/20130711/9490444_115207012303_2.jpg");
        datas.add(commodgvBean);
        commodgvBean1.setKintext("数据");
        commodgvBean1.setKinurl("http://desk.fd.zol-img.com.cn/t_s960x600c5/g4/M00/0D/01/Cg-4y1ULoXCII6fEAAeQFx3fsKgAAXCmAPjugYAB5Av166.jpg");
        dadas.add(commodgvBean1);

        commodgvBean2.setKintext("西红柿");
        commodgvBean2.setKinurl("http://homemade.keliren.cn/tuku/a/20160405/5703c56a43842.jpg_600.jpg");
        datas.add(commodgvBean2);
        commodgvBean3.setKintext("菜椒");
        commodgvBean3.setKinurl("http://pic3.nipic.com/20090713/2343681_131215028_2.jpg");
        datas.add(commodgvBean3);
        commodgvBean4.setKintext("白菜");
        commodgvBean4.setKinurl("http://pic.58pic.com/58pic/15/40/30/63D58PICdSQ_1024.jpg");
        datas.add(commodgvBean4);
        commodgvBean5.setKintext("搭配");
        commodgvBean5.setKinurl("http://img.taopic.com/uploads/allimg/120323/2257-12032323245797.jpg");
        datas.add(commodgvBean5);
        commodgvBean6.setKintext("大葱");
        commodgvBean6.setKinurl("http://pic71.nipic.com/file/20150627/2692994_134418584000_2.jpg");
        datas.add(commodgvBean6);
        commodgvBean7 = commodgvBean;
        datas.add(commodgvBean7);
        commodgvBean8 = commodgvBean1;
        datas.add(commodgvBean8);
        commodgvBean9 = commodgvBean2;
        datas.add(commodgvBean9);
        commodgvBean10 = commodgvBean3;
        datas.add(commodgvBean10);
        commodgvBean11 = commodgvBean4;
        datas.add(commodgvBean11);
        commodgvBean12 = commodgvBean1;
        datas.add(commodgvBean12);
        commodgvBean13 = commodgvBean2;
        datas.add(commodgvBean13);
        commodgvBean14 = commodgvBean3;
        datas.add(commodgvBean14);
        commodgvBean15 = commodgvBean4;
        datas.add(commodgvBean15);


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

        }
        //单个条目的点击事件
        if (arg0 == grid) {
            //Toast.makeText(getActivity(),"点击了",Toast.LENGTH_SHORT).show();

            CommodgvBean c = datas.get(position);
            String cc = c.getKintext();
            Intent intentkind = new Intent(getActivity(), CommkindActivity.class);
            intentkind.putExtra("sousuo", cc);
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
