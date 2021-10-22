package com.minfin.Minfin.api.services.va.api.rates;

import com.minfin.Minfin.api.client.va.api.rates.RatesAPI;
import com.minfin.Minfin.api.model.va.api.rates.body.RatesBody;
import com.minfin.Minfin.api.model.va.api.rates.response.RatesResponse;
import com.minfin.Minfin.api.services.va.BaseVAService;
import lombok.SneakyThrows;
import retrofit2.Call;
import retrofit2.Response;

public class RatesService extends BaseVAService {
    @SneakyThrows
    public Response<RatesResponse> postRates(String adminBearerToken, RatesBody body) {
        RatesAPI service = getRetrofit().create(RatesAPI.class);
        Call<RatesResponse> call = service.postRates("Bearer " + adminBearerToken, body);
        return call.execute();
    }
}
