package com.minfin.Minfin.api.client.va.api.payment;

import com.minfin.Minfin.api.model.va.api.payment.body.PaymentBody;
import com.minfin.Minfin.api.model.va.api.payment.response.PaymentResponse;
import retrofit2.Call;
import retrofit2.http.*;

public interface PaymentAPI {
    @Headers({"Content-Type: application/json"})
    @POST("api/admin/profile/{profileId}/subscription")
    Call<PaymentResponse> postPayment(@Path("profileId") String profileId,
                                      @Header(value = "Authorization") String bearerToken,
                                      @Body PaymentBody body);
}
