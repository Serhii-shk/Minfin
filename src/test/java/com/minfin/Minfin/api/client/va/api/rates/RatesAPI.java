package com.minfin.Minfin.api.client.va.api.rates;


import com.minfin.Minfin.api.model.va.api.rates.body.RatesBody;
import com.minfin.Minfin.api.model.va.api.rates.response.RatesResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface RatesAPI {
    @Headers({"Content-Type: application/json"})
    @POST("api/admin/branches/rates/")
    Call<RatesResponse> postRates(@Header(value = "Authorization") String adminBearerToken,
                                  @Body RatesBody body);
}
