package com.minfin.Minfin.api.model.va.api.notification.body;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SendNotificationBody {

	@SerializedName("phone")
	private String phone;

	@SerializedName("email")
	private String email;
}