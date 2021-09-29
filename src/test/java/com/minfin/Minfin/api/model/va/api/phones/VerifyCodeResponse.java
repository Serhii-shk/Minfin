package com.minfin.Minfin.api.model.va.api.phones;

import com.google.gson.annotations.SerializedName;

public class VerifyCodeResponse {

	@SerializedName("phone")
	private String phone;

	@SerializedName("profile_id")
	private String profileId;

	@SerializedName("message")
	private String message;
}