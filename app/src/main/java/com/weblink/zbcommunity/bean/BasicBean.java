package com.weblink.zbcommunity.bean;

/**
 * Created by swq on 2016/11/28.
 */
public class BasicBean {


    private String imageUrl;
    private String name;


    public BasicBean(String imageUrl, String name) {

        this.imageUrl = imageUrl;
        this.name = name;

    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
