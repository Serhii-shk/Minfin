package com.minfin.Minfin.api.model.minfin.api.ib.partner.auth.response;

import com.google.gson.annotations.SerializedName;

@lombok.Data
public class Data {

    @SerializedName("new_partner")
    private boolean newPartner;

    @SerializedName("Token")
    private boolean token;
}