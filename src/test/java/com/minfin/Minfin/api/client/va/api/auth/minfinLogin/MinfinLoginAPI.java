package com.minfin.Minfin.api.client.va.api.auth.minfinLogin;

import com.minfin.Minfin.api.model.va.api.auth.minfinLogin.MinfinLoginRequest;
import com.minfin.Minfin.api.model.va.api.auth.minfinLogin.MinfinLoginResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface MinfinLoginAPI {

    @Headers({"Content-Type: application/json"})
    @POST("api/auth/minfin_login/")
    Call<MinfinLoginResponse> postMinfinLogin(@Body MinfinLoginRequest body);
}
