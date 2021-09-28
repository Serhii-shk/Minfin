package com.minfin.Minfin.api.client.va.api.phones;

import com.minfin.Minfin.api.model.va.api.phones.PhonesResponse;
import retrofit2.Call;
import retrofit2.http.*;

public interface PhonesAPI {

    @Headers({"Content-Type: text/plain"})
    @POST("api/phones/{phoneNumber}")
    Call<PhonesResponse> postPhones(@Path("phoneNumber") String phoneNumber,
                                    @Header(value = "Authorization") String bearerToken);


}
