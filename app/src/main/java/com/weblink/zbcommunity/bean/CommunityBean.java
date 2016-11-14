package com.weblink.zbcommunity.bean;

import java.util.List;

/**
 * Created by swq on 2016/11/3.
 * <p/>
 * 首页商品bean
 */
public class CommunityBean {


    private String imgUrl;
    private String name;
    private String  salesNum;
    private String fullDetail;
    private String coupon;
    private String notification;
    private List<DetailInfoBean> detailInfoBeanList;



    public List<CommunityBean.DetailInfoBean> getDetailInfoBeanList() {
        return detailInfoBeanList;
    }

    public void setDetailInfoBeanList(List<CommunityBean.DetailInfoBean> mList) {
        this.detailInfoBeanList = mList;
    }



    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getSalesNum() {
        return salesNum;
    }

    public void setSalesNum(String salesNum) {
        this.salesNum = salesNum;
    }

    public String getFullDetail() {
        return fullDetail;
    }

    public void setFullDetail(String fullDetail) {
        this.fullDetail = fullDetail;
    }

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static class DetailInfoBean{


        private String price;
        private String imgSingle;


        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getImgSingle() {
            return imgSingle;
        }

        public void setImgSingle(String imgSingle) {
            this.imgSingle = imgSingle;
        }
    }
}
