package com.minfin.Minfin.api.services.va.api.auth.usesrInfo;

import com.minfin.Minfin.api.client.va.api.auth.userInfo.UserInfoAPI;
import com.minfin.Minfin.api.model.va.api.auth.userInfo.UserInfoResponse;
import com.minfin.Minfin.api.services.va.BaseVAService;
import lombok.SneakyThrows;
import retrofit2.Call;
import retrofit2.Response;

public class UserInfoService extends BaseVAService {

    @SneakyThrows
    public Response<UserInfoResponse> getUserInfo(String bearerToken) {
        UserInfoAPI service = retrofit.create(UserInfoAPI.class);
        Call<UserInfoResponse> call = service.getUserInfo("Bearer " + bearerToken);
        return call.execute();
    }
}
