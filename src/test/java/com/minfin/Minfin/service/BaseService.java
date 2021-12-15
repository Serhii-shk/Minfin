package com.minfin.Minfin.service;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseService {

    protected Retrofit retrofit;

    public BaseService() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new LogJsonInterceptor())
                .build();
        this.retrofit = new Retrofit.Builder()
                .baseUrl("https://cms-stage.finance.ua/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
    }
}
