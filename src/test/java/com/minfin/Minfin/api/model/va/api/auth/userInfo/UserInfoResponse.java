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

    public Object getServiceKey() {
        return serviceKey;
    }

    public String getProfileType() {
        return profileType;
    }

    public String getAuthId() {
        return authId;
    }

    public String getProfileId() {
        return profileId;
    }

    public Object getServiceExpire() {
        return serviceExpire;
    }

    public String getNickname() {
        return nickname;
    }

    public Boolean isVerified() {
        return verified;
    }

    public Boolean isActiveSubscription() {
        return activeSubscription;
    }

    public Object getLastSubscriptionPayment() {
        return lastSubscriptionPayment;
    }

    public Object getLastSubscriptionUpdatePayment() {
        return lastSubscriptionUpdatePayment;
    }
}