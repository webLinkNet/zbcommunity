package com.weblink.zbcommunity.bean;

import java.io.Serializable;

public class MinedingdanBean implements Serializable {
    private String storename;
    private String imgurlone;
    private String imgurltwo;
    private String imgurlthree;
    private String thingnum;
    private String moneynum;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStorename() {
        return storename;
    }

    public void setStorename(String storename) {
        this.storename = storename;
    }

    public String getImgurlone() {
        return imgurlone;
    }

    public void setImgurlone(String imgurlone) {
        this.imgurlone = imgurlone;
    }

    public String getImgurltwo() {
        return imgurltwo;
    }

    public void setImgurltwo(String imgurltwo) {
        this.imgurltwo = imgurltwo;
    }

    public String getImgurlthree() {
        return imgurlthree;
    }

    public void setImgurlthree(String imgurlthree) {
        this.imgurlthree = imgurlthree;
    }

    public String getThingnum() {
        return thingnum;
    }

    public void setThingnum(String thingnum) {
        this.thingnum = thingnum;
    }

    public String getMoneynum() {
        return moneynum;
    }

    public void setMoneynum(String moneynum) {
        this.moneynum = moneynum;
    }


}
