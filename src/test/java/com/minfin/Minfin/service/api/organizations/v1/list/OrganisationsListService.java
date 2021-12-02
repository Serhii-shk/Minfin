package com.minfin.Minfin.service.api.organizations.v1.list;

import com.minfin.Minfin.client.api.organizations.v1.list.OrganizationsListAPI;
import com.minfin.Minfin.model.api.organizations.v1.list.OrganizationsResponse;
import com.minfin.Minfin.service.BaseService;
import lombok.SneakyThrows;
import retrofit2.Call;
import retrofit2.Response;


public class OrganisationsListService extends BaseService {

    @SneakyThrows
    public Response<OrganizationsResponse> getData(int type, int active, String locale) {
        OrganizationsListAPI service = retrofit.create(OrganizationsListAPI.class);
        Call<OrganizationsResponse> call = service.getData(type, active, locale);
        return call.execute();
    }
}
