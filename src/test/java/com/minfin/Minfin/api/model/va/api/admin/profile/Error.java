package com.minfin.Minfin.api.model.va.api.admin.profile;

import com.google.gson.annotations.SerializedName;

public class Error {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;
}