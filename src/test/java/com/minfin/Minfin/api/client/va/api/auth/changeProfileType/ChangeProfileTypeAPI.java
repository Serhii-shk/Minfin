package com.minfin.Minfin.api.client.va.api.auth.changeProfileType;

import com.minfin.Minfin.api.model.va.api.auth.changeProfileType.ChangeProfileTypeRequest;
import com.minfin.Minfin.api.model.va.api.auth.changeProfileType.ChangeProfileTypeResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ChangeProfileTypeAPI {

    @Headers({"Cookie:minfin_sessions=a7497b06881fa70bc5bc7ed6ca0c6387a1c6b781",
            "Content-Type: application/json"})
    @POST("api/auth/profile/change-type/")    //change_profile_type/
    Call<ChangeProfileTypeResponse> postChangeProfileType(@Header(value = "Authorization") String bearerToken,
                                                          @Body ChangeProfileTypeRequest type);
}
