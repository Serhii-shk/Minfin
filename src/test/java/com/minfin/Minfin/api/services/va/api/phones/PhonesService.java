package com.minfin.Minfin.api.services.va.api.phones;

import com.minfin.Minfin.api.client.va.api.phones.PhonesAPI;
import com.minfin.Minfin.api.model.va.api.phones.PhonesResponse;
import com.minfin.Minfin.api.services.va.BaseVAService;
import lombok.SneakyThrows;
import retrofit2.Call;
import retrofit2.Response;

public class PhonesService extends BaseVAService {
    @SneakyThrows
    public Response<PhonesResponse> postPhones(String phoneNumber, String bearerToken) {
        PhonesAPI service = getRetrofit().create(PhonesAPI.class);
        Call<PhonesResponse> call = service.postPhones(phoneNumber,"Bearer " + bearerToken);
        return call.execute();
    }
}
