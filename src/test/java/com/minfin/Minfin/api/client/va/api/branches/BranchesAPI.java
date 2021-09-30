package com.minfin.Minfin.api.client.va.api.branches;

import com.minfin.Minfin.api.model.va.api.branches.body.BranchesBody;
import com.minfin.Minfin.api.model.va.api.branches.response.BranchesResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface BranchesAPI {
    @Headers({"Content-Type: application/json"})
    @POST("api/branches/")
    Call<BranchesResponse> postBranches(@Header(value = "Authorization") String bearerToken,
                                        @Body BranchesBody body);
}
