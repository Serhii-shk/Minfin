package com.minfin.Minfin.api.services.va;

import com.google.gson.Gson;
import com.minfin.Minfin.api.LogJsonInterceptor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Slf4j
public abstract class BaseVAService {

    protected Retrofit retrofit;

    public BaseVAService() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new LogJsonInterceptor())
                .build();
        this.retrofit = new Retrofit.Builder()
                .baseUrl("https://va-backend-stage.treeum.net/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
    }
}
