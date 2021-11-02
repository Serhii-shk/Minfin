package com.minfin.Minfin.api.services.va.api.payment;

import com.minfin.Minfin.api.client.va.api.payment.PaymentRequestFormAPI;
import com.minfin.Minfin.api.model.va.api.payment.PaymentRequestFormResponse;
import com.minfin.Minfin.api.services.va.BaseVAService;
import lombok.SneakyThrows;
import retrofit2.Call;
import retrofit2.Response;

public class PaymentRequestFormService extends BaseVAService {
    @SneakyThrows
    public Response<PaymentRequestFormResponse> postPaymentRequestForm(String paymentId) {
        PaymentRequestFormAPI service = getRetrofit().create(PaymentRequestFormAPI.class);
        Call<PaymentRequestFormResponse> call = service.postPaymentRequestForm(paymentId);
        return call.execute();
    }
}
