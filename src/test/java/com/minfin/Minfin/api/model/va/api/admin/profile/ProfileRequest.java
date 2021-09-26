package com.minfin.Minfin.api.model.va.api.admin.profile;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;

@Builder
public class ProfileRequest {

    @SerializedName("service_product_id")
    private String serviceProductId;

    @SerializedName("active_at")
    private String activeAt;

    @SerializedName("count_items")
    private int countItems;
}