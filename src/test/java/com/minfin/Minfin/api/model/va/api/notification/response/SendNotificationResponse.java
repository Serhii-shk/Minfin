package com.minfin.Minfin.api.model.va.api.notification.response;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SendNotificationResponse{

	@SerializedName("is_email_send")
	private boolean isEmailSend;

	@SerializedName("links")
	private List<String> links;

	@SerializedName("is_phone_send")
	private boolean isPhoneSend;
}