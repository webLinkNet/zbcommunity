package com.weblink.zbcommunity.fragment;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.weblink.zbcommunity.R;
import com.weblink.zbcommunity.bean.CartBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/18.
 */

public class CartFragment extends Fragment implements View.OnClickListener

{
    private static final int INITIALIZE = 0;

    private ListView mListView;// 列表

    private ListAdapter mListAdapter;// adapter

    private List<CartBean> mListData = new ArrayList<CartBean>();// 数据

    private boolean isBatchModel;// 是否可删除模式

    private RelativeLayout mBottonLayout;
    private CheckBox mCheckAll; // 全选 全不选


    private TextView mEdit; // 切换到删除模式

    private TextView mPriceAll; // 商品总价

    private TextView mSelectNum; // 选中数量

    private TextView mFavorite; // 移到收藏夹

    private TextView mDelete; // 删除 结算

    private int totalPrice = 0; // 商品总价
    /**
     * 批量模式下，用来记录当前选中状态
     */
    private SparseArray<Boolean> mSelectState = new SparseArray<Boolean>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.cart, container, false);
        mBottonLayout = (RelativeLayout) contentView.findViewById(R.id.cart_rl_allprie_total);
        mCheckAll = (CheckBox) contentView.findViewById(R.id.check_box);
        mEdit = (TextView) contentView.findViewById(R.id.subtitle);
        mPriceAll = (TextView) contentView.findViewById(R.id.tv_cart_total);
        mSelectNum = (TextView) contentView.findViewById(R.id.tv_cart_select_num);
        mFavorite = (TextView) contentView.findViewById(R.id.tv_cart_move_favorite);
        mDelete = (TextView) contentView.findViewById(R.id.tv_cart_buy_or_del);
        mListView = (ListView) contentView.findViewById(R.id.listview);
        mListView.setSelector(R.drawable.list_selector);
        initListener();
        loadData();
        return contentView;
    }


    private void doDelete(List<Integer> ids) {
        for (int i = 0; i < mListData.size(); i++) {
            long dataId = mListData.get(i).getId();
            for (int j = 0; j < ids.size(); j++) {
                int deleteId = ids.get(j);
                if (dataId == deleteId) {
                    mListData.remove(i);
                    i--;
                    ids.remove(j);
                    j--;
                }
            }
        }

        refreshListView();
        mSelectState.clear();
        totalPrice = 0;
        mSelectNum.setText("已选" + 0 + "件商品");
        mPriceAll.setText("￥" + 0.00 + "");
        mCheckAll.setChecked(false);

    }

    private final List<Integer> getSelectedIds() {
        ArrayList<Integer> selectedIds = new ArrayList<Integer>();
        for (int index = 0; index < mSelectState.size(); index++) {
            if (mSelectState.valueAt(index)) {
                selectedIds.add(mSelectState.keyAt(index));
            }
        }
        return selectedIds;
    }


    private void initListener() {
        mEdit.setOnClickListener(this);
        mDelete.setOnClickListener(this);
        mCheckAll.setOnClickListener(this);

    }

    private void loadData() {
        new LoadDataTask().execute(new Params(INITIALIZE));
    }

    private void refreshListView() {
        if (mListAdapter == null) {
            mListAdapter = new ListAdapter();
            mListView.setAdapter(mListAdapter);
            mListView.setOnItemClickListener(mListAdapter);

        } else {
            mListAdapter.notifyDataSetChanged();

        }
    }

    private List<CartBean> getData() {
       CartBean c= new CartBean();
        CartBean b= new CartBean();
        CartBean d= new CartBean();
        List<CartBean> result = new ArrayList<CartBean>();
        c.setId(1);
        c.setCarNum(2);
        c.setContent("超级无敌大白菜");
        c.setImg_shop("http://p0.55tuanimg.com/p1/M01/12/00/rBAZIlTwHxWAaaHtAAATScyUY7A173.png");
        c.setImg_thing("http://www.52ij.com/uploads/allimg/160317/0055064531-0.jpg?");
        c.setPrice(301f);
        c.setShopName("梦石头超市");
        result.add(c);

        b.setId(2);
        b.setCarNum(3);
        b.setContent("土豆");
        b.setImg_shop("http://p0.55tuanimg.com/p1/M01/12/00/rBAZIlTwHxWAaaHtAAATScyUY7A173.png");
        b.setImg_thing("http://www.52ij.com/uploads/allimg/160317/0055064531-0.jpg?");
        b.setPrice(30.7f);
        b.setShopName("刘璇超市");
        result.add(b);

        d.setId(3);
        d.setCarNum(2);
        d.setContent("地瓜");
        d.setImg_shop("http://p0.55tuanimg.com/p1/M01/12/00/rBAZIlTwHxWAaaHtAAATScyUY7A173.png");
        d.setImg_thing("http://www.52ij.com/uploads/allimg/160317/0055064531-0.jpg?");
        d.setPrice(2.05f);
        d.setShopName("隔壁老于超市");
        result.add(d);

        return  result;

    }

    class Params {
        int op;

        public Params(int op) {
            this.op = op;
        }

    }

    class Result {
        int op;
        List<CartBean> list;
    }

    private class LoadDataTask extends AsyncTask<Params, Void, Result> {
        @Override
        protected Result doInBackground(Params... params) {
            Params p = params[0];
            Result result = new Result();
            result.op = p.op;
            try {// 模拟耗时
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            result.list = getData();
            return result;
        }

        @Override
        protected void onPostExecute(Result result) {
            super.onPostExecute(result);
            if (result.op == INITIALIZE) {
                mListData = result.list;
            } else {
                mListData.addAll(result.list);
                Toast.makeText(getActivity(), "添加成功！", Toast.LENGTH_SHORT).show();
            }

            refreshListView();
        }

    }

    private class ListAdapter extends BaseAdapter implements AdapterView.OnItemClickListener {

        @Override
        public int getCount() {
            return mListData.size();
        }

        @Override
        public Object getItem(int position) {
            return mListData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            View view = convertView;
            if (view == null) {
                view = LayoutInflater.from(getActivity()).inflate(R.layout.cart_list_item, null);
                holder = new ViewHolder(view);
                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }

            CartBean data = mListData.get(position);
            bindListItem(holder, data);
            holder.add.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub

                    int _id = (int) mListData.get(position).getId();

                    boolean selected = mSelectState.get(_id, false);

                    mListData.get(position).setCarNum(mListData.get(position).getCarNum() + 1);

                    notifyDataSetChanged();

                    if (selected) {
                        totalPrice += mListData.get(position).getPrice();
                        mPriceAll.setText("￥" + totalPrice + "");

                    }

                }
            });

            holder.red.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    // TODO Auto-generated method stub
                    if (mListData.get(position).getCarNum() == 1)
                        return;

                    int _id = (int) mListData.get(position).getId();

                    boolean selected = mSelectState.get(_id, false);
                    mListData.get(position).setCarNum(mListData.get(position).getCarNum() - 1);
                    notifyDataSetChanged();

                    if (selected) {
                        totalPrice -= mListData.get(position).getPrice();
                        mPriceAll.setText("￥" + totalPrice + "");

                    }

                }
            });
            return view;
        }

        private void bindListItem(ViewHolder holder, CartBean data) {

            Glide.with(getActivity()) .load(data.getImg_shop()) .into(holder.img_shop);
            Glide.with(getActivity()) .load(data.getImg_thing()) .into(holder.img_thing);
            holder.shopName.setText(data.getShopName());
            holder.content.setText(data.getContent());
            holder.price.setText("￥" + data.getPrice());
            holder.carNum.setText(data.carNum + "");
            int _id = data.getId();

            boolean selected = mSelectState.get(_id, false);
            holder.checkBox.setChecked(selected);

        }

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            CartBean bean = mListData.get(position);

            ViewHolder holder = (ViewHolder) view.getTag();
            int _id = (int) bean.getId();

            boolean selected = !mSelectState.get(_id, false);
            holder.checkBox.toggle();
            if (selected) {
                mSelectState.put(_id, true);
                totalPrice += bean.getCarNum() * bean.getPrice();
            } else

            {
                mSelectState.delete(_id);
                totalPrice -= bean.getCarNum() * bean.getPrice();
            }
            mSelectNum.setText("已选" + mSelectState.size() + "件商品");
            mPriceAll.setText("￥" + totalPrice + "");
            if (mSelectState.size() == mListData.size()) {
                mCheckAll.setChecked(true);
            } else {
                mCheckAll.setChecked(false);
            }

        }

    }

    class ViewHolder {
        CheckBox checkBox;

        TextView shopName;
        TextView content;
        TextView carNum;
        TextView price;
        TextView add;
        TextView red;
        ImageView img_shop;
        ImageView img_thing;

        public ViewHolder(View view) {
            img_shop = (ImageView) view.findViewById(R.id.img_shop);
            img_thing = (ImageView) view.findViewById(R.id.img_thing);
            checkBox = (CheckBox) view.findViewById(R.id.check_box);
            shopName = (TextView) view.findViewById(R.id.tv_source_name);
            content = (TextView) view.findViewById(R.id.tv_intro);
            carNum = (TextView) view.findViewById(R.id.tv_num);
            price = (TextView) view.findViewById(R.id.tv_price);
            add = (TextView) view.findViewById(R.id.tv_add);
            red = (TextView) view.findViewById(R.id.tv_reduce);

        }
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {

            case R.id.subtitle:
                isBatchModel = !isBatchModel;
                if (isBatchModel) {
                    mEdit.setText(getResources().getString(R.string.menu_enter));
                    mDelete.setText(getResources().getString(R.string.menu_del));
                    mBottonLayout.setVisibility(View.GONE);
                    mFavorite.setVisibility(View.VISIBLE);

                } else {
                    mEdit.setText(getResources().getString(R.string.menu_edit));

                    mFavorite.setVisibility(View.GONE);
                    mBottonLayout.setVisibility(View.VISIBLE);
                    mDelete.setText(getResources().getString(R.string.menu_sett));
                }

                break;

            case R.id.check_box:
                if (mCheckAll.isChecked()) {

                    totalPrice = 0;
                    if (mListData != null) {
                        mSelectState.clear();
                        int size = mListData.size();
                        if (size == 0) {
                            return;
                        }
                        for (int i = 0; i < size; i++) {
                            int _id = (int) mListData.get(i).getId();
                            mSelectState.put(_id, true);
                            totalPrice += mListData.get(i).getCarNum() * mListData.get(i).getPrice();
                        }
                        refreshListView();
                        mPriceAll.setText("￥" + totalPrice + "");
                        mSelectNum.setText("已选" + mSelectState.size() + "件商品");

                    }
                } else {
                    if (mListAdapter != null) {
                        totalPrice = 0;
                        mSelectState.clear();
                        refreshListView();
                        mPriceAll.setText("￥" + 0.00 + "");
                        mSelectNum.setText("已选" + 0 + "件商品");

                    }
                }
                break;

            case R.id.tv_cart_buy_or_del:
                if (isBatchModel) {
                    List<Integer> ids = getSelectedIds();
                    doDelete(ids);
                } else {
                    Toast.makeText(getActivity(), "结算", Toast.LENGTH_SHORT).show();
                }

                break;

            default:
                break;
        }
    }

}


