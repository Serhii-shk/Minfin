package com.minfin.Minfin.api.services.va.api.payment;

import com.minfin.Minfin.api.client.va.api.admin.profile.ProfileAPI;
import com.minfin.Minfin.api.client.va.api.payment.PaymentAPI;
import com.minfin.Minfin.api.model.va.api.admin.profile.ProfileResponse;
import com.minfin.Minfin.api.model.va.api.payment.body.PaymentBody;
import com.minfin.Minfin.api.model.va.api.payment.response.PaymentResponse;
import com.minfin.Minfin.api.services.va.BaseVAService;
import lombok.SneakyThrows;
import retrofit2.Call;
import retrofit2.Response;

public class PaymentService extends BaseVAService {
    @SneakyThrows
    public Response<PaymentResponse> postPayment(String id, String adminBearerToken, PaymentBody body) {
        PaymentAPI service = getRetrofit().create(PaymentAPI.class);
        Call<PaymentResponse> call = service.postPayment(id,"Bearer " + adminBearerToken, body);
        return call.execute();
    }
}
