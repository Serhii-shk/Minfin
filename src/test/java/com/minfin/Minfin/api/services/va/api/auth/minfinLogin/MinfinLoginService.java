package com.minfin.Minfin.api.services.va.api.auth.minfinLogin;

import com.minfin.Minfin.api.client.va.api.auth.minfinLogin.MinfinLoginAPI;
import com.minfin.Minfin.api.model.va.api.auth.minfinLogin.MinfinLoginRequest;
import com.minfin.Minfin.api.model.va.api.auth.minfinLogin.MinfinLoginResponse;
import com.minfin.Minfin.api.services.va.BaseVAService;
import lombok.SneakyThrows;
import retrofit2.Call;
import retrofit2.Response;

public class MinfinLoginService extends BaseVAService {

    @SneakyThrows
    public Response<MinfinLoginResponse> postMinfinLogin(MinfinLoginRequest body) {
        MinfinLoginAPI service = retrofit.create(MinfinLoginAPI.class);
        Call<MinfinLoginResponse> call = service.postMinfinLogin(body);
        return call.execute();
    }
}
