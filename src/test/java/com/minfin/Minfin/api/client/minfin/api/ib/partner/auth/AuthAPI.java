package com.minfin.Minfin.api.client.minfin.api.ib.partner.auth;

import com.minfin.Minfin.api.model.minfin.api.ib.partner.auth.response.AuthResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface AuthAPI {

    @FormUrlEncoded
    @Headers({"Content-Type: application/x-www-form-urlencoded",
            "Cookie: minfin_sessions=a77f3459ab2b5ac9e2369f8ef78d3d17fbda754a",
            "Accept: application/x-www-form-urlencoded"})
    @POST("/api/ib/partner/auth/")
    Call<AuthResponse> postAuth(@Field(value = "Login") String login, @Field(value = "Password") String password);
}
