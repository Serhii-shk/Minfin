package com.minfin.Minfin.api.client.va.api.admin.profile;

import com.minfin.Minfin.api.model.minfin.api.auth.auction.AuctionResponse;
import com.minfin.Minfin.api.model.va.api.admin.profile.ProfileRequest;
import com.minfin.Minfin.api.model.va.api.admin.profile.ProfileResponse;
import com.minfin.Minfin.api.model.va.api.auth.userInfo.UserInfoResponse;
import retrofit2.Call;
import retrofit2.http.*;

public interface ProfileAPI {

    @Headers({"Cookie:minfin_sessions=a7497b06881fa70bc5bc7ed6ca0c6387a1c6b781",
            "Content-Type: application/json"})
    @POST("api/admin/profile/{profileId}/subscription")
    /** @param profileId @see {@link UserInfoResponse#profileId }
     * @param bearerToken @see {@link AuctionResponse#accessToken}*/
    Call<ProfileResponse> postProfile(@Path("profileId") String profileId,
                                      @Header(value = "Authorization") String bearerToken,
                                      @Body ProfileRequest body);
}
