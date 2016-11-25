package com.weblink.zbcommunity.bean.requestbean;

import com.weblink.zbcommunity.bean.ChildBean;

import java.util.List;

/**
 * Created by Administrator on 2016/11/24.
 */
public class CommKindThingBean {

    private String fatherimg;
    private String fathername;
    private List<ChildBean> childlist;

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public String getFatherimg() {
        return fatherimg;
    }

    public void setFatherimg(String fatherimg) {
        this.fatherimg = fatherimg;
    }

    public List<ChildBean> getChildlist() {
        return childlist;
    }

    public void setChildlist(List<ChildBean> childlist) {
        this.childlist = childlist;
    }


}
