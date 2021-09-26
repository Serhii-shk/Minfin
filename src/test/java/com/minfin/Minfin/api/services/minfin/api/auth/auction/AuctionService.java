package com.minfin.Minfin.api.services.minfin.api.auth.auction;

import com.minfin.Minfin.api.client.minfin.api.auth.auction.AuctionAPI;
import com.minfin.Minfin.api.model.minfin.api.auth.auction.AuctionResponse;
import com.minfin.Minfin.api.services.minfin.BaseMinfinService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import retrofit2.Call;
import retrofit2.Response;

@Slf4j
public class AuctionService extends BaseMinfinService {

    @SneakyThrows
    public Response<AuctionResponse> getAuction() {
        AuctionAPI service = retrofit.create(AuctionAPI.class);
        Call<AuctionResponse> call = service.getAuction();
        return call.execute();
    }
}
