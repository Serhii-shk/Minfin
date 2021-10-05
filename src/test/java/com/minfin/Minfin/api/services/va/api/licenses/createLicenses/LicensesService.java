package com.minfin.Minfin.api.services.va.api.licenses.createLicenses;


import com.minfin.Minfin.api.client.va.api.licenses.createLicenses.LicensesAPI;
import com.minfin.Minfin.api.model.va.api.licenses.createLicenses.LicensesBody;
import com.minfin.Minfin.api.model.va.api.licenses.createLicenses.LicensesResponse;
import com.minfin.Minfin.api.services.va.BaseVAService;
import lombok.SneakyThrows;
import retrofit2.Call;
import retrofit2.Response;

public class LicensesService extends BaseVAService {
    @SneakyThrows
    public Response<LicensesResponse> postLicenses(String bearerToken, LicensesBody body) {
        LicensesAPI service = retrofit.create(LicensesAPI.class);
        Call<LicensesResponse> call = service.postLicenses("Bearer " + bearerToken, body);
        return call.execute();
    }
}
