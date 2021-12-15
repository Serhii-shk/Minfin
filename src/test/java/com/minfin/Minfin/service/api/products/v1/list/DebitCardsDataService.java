package com.minfin.Minfin.service.api.products.v1.list;

import com.minfin.Minfin.client.api.products.v1.list.DebitCardsDataAPI;
import com.minfin.Minfin.model.api.products.v1.data.debitCards.DebitCardsDataResponse;
import com.minfin.Minfin.service.BaseService;
import lombok.SneakyThrows;
import retrofit2.Call;
import retrofit2.Response;

public class DebitCardsDataService extends BaseService {
    @SneakyThrows
    public Response<DebitCardsDataResponse> getData(CardsDataPathParameters cardsDataPathParameters) {
        DebitCardsDataAPI service = retrofit.create(DebitCardsDataAPI.class);
        Call<DebitCardsDataResponse> call = service.getData(
                cardsDataPathParameters.getLocale(),
                cardsDataPathParameters.getActive(),
                cardsDataPathParameters.getIds());
        return call.execute();
    }
}