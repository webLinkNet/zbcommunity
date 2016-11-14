package com.weblink.zbcommunity.bean.requestbean;

import java.io.Serializable;

/**
 * Created by swq on 2016/11/7.
 */
public class TestBean implements Serializable {


    /**
     * resultcode : 200
     * reason : 成功的返回
     * result : {"area":"浙江省温州市平阳县","sex":"男","birthday":"1989年03月08日"}
     */

    private String resultcode;
    private String reason;
    /**
     * area : 浙江省温州市平阳县
     * sex : 男
     * birthday : 1989年03月08日
     */

    private ResultBean result;

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        private String area;
        private String sex;
        private String birthday;

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }
    }
}
