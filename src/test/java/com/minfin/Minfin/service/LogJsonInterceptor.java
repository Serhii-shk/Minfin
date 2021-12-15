package com.minfin.Minfin.service;

import lombok.extern.slf4j.Slf4j;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;
import java.util.Objects;

@Slf4j
public class LogJsonInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);
        String rawJson = Objects.requireNonNull(response.body()).string();
        long tx = response.sentRequestAtMillis();
        long rx = response.receivedResponseAtMillis();

        if (response.isSuccessful()) {
            log.info(String.format("%s code %s ms ", response.code(), (rx - tx)));
        } else {
            log.warn(String.format("%s code %s ms response: %s", response.code(), (rx - tx), rawJson));
        }

        // Re-create the response before returning it because body can be read only once
        return response.newBuilder()
                .addHeader("Content-Type", "application/json; charset=utf-8")
                .body(ResponseBody.create(response.body().contentType(), rawJson)).build();
    }
}
