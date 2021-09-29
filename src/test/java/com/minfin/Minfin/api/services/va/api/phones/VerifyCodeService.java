package com.minfin.Minfin.api.services.va.api.phones;

import com.minfin.Minfin.api.client.va.api.phones.VerifyСodeAPI;
import com.minfin.Minfin.api.model.va.api.admin.profile.ProfileResponse;
import com.minfin.Minfin.api.model.va.api.phones.VerifyCodeRequest;
import com.minfin.Minfin.api.model.va.api.phones.VerifyCodeResponse;
import com.minfin.Minfin.api.services.va.BaseVAService;
import lombok.SneakyThrows;
import retrofit2.Call;
import retrofit2.Response;

public class VerifyCodeService extends BaseVAService {
    @SneakyThrows
    public Response<VerifyCodeResponse> postVerifyCode(String phoneNumber, String bearerToken, VerifyCodeRequest body) {
        VerifyСodeAPI service =  retrofit.create(VerifyСodeAPI.class);
        Call<VerifyCodeResponse> call = service.postVerifyCode(phoneNumber, "Bearer " + bearerToken, body);
        return call.execute();
    }
}
