package com.minfin.Minfin.api.client.va.api.payment;

import com.minfin.Minfin.api.model.va.api.payment.PaymentRequestFormResponse;
import retrofit2.Call;
import retrofit2.http.*;

public interface PaymentRequestFormAPI {
    @POST("api/payments/{paymentId}/pay-link")
    Call<PaymentRequestFormResponse> postPaymentRequestForm(@Path("paymentId") String paymentId);

}
