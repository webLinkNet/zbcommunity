package com.weblink.zbcommunity.widget;

/**
 * Created by swq on 2016/11/18.
 */
public class LocationEvent {


    private String city;

    private String title;

    public LocationEvent(String city, String title) {

        this.city = city;
        this.title = title;
    }

    public String getCity() {
        return city;
    }

    public String getTitle() {
        return title;
    }


}
