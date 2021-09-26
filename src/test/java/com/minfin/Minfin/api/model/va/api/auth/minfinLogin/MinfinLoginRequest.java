package com.minfin.Minfin.api.model.va.api.auth.minfinLogin;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;

@Builder
public class MinfinLoginRequest {

    @SerializedName("account_type")
    private String accountType;

    @SerializedName("user_id")
    private int userId;

    @SerializedName("nickname")
    private String nickname;

    @SerializedName("verified")
    private boolean verified;

    @SerializedName("last_name")
    private String lastName;

    @SerializedName("agree")
    private boolean agree;

    @SerializedName("login")
    private String login;

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("slug")
    private String slug;
}