package com.weblink.zbcommunity.widget;

import com.baidu.location.BDLocation;

/**
 * Created by swq on 2016/11/11.
 */
public class LocationUtils {


    private static LocationUtils instance = null;


    private BDLocation location;

    private LocationUtils(BDLocation location) {

        this.location = location;
    }


    public static LocationUtils getInstance(BDLocation location) {

        if (instance == null) {

            synchronized (LocationUtils.class) {

                if (instance == null) {

                    instance = new LocationUtils(location);
                }
            }

        }

        return instance;
    }


}
