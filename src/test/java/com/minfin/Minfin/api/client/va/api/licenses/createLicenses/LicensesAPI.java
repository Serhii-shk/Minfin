package com.minfin.Minfin.api.client.va.api.licenses.createLicenses;

import com.minfin.Minfin.api.model.va.api.licenses.createLicenses.LicensesBody;
import com.minfin.Minfin.api.model.va.api.licenses.createLicenses.LicensesResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface LicensesAPI {

    @Headers({"Content-Type: application/json"})
    @POST("api/licenses/my")
    Call<LicensesResponse> postLicenses(@Header(value = "Authorization") String bearerToken,
                                        @Body LicensesBody body);
}
