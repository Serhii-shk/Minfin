package com.minfin.Minfin.api.services.minfin.api.ib.partner.auth;

import com.minfin.Minfin.api.client.minfin.api.ib.partner.auth.AuthAPI;
import com.minfin.Minfin.api.model.minfin.api.ib.partner.auth.response.AuthResponse;
import com.minfin.Minfin.api.services.minfin.BaseMinfinService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import retrofit2.Call;
import retrofit2.Response;

@Slf4j
public class AuthService extends BaseMinfinService {

    @SneakyThrows
    public Response<AuthResponse> postAuth(String login, String password) {
        AuthAPI service = retrofit.create(AuthAPI.class);
        Call<AuthResponse> call = service.postAuth(login, password);
        return call.execute();
    }
}
