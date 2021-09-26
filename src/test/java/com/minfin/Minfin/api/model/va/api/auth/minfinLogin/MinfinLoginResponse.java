package com.minfin.Minfin.api.model.va.api.auth.minfinLogin;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class MinfinLoginResponse {

    @SerializedName("access_token")
    private String accessToken;

    @SerializedName("refresh_token")
    private String refreshToken;

    @SerializedName("dbg")
    private Dbg dbg;
}