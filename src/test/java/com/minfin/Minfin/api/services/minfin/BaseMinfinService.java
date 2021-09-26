package com.minfin.Minfin.api.services.minfin;

import com.google.gson.Gson;
import com.minfin.Minfin.api.LogJsonInterceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class BaseMinfinService {

    protected Retrofit retrofit;

    public BaseMinfinService() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new LogJsonInterceptor())
                .build();
        this.retrofit = new Retrofit.Builder()
                .baseUrl("https://minfin.com.ua/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
    }
}
