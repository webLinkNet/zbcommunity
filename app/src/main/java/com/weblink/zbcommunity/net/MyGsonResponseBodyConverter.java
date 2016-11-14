package com.weblink.zbcommunity.net;

import android.util.Log;

import com.google.gson.Gson;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;

import retrofit.Converter;

/**
 * Created by swq on 2016/7/22.
 */
public class MyGsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    private final Gson gson;
    private final Type type;

    MyGsonResponseBodyConverter(Gson gson, Type type) {
        this.gson = gson;
        this.type = type;
    }


    @Override
    public T convert(ResponseBody value) throws IOException {
        Reader reader = value.charStream();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        char [] charbuffer = new char[16];
        while ((i = reader.read(charbuffer)) > 0){
            sb.append(charbuffer,0,i);
        }
        try {
            Log.i("json",sb.toString());
            return gson.fromJson(sb.toString(), type);
        } finally {
            reader.close();
        }

    }
}
