package com.weblink.zbcommunity.bean;

import java.io.Serializable;

/**
 * Created by jz on 2016/11/11.
 */
public class MineyouhuiBean implements Serializable {
    private String jiage;
    private String leixing;
    private String guize;
    private String last;
    private int id;

    public String getJiage() {
        return jiage;
    }

    public void setJiage(String jiage) {
        this.jiage = jiage;
    }

    public String getLeixing() {
        return leixing;
    }

    public void setLeixing(String leixing) {
        this.leixing = leixing;
    }

    public String getGuize() {
        return guize;
    }

    public void setGuize(String guize) {
        this.guize = guize;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
