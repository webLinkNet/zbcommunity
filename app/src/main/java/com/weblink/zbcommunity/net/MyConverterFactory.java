package com.weblink.zbcommunity.net;

import com.google.gson.Gson;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.ResponseBody;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import retrofit.Converter;

/**
 * Created by swq on 2016/7/22.
 */
public class MyConverterFactory extends Converter.Factory {

    /**
     * Create an instance using a default {@link Gson} instance for conversion. Encoding to JSON and
     * decoding from JSON (when no charset is specified by a header) will use UTF-8.
     */
    public static MyConverterFactory create() {
        return create(new Gson());
    }

    /**
     * Create an instance using {@code gson} for conversion. Encoding to JSON and
     * decoding from JSON (when no charset is specified by a header) will use UTF-8.
     */
    public static MyConverterFactory create(Gson gson) {
        return new MyConverterFactory(gson);
    }

    private final Gson gson;

    private MyConverterFactory(Gson gson) {
        if (gson == null) throw new NullPointerException("gson == null");
        this.gson = gson;
    }

    @Override
    public Converter<ResponseBody, ?> fromResponseBody(Type type, Annotation[] annotations) {
        return new MyGsonResponseBodyConverter<>(gson, type);
    }

    @Override public Converter<?, RequestBody> toRequestBody(Type type, Annotation[] annotations) {
        return new MyGsonResponseBodyConverter<>(gson, type);
    }
}
