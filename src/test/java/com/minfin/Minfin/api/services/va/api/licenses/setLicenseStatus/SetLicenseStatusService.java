package com.minfin.Minfin.api.services.va.api.licenses.setLicenseStatus;


import com.minfin.Minfin.api.client.va.api.licenses.setLicenseStatus.SetLicenseStatusAPI;
import com.minfin.Minfin.api.model.va.api.licenses.setLicenseStatus.SetLicenseStatusBody;
import com.minfin.Minfin.api.model.va.api.licenses.setLicenseStatus.SetLicenseStatusResponse;
import com.minfin.Minfin.api.services.va.BaseVAService;
import lombok.SneakyThrows;
import retrofit2.Call;
import retrofit2.Response;

public class SetLicenseStatusService extends BaseVAService {
    @SneakyThrows
    public Response<SetLicenseStatusResponse> postSetLicenseStatus(SetLicenseStatusBody body) {
        SetLicenseStatusAPI service = retrofit.create(SetLicenseStatusAPI.class);
        Call<SetLicenseStatusResponse> call = service.postSetLicenseStatus(body);
        return call.execute();
    }
}
