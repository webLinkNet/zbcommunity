package com.weblink.zbcommunity.bean;

import com.amap.api.location.AMapLocation;

/**
 * Created by swq on 2016/11/11...
 */
public class LocationBean {

    private static LocationBean instance = null;

    private AMapLocation amapLocation;

    private LocationBean() {
    }

    public static LocationBean getInstance() {


        if (instance == null) {


            instance = new LocationBean();
        }


        return instance;
    }


    public AMapLocation getAmapLocation() {
        return amapLocation;
    }

    public void setAmapLocation(AMapLocation amapLocation) {
        this.amapLocation = amapLocation;
    }


}
