package com.minfin.Minfin.api.services.va.api.phones;

import com.google.gson.Gson;
import com.minfin.Minfin.api.client.va.api.phones.PhoneIdAPI;
import com.minfin.Minfin.api.model.va.api.phones.phoneId.PhoneIdBody;
import com.minfin.Minfin.api.model.va.api.phones.phoneId.PhoneIdResponse;
import com.minfin.Minfin.api.services.va.BaseVAService;
import lombok.SneakyThrows;
import retrofit2.Call;
import retrofit2.Response;

public class PhoneIdService extends BaseVAService {
    @SneakyThrows
    public Response<PhoneIdResponse> getPhonesId(PhoneIdBody profileId) {
        PhoneIdAPI service = getRetrofit().create(PhoneIdAPI.class);
        Call<PhoneIdResponse> call = service.getPhoneId(new Gson().toJson(profileId));
        return call.execute();
    }
}
