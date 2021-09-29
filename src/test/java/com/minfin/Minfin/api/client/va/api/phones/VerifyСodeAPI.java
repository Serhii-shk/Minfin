package com.minfin.Minfin.api.client.va.api.phones;
import com.minfin.Minfin.api.model.va.api.phones.VerifyCodeRequest;
import com.minfin.Minfin.api.model.va.api.phones.VerifyCodeResponse;
import retrofit2.Call;
import retrofit2.http.*;

public interface VerifyСodeAPI {


    @Headers({"Content-Type: application/json"})
    @POST("api/phones/{phoneNumber}/verify/")
    Call<VerifyCodeResponse> postVerifyCode(@Path("phoneNumber") String phoneNumber,
                                            @Header(value = "Authorization") String bearerToken,
                                            @Body VerifyCodeRequest body);
}
