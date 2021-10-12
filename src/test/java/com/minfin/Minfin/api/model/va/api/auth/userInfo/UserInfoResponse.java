package com.minfin.Minfin.api.model.va.api.auth.userInfo;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class UserInfoResponse {

    @SerializedName("service_key")
    private Object serviceKey;

    @SerializedName("profile_type")
    private String profileType;

    @SerializedName("auth_id")
    private String authId;

    @SerializedName("profile_id")
    private String profileId;

    @SerializedName("service_expire")
    private Object serviceExpire;

    @SerializedName("nickname")
    private String nickname;

    @SerializedName("verified")
    private Boolean verified;

    @SerializedName("active_subscription")
    private Boolean activeSubscription;

    @SerializedName("last_subscription_payment")
    private Object lastSubscriptionPayment;

    @SerializedName("last_subscription_update_payment")
    private Object lastSubscriptionUpdatePayment;

}