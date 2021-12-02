package com.minfin.Minfin.client.api.products.v1.list;

import com.minfin.Minfin.model.api.products.v1.list.ProductsDataResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ProductsDataAPI {
    @GET("/api/products/v1/list")
    Call<ProductsDataResponse> getData(@Query("product_type") int productType,
                                       @Query("grace_period_days_limit") String gracePeriodDaysLimit,
                                       @Query("active") int active,
                                       @Query("delivery") String delivery,
                                       @Query("own_funds_own_atm_commission_percent") String ownFundsOwnAtmCommissionPercent,
                                       @Query("own_atm_commission_percent") String ownAtmCommissionPercent,
                                       @Query("employment_type") String employmentType,
                                       @Query("age_range") String ageRange,
                                       @Query("preparation_time") String preparationTime,
                                       @Query("obtain_conditions_type") String obtainConditionsType,
                                       @Query("cashback") String cashback,
                                       @Query("card_type") String cardType,
                                       @Query("currency_list") String currencyList,
                                       @Query("technology") String technology,
                                       @Query("vendor_id") String vendorId,
                                       @Query(value = "ids", encoded = true) String ids,
                                       @Query("local") String local);
}
