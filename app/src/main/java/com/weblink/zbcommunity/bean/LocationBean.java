package com.weblink.zbcommunity.bean;

import com.baidu.location.BDLocation;

/**
 * Created by swq on 2016/11/11.
 */
public class LocationBean {

    private static LocationBean instance = null;

    private BDLocation location;

    private LocationBean(){}

    public static LocationBean getInstance(){


        if(instance == null){


            instance = new LocationBean();
        }

        return instance;
    }



    private BDLocation getLocation() {
        return location;
    }

    public void setLocation(BDLocation location) {
        this.location = location;
    }
}
