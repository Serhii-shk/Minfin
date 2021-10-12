package com.minfin.Minfin.api.services.va.api.applications;

import com.minfin.Minfin.api.client.va.api.applications.ApplicationsAPI;
import com.minfin.Minfin.api.model.va.api.applications.body.ApplicationsBody;
import com.minfin.Minfin.api.model.va.api.applications.response.ApplicationsResponse;
import com.minfin.Minfin.api.services.va.BaseVAService;
import lombok.SneakyThrows;
import retrofit2.Call;
import retrofit2.Response;

public class ApplicationsService extends BaseVAService {
    @SneakyThrows
    public Response<ApplicationsResponse> postApplications(String bearerToken, ApplicationsBody body) {
        ApplicationsAPI service = retrofit.create(ApplicationsAPI.class);
        Call<ApplicationsResponse> call = service.postApplications("Bearer " + bearerToken, body);
        return call.execute();
    }
}
