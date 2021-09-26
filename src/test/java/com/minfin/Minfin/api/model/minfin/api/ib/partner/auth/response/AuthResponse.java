package com.minfin.Minfin.api.model.minfin.api.ib.partner.auth.response;

import com.google.gson.annotations.SerializedName;

@lombok.Data
public class AuthResponse {

    @SerializedName("result")
    private boolean result;

    @SerializedName("data")
    private Data data;
}