package com.minfin.Minfin.client.api.products.v1.list;

import com.minfin.Minfin.model.api.products.v1.data.debitCards.DebitCardsDataResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface DebitCardsDataAPI {
    @GET("/api/products/v1/data")
    Call<DebitCardsDataResponse> getData(@Query("locale") String locale,
                                         @Query("active") int active,
                                         @Query(value = "ids", encoded = true) List<Integer> ids);
}
