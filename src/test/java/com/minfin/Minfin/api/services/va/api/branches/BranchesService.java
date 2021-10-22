package com.minfin.Minfin.api.services.va.api.branches;

import com.google.gson.Gson;
import com.minfin.Minfin.api.client.va.api.branches.BranchesAPI;
import com.minfin.Minfin.api.model.va.api.branches.body.BranchesBody;
import com.minfin.Minfin.api.model.va.api.branches.response.BranchesResponse;
import com.minfin.Minfin.api.services.va.BaseVAService;
import lombok.SneakyThrows;
import retrofit2.Call;
import retrofit2.Response;

public class BranchesService extends BaseVAService {
    @SneakyThrows
    public Response<BranchesResponse> postBranches(String bearerToken, BranchesBody body) {
        BranchesAPI service = getRetrofit().create(BranchesAPI.class);
        Call<BranchesResponse> call = service.postBranches("Bearer " + bearerToken, body);
        return call.execute();
    }
}
