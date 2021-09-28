package com.minfin.Minfin.api.model.va.api.phones;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class PhonesResponse{

	@SerializedName("sent_by")
	private String sentBy;

	@SerializedName("phone")
	private String phone;

	@SerializedName("profile_id")
	private String profileId;

	@SerializedName("message")
	private String message;

	@SerializedName("phone_id")
	private String phoneId;
}