package com.minfin.Minfin.service.api.products.v1.list;

import com.minfin.Minfin.client.api.products.v1.list.CreditCardsDataAPI;
import com.minfin.Minfin.model.api.products.v1.data.creditCards.CreditCardsDataResponse;
import com.minfin.Minfin.service.BaseService;
import lombok.SneakyThrows;
import retrofit2.Call;
import retrofit2.Response;

public class CreditCardsDataService extends BaseService {
    @SneakyThrows
    public Response<CreditCardsDataResponse> getData(CardsDataPathParameters cardsDataPathParameters) {
        CreditCardsDataAPI service = retrofit.create(CreditCardsDataAPI.class);
        Call<CreditCardsDataResponse> call = service.getData(
                cardsDataPathParameters.getLocale(),
                cardsDataPathParameters.getActive(),
                cardsDataPathParameters.getIds());
        return call.execute();
    }
}
