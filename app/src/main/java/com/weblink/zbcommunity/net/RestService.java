package com.weblink.zbcommunity.net;


import com.weblink.zbcommunity.bean.okhttpbean.ResultBean;
import com.weblink.zbcommunity.bean.requestbean.LoanInitBean;
import com.weblink.zbcommunity.bean.requestbean.LoginBean;
import com.weblink.zbcommunity.bean.requestbean.TestBean;

import java.util.Map;

import retrofit.Call;
import retrofit.http.FieldMap;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.QueryMap;

/**
 * Created by swq on 2016/11/3.
 */
public interface RestService {


    /**
     * 测试
     * @param params
     * @return
     */
    @GET(ZBCommunityUris.TEST)
    Call<ResultBean<TestBean>> test(@QueryMap Map<String, Object> params);


    /**
     * 测试
     * @param params
     * @return
     */
    @GET(ZBCommunityUris.TESTJUHE)
    Call<TestBean> testJuHe(@QueryMap Map<String, Object> params);
    /**
     * 检查商户状态
     */
    @GET(ZBCommunityUris.LOAN_INIT)
    Call<ResultBean<LoanInitBean>> checkStatus(@QueryMap Map<String, Object> params);



    //---------------------------------------------------------------------     测试    ------------------------------------------------------------------------------------------------
    //登录
    @FormUrlEncoded
    @POST(ZBCommunityUris.LOGIN)
    Call<ResultBean<LoginBean>> login(@FieldMap Map<String, Object> params);

    //用户资料初始化
    @GET(ZBCommunityUris.LOGIN)
    Call<ResultBean<LoginBean>> userInfoInit(@QueryMap Map<String, Object> params);
}
