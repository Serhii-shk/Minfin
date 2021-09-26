package com.minfin.Minfin.api.client.va.api.auth.userInfo;

import com.minfin.Minfin.api.model.va.api.auth.userInfo.UserInfoResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

public interface UserInfoAPI {

    @Headers({"Content-Type: application/json"})
    @GET("api/auth/user_info/")
    Call<UserInfoResponse> getUserInfo(@Header(value = "Authorization") String bearerToken);
}
