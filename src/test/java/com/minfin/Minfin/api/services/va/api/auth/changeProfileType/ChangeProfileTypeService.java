package com.minfin.Minfin.api.services.va.api.auth.changeProfileType;

import com.minfin.Minfin.api.client.va.api.auth.changeProfileType.ChangeProfileTypeAPI;
import com.minfin.Minfin.api.model.va.api.auth.changeProfileType.ChangeProfileTypeRequest;
import com.minfin.Minfin.api.model.va.api.auth.changeProfileType.ChangeProfileTypeResponse;
import com.minfin.Minfin.api.services.va.BaseVAService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

@Slf4j
public class ChangeProfileTypeService extends BaseVAService {

    @SneakyThrows
    public Response<ChangeProfileTypeResponse> postChangeProfileType(String bearerToken, ChangeProfileTypeRequest profileType) {
        ChangeProfileTypeAPI service = getRetrofit().create(ChangeProfileTypeAPI.class);
        Call<ChangeProfileTypeResponse> call = service.postChangeProfileType("Bearer " + bearerToken, profileType);
        return call.execute();
    }
}
