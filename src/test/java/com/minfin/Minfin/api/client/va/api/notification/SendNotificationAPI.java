package com.minfin.Minfin.api.client.va.api.notification;

import com.minfin.Minfin.api.model.va.api.notification.body.SendNotificationBody;
import com.minfin.Minfin.api.model.va.api.notification.response.SendNotificationResponse;
import com.minfin.Minfin.api.model.va.api.payment.body.PaymentBody;
import com.minfin.Minfin.api.model.va.api.payment.response.PaymentResponse;
import retrofit2.Call;
import retrofit2.http.*;

public interface SendNotificationAPI {
    @Headers({"Content-Type: application/json"})
    @POST("api/admin/profile/{profileId}/pay-links")
    Call<SendNotificationResponse> postSendNotification(@Path("profileId") String profileId,
                                                        @Header(value = "Authorization") String bearerToken,
                                                        @Body SendNotificationBody body);
}
