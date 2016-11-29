package com.weblink.zbcommunity.net;

/**
 * Created by swq on 2016/11/3.
 */
public class ZBCommunityUris {

    public static String BASE_HOST = "http://app.fangzongguan.com/";//正式环境（线上）


    //    http://112.124.22.238:8081/course_api/banner/query?type=1
//    public static String BASE_HOST = "http://112.124.22.238:8081/";//正式环境（线上）
//    public static String BASE_HOST = "http://v.juhe.cn/";//正式环境（线上）
//    http://apis.juhe.cn/idcard/index?key=您申请的KEY&cardno=330326198903081211

    public static final String TEST = "course_api/banner/query";
    public static final String TESTJUHE = "idcard/index";
    public static final String LOGIN = "fangmaster/v3/tenant/user/login";//登录接口
    public static final String LOAN_INIT = "fangmaster/fdv1/loan/init"; //检查贷款状态（贷款查看）

}
