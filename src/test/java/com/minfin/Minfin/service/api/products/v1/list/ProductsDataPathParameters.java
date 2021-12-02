package com.minfin.Minfin.service.api.products.v1.list;

import lombok.*;

@Data
@Builder
public class ProductsDataPathParameters {

    private int productType;
    private String gracePeriodDaysLimit;
    private int active;
    private String delivery;
    private String ownFundsOwnAtmCommissionPercent;
    private String ownAtmCommissionPercent;
    private String employmentType;
    private String ageRange;
    private String preparationTime;
    private String obtainConditionsType;
    private String cashback;
    private String cardType;
    private String currencyList;
    private String technology;
    private String vendorId;
    private String ids;
    private String local;
}
