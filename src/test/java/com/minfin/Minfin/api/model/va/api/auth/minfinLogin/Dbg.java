package com.minfin.Minfin.api.model.va.api.auth.minfinLogin;

import com.google.gson.annotations.SerializedName;

public class Dbg {

    @SerializedName("profile_type")
    private String profileType;

    @SerializedName("profile_id")
    private String profileId;

    @SerializedName("nickname")
    private String nickname;

    @SerializedName("sentry_env")
    private String sentryEnv;
}