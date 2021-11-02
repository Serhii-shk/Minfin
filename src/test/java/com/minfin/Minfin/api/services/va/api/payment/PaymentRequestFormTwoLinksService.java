package com.minfin.Minfin.api.services.va.api.payment;

import com.minfin.Minfin.api.client.va.api.payment.PaymentRequestFormAPI;
import com.minfin.Minfin.api.client.va.api.payment.PaymentRequestFormTwoLinksAPI;
import com.minfin.Minfin.api.model.va.api.payment.PaymentRequestFormResponse;
import com.minfin.Minfin.api.model.va.api.payment.body.PaymentBody;
import com.minfin.Minfin.api.model.va.api.payment.paymentRequestFormTwoLinks.body.PaymentRequestFormTwoLinksBody;
import com.minfin.Minfin.api.model.va.api.payment.paymentRequestFormTwoLinks.response.PaymentRequestFormTwoLinksResponse;
import com.minfin.Minfin.api.services.va.BaseVAService;
import lombok.SneakyThrows;
import retrofit2.Call;
import retrofit2.Response;

public class PaymentRequestFormTwoLinksService extends BaseVAService {
    @SneakyThrows
    public Response<PaymentRequestFormTwoLinksResponse> postPaymentRequestFormTwoLinks(String paymentId, PaymentRequestFormTwoLinksBody body) {
        PaymentRequestFormTwoLinksAPI service = getRetrofit().create(PaymentRequestFormTwoLinksAPI.class);
        Call<PaymentRequestFormTwoLinksResponse> call = service.postPaymentRequestFormTwoLinks(paymentId, body);
        return call.execute();
    }
}
