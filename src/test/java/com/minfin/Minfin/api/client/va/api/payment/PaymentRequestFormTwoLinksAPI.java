package com.minfin.Minfin.api.client.va.api.payment;

import com.minfin.Minfin.api.model.va.api.payment.PaymentRequestFormResponse;
import com.minfin.Minfin.api.model.va.api.payment.body.PaymentBody;
import com.minfin.Minfin.api.model.va.api.payment.paymentRequestFormTwoLinks.body.PaymentRequestFormTwoLinksBody;
import com.minfin.Minfin.api.model.va.api.payment.paymentRequestFormTwoLinks.response.PaymentRequestFormTwoLinksResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PaymentRequestFormTwoLinksAPI {
    @POST("api/payments/{paymentId}/pay-link")
    Call<PaymentRequestFormTwoLinksResponse> postPaymentRequestFormTwoLinks(@Path("paymentId") String paymentId,
                                                                            @Body PaymentRequestFormTwoLinksBody body);
}
