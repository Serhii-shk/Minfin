package com.minfin.Minfin.api.client.minfin.api.auth.auction;

import com.minfin.Minfin.api.model.minfin.api.auth.auction.AuctionResponse;
import io.qameta.allure.Param;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface AuctionAPI {

    @Headers({"Cookie: minfin_sessions=a77f3459ab2b5ac9e2369f8ef78d3d17fbda754a"})
    @GET("/api/auth/auction{env}/")
    Call<AuctionResponse> getAuction(@Path("env") String env);
}
