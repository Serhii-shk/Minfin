package com.minfin.Minfin.api.services.va;

import com.google.gson.Gson;
import com.minfin.Minfin.api.LogJsonInterceptor;
import com.minfin.Minfin.ui.test.TestBase;
import lombok.extern.slf4j.Slf4j;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
public abstract class BaseVAService {

    public Retrofit getRetrofit() {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(Duration.ofSeconds(30))
                .readTimeout(Duration.ofSeconds(30))
                .writeTimeout(Duration.ofSeconds(30))
                .connectionPool(new ConnectionPool(0, 5, TimeUnit.MINUTES))
                .protocols(List.of(Protocol.HTTP_1_1, Protocol.HTTP_2))
                .addInterceptor(new LogJsonInterceptor())
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(String.format("https://va-backend-%s.treeum.net/", TestBase.getEnv()))
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
        return retrofit;
    }

}
