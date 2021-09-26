package com.minfin.Minfin.api.model.va.api.auth.changeProfileType;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class ChangeProfileTypeResponse {

    @SerializedName("access_token")
    private String accessToken;

    @SerializedName("refresh_token")
    private String refreshToken;
}