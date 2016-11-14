package com.weblink.zbcommunity.net;

import android.util.Log;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

import retrofit.Retrofit;

/**
 * Created by swq on 2016/11/3.
 */
public class RestClient  {

    private static RestService restService;


    public static RestService getClient() {
        if (restService == null) {
            //--在这里再添加对于各种网络请求的过滤
            OkHttpClient okHttpClient = new OkHttpClient();
            okHttpClient.interceptors().add(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
//                    Response response = chain.proceed(chain.request());
//                      Log.d("RestClient", response.toString());

                    Request request = chain.request();
                    Log.i("class",request.getClass().getName());
                    long t1 = System.nanoTime();
                    Log.d("RestClient", String.format("Sending request %s on %s%n%s",
                            request.url(), chain.connection(), request.headers()));

                    Response response = chain.proceed(request);
//                    Log.i("info",new String(response.body().bytes(),"UTF-8"));
//                    RequestBody.create(MediaType.parse("application/json"; Charset=utf),"json");

                    long t2 = System.nanoTime();
                    Log.i("RestClient", String.format("Received response for %s in %.1fms%n%s",
                            response.request().url(), (t2 - t1) / 1e6d, response.headers()));

                    return response;
                }
            });


            Retrofit client = new Retrofit.Builder()
                    .baseUrl(ZBCommunityUris.BASE_HOST)
                    .client(okHttpClient)
//                    .addConverterFactory(GsonConverterFactory.create())
//                     .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(MyConverterFactory.create())
                    .build();

            restService = client.create(RestService.class);
//                         .addCallAdapterFactory(RxJavaCallAdapterFactory.create())

        }

        return restService;
    }

}
