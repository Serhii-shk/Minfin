package com.minfin.Minfin.api.services.va.api.admin.profile;

import com.minfin.Minfin.api.client.va.api.admin.profile.ProfileAPI;
import com.minfin.Minfin.api.model.va.api.admin.profile.ProfileRequest;
import com.minfin.Minfin.api.model.va.api.admin.profile.ProfileResponse;
import com.minfin.Minfin.api.services.va.BaseVAService;
import lombok.SneakyThrows;
import retrofit2.Call;
import retrofit2.Response;

public class ProfileService extends BaseVAService {

    @SneakyThrows
    public Response<ProfileResponse> postChangeProfileType(String id, String adminBearerToken, ProfileRequest body) {
        ProfileAPI service = retrofit.create(ProfileAPI.class);
        Call<ProfileResponse> call = service.postProfile(id, "Bearer " + adminBearerToken, body);
        return call.execute();
    }
}
