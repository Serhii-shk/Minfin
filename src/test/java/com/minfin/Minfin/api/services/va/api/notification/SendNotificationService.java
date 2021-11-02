package com.minfin.Minfin.api.services.va.api.notification;

import com.minfin.Minfin.api.client.va.api.notification.SendNotificationAPI;
import com.minfin.Minfin.api.model.va.api.notification.body.SendNotificationBody;
import com.minfin.Minfin.api.model.va.api.notification.response.SendNotificationResponse;
import com.minfin.Minfin.api.services.va.BaseVAService;
import lombok.SneakyThrows;
import retrofit2.Call;
import retrofit2.Response;

public class SendNotificationService extends BaseVAService {
    @SneakyThrows
    public Response<SendNotificationResponse> postSendNotification(String id, String adminBearerToken, SendNotificationBody body) {
        SendNotificationAPI service = getRetrofit().create(SendNotificationAPI.class);
        Call<SendNotificationResponse> call = service.postSendNotification(id,"Bearer " + adminBearerToken, body);
        return call.execute();
    }
}
