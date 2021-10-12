package com.minfin.Minfin.api.client.va.api.applications;

import com.minfin.Minfin.api.model.va.api.applications.body.ApplicationsBody;
import com.minfin.Minfin.api.model.va.api.applications.response.ApplicationsResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApplicationsAPI {

    @Headers({"Content-Type: application/json"})
    @POST("api/applications/")
    Call<ApplicationsResponse> postApplications(@Header(value = "Authorization") String bearerToken,
                                                @Body ApplicationsBody body);
}
