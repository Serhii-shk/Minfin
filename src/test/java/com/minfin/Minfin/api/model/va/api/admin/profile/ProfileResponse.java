package com.minfin.Minfin.api.model.va.api.admin.profile;

import com.google.gson.annotations.SerializedName;

public class ProfileResponse {

    @SerializedName("_error")
    private Error error;

    @SerializedName("_status")
    private String status;
}