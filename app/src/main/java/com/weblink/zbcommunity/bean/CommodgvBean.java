package com.weblink.zbcommunity.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/11/15.
 */
public class CommodgvBean implements Serializable {
    private String kinurl;
    private String kintext;


    public String getKintext() {
        return kintext;
    }

    public void setKintext(String kintext) {
        this.kintext = kintext;
    }

    public String getKinurl() {
        return kinurl;
    }

    public void setKinurl(String kinurl) {
        this.kinurl = kinurl;
    }
}
