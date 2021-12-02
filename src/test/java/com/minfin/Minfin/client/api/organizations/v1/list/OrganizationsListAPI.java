package com.minfin.Minfin.client.api.organizations.v1.list;

import com.minfin.Minfin.model.api.organizations.v1.list.OrganizationsResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OrganizationsListAPI {
    @GET("/api/organizations/v1/list/?locale=ru")
    Call<OrganizationsResponse> getData(@Query("type") int type,
                                        @Query("active") int active,
                                        @Query("locale") String locale);
}
