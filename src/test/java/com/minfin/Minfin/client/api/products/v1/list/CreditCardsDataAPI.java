package com.minfin.Minfin.client.api.products.v1.list;

import com.minfin.Minfin.model.api.products.v1.data.creditCards.CreditCardsDataResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;


public interface CreditCardsDataAPI {
    @GET("/api/products/v1/data")
    Call<CreditCardsDataResponse> getData(@Query("locale") String locale,
                                          @Query("active") int active,
                                          @Query(value = "ids", encoded = true) List<Integer> ids);
}
