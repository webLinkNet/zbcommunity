package com.weblink.zbcommunity.bean;

/**
 * Created by swq on 2016/11/11.
 */
public class LocationBean {

    private static LocationBean instance = null;


    private LocationBean(){}

    public static LocationBean getInstance(){


        if(instance == null){


            instance = new LocationBean();
        }

        return instance;
    }



}
