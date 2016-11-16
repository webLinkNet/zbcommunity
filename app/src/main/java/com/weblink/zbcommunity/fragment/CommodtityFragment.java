package com.weblink.zbcommunity.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ListView;

import com.weblink.zbcommunity.R;
import com.weblink.zbcommunity.adapter.CommGvAdpter;
import com.weblink.zbcommunity.adapter.CommListAdapter;


public class CommodtityFragment extends Fragment implements OnItemClickListener {
    
	private  String[] stringssss={"http://desk.fd.zol-img.com.cn/t_s960x600c5/g5/M00/02/03/ChMkJ1bKxpWIIp3vAAimMffVdTgAALHnQMKJY0ACKZJ164.jpg"
			,"http://desk.fd.zol-img.com.cn/t_s960x600c5/g4/M00/0D/01/Cg-4y1ULoXCII6fEAAeQFx3fsKgAAXCmAPjugYAB5Av166.jpg","http://desk.fd.zol-img.com.cn/t_s960x600c5/g5/M00/02/03/ChMkJ1bKxpWIIp3vAAimMffVdTgAALHnQMKJY0ACKZJ164.jpg"
			,"http://desk.fd.zol-img.com.cn/t_s960x600c5/g4/M00/0D/01/Cg-4y1ULoXCII6fEAAeQFx3fsKgAAXCmAPjugYAB5Av166.jpg","http://desk.fd.zol-img.com.cn/t_s960x600c5/g5/M00/02/03/ChMkJ1bKxpWIIp3vAAimMffVdTgAALHnQMKJY0ACKZJ164.jpg"
			,"http://desk.fd.zol-img.com.cn/t_s960x600c5/g4/M00/0D/01/Cg-4y1ULoXCII6fEAAeQFx3fsKgAAXCmAPjugYAB5Av166.jpg","http://desk.fd.zol-img.com.cn/t_s960x600c5/g5/M00/02/03/ChMkJ1bKxpWIIp3vAAimMffVdTgAALHnQMKJY0ACKZJ164.jpg"
			,"http://desk.fd.zol-img.com.cn/t_s960x600c5/g4/M00/0D/01/Cg-4y1ULoXCII6fEAAeQFx3fsKgAAXCmAPjugYAB5Av166.jpg","http://desk.fd.zol-img.com.cn/t_s960x600c5/g5/M00/02/03/ChMkJ1bKxpWIIp3vAAimMffVdTgAALHnQMKJY0ACKZJ164.jpg"
			,"http://desk.fd.zol-img.com.cn/t_s960x600c5/g4/M00/0D/01/Cg-4y1ULoXCII6fEAAeQFx3fsKgAAXCmAPjugYAB5Av166.jpg","http://desk.fd.zol-img.com.cn/t_s960x600c5/g5/M00/02/03/ChMkJ1bKxpWIIp3vAAimMffVdTgAALHnQMKJY0ACKZJ164.jpg"
			,"http://desk.fd.zol-img.com.cn/t_s960x600c5/g4/M00/0D/01/Cg-4y1ULoXCII6fEAAeQFx3fsKgAAXCmAPjugYAB5Av166.jpg","http://desk.fd.zol-img.com.cn/t_s960x600c5/g5/M00/02/03/ChMkJ1bKxpWIIp3vAAimMffVdTgAALHnQMKJY0ACKZJ164.jpg"
			,"http://desk.fd.zol-img.com.cn/t_s960x600c5/g4/M00/0D/01/Cg-4y1ULoXCII6fEAAeQFx3fsKgAAXCmAPjugYAB5Av166.jpg","http://desk.fd.zol-img.com.cn/t_s960x600c5/g5/M00/02/03/ChMkJ1bKxpWIIp3vAAimMffVdTgAALHnQMKJY0ACKZJ164.jpg"
			,"http://desk.fd.zol-img.com.cn/t_s960x600c5/g4/M00/0D/01/Cg-4y1ULoXCII6fEAAeQFx3fsKgAAXCmAPjugYAB5Av166.jpg" };
	private  String[] stringsss={"测试","数据","蔬菜", "水果", "肉类", "水产", "熟食", "冷藏食品", "冷冻食品",
			"调料类", "烟酒饮料","休闲食品", "粮油", "个人护理","清理用品", "药品"};
	private  String[] stringss={"香蕉","苹果","蔬菜", "水果", "肉类", "水产", "熟食", "冷藏食品", "冷冻食品",
			"调料类", "烟酒饮料","休闲食品", "粮油", "个人护理","清理用品", "药品"};
	private  String[] strings = {"白菜","菠菜","蔬菜", "水果", "肉类", "水产", "熟食", "冷藏食品", "冷冻食品",
			"调料类", "烟酒饮料","休闲食品", "粮油", "个人护理","清理用品", "药品"};
	private  String[] strs = { "蔬菜", "水果", "肉类", "水产", "熟食", "冷藏食品", "冷冻食品",
			"调料类", "烟酒饮料","休闲食品", "粮油", "个人护理","清理用品", "药品",
			"电子","鲜花","上门" };
	private ListView listView;
	private GridView grid;
	private CommListAdapter adapter;
	private CommGvAdpter adapterr;
	public static int mPosition;
	public static int mPositionf;
	public static final String TAG = "MyFragment";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View contentView = inflater.inflate(R.layout.commodtity_fragment,container, false);
		listView = (ListView)contentView.findViewById(R.id.listview);
		adapter = new CommListAdapter(getActivity(), strs);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(this);
		grid=(GridView) contentView.findViewById(R.id.grid);
	    adptergrid(stringsss,stringssss);
		grid.setOnItemClickListener(this);
		return contentView;			
	}
	
	public void  adptergrid(String[]gridstring, String[]gridurl){
		 adapterr=new CommGvAdpter(getActivity(), gridstring,gridurl);
		grid.setAdapter(adapterr);	
	}
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
	  
		//list的点击事件
		if(arg0==listView){
		mPosition = position;
		adapter.notifyDataSetChanged();

		if(position%2==0){
			adapter.notifyDataSetChanged();
			adapterr.notifyDataSetChanged();
			 adptergrid(stringss,stringssss);
		}
		else{
			 adptergrid(strings,stringssss);
		}
		}
		
		//单个条目的点击事件
		if(arg0==grid){
			
			
			
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
