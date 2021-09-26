package com.minfin.Minfin.api.model.va.api.auth.changeProfileType;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;

@Builder
public class ChangeProfileTypeRequest {

    @SerializedName("type")
    String type;
}
