package com.minfin.Minfin.api.client.va.api.licenses.setLicenseStatus;

import com.minfin.Minfin.api.model.va.api.licenses.setLicenseStatus.SetLicenseStatusBody;
import com.minfin.Minfin.api.model.va.api.licenses.setLicenseStatus.SetLicenseStatusResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface SetLicenseStatusAPI {
    @Headers({"Content-Type: application/json"})
    @POST("api/admin/set_license_status/")
    Call<SetLicenseStatusResponse> postSetLicenseStatus(@Body SetLicenseStatusBody body);
}
