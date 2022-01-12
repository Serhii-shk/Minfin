package com.minfin.Minfin.api.client.va.api.licenses.setLicenseStatus;

import com.minfin.Minfin.api.model.va.api.licenses.setLicenseStatus.SetLicenseStatusResponse;
import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface SetLicenseStatusAPI {
    @Headers({"Content-Type: application/json"})
    @POST("api/admin/licenses/of/{profile_id}/approve")
    Call<SetLicenseStatusResponse> postSetLicenseStatus(@Header(value = "Authorization") String bearerToken
            , @Path("profile_id") String profile_id);
}
