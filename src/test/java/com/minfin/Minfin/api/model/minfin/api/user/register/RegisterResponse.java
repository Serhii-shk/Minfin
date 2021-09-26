package com.minfin.Minfin.api.model.minfin.api.user.register;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;

@Builder
@lombok.Data
public class RegisterResponse {

    @SerializedName("result")
    private boolean result;

    @SerializedName("data")
    private Data data;
}