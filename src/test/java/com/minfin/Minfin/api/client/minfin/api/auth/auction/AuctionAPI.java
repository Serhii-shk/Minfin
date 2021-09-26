package com.minfin.Minfin.api.client.minfin.api.auth.auction;

import com.minfin.Minfin.api.model.minfin.api.auth.auction.AuctionResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface AuctionAPI {

    @Headers({"Cookie: minfin_sessions=a77f3459ab2b5ac9e2369f8ef78d3d17fbda754a"})
    @GET("/api/auth/auction-stage/")
    Call<AuctionResponse> getAuction();
}
