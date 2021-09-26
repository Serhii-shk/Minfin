package com.minfin.Minfin.api.services.minfin.api.user.register;

import com.minfin.Minfin.api.client.minfin.api.user.register.RegisterAPI;
import com.minfin.Minfin.api.model.minfin.api.user.register.RegisterRequest;
import com.minfin.Minfin.api.model.minfin.api.user.register.RegisterResponse;
import com.minfin.Minfin.api.services.minfin.BaseMinfinService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import retrofit2.Call;
import retrofit2.Response;

@Slf4j
public class RegisterService extends BaseMinfinService {

    @SneakyThrows
    public Response<RegisterResponse> postRegister(RegisterRequest registerRequest) {
        RegisterAPI service = retrofit.create(RegisterAPI.class);
        Call<RegisterResponse> call = service.postRegister(registerRequest.getEmail(),
                registerRequest.getLogin(),
                registerRequest.getPassword(),
                registerRequest.isPrivacy(),
                registerRequest.isRules(),
                registerRequest.getCheck(),
                registerRequest.getFirstName(),
                registerRequest.getPhone());
        return call.execute();
    }
}
