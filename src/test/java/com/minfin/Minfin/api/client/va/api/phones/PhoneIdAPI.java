package com.minfin.Minfin.api.client.va.api.phones;

import com.minfin.Minfin.api.model.va.api.phones.phoneId.PhoneIdResponse;
import retrofit2.Call;
import retrofit2.http.*;

public interface PhoneIdAPI {
    @GET("api/phones")
    Call<PhoneIdResponse> getPhoneId(@Query("where") String profileId);
}
