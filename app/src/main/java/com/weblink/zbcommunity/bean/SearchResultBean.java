package com.weblink.zbcommunity.bean;

import java.util.List;

/**
 * Created by swq on 2016/11/21.
 */
public class SearchResultBean {


    private String imgUrl;
    private String shopName;


    private List<SearchResultBean> list;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public List<SearchResultBean> getList() {
        return list;
    }

    public void setList(List<SearchResultBean> list) {
        this.list = list;
    }
}
