package com.minfin.Minfin.api.client.minfin.api.user.register;

import com.minfin.Minfin.api.model.minfin.api.user.register.RegisterResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface RegisterAPI {

    @FormUrlEncoded
    @Headers("Cookie:minfin_sessions=a7497b06881fa70bc5bc7ed6ca0c6387a1c6b781")
    @POST("api/user/register/")
    Call<RegisterResponse> postRegister(@Field(value = "Email") String email,
                                        @Field(value = "Login") String login,
                                        @Field(value = "Password") String password,
                                        @Field(value = "Privacy") boolean privacy,
                                        @Field(value = "Rules") boolean rules,
                                        @Field(value = "check") int check,
                                        @Field(value = "first_name") String firstName,
                                        @Field(value = "phone") String phone);
}
