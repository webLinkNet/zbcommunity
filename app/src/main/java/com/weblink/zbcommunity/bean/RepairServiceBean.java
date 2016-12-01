package com.weblink.zbcommunity.bean;

/**
 * Created by swq on 2016/12/1.
 */
public class RepairServiceBean {

    public RepairServiceBean(String img, String name, double price) {
        this.img = img;
        this.name = name;
        this.price = price;

    }

    private String img;
    private String name;
    private double price;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
