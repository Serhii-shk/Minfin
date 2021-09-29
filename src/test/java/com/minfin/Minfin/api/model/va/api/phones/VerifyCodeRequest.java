package com.minfin.Minfin.api.model.va.api.phones;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;

@Builder
public class VerifyCodeRequest {

	@SerializedName("verification_code")
	private String verificationCode;
}