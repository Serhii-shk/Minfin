package com.minfin.Minfin.api.pojo;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class AuthAuctioneResponse{

	@SerializedName("access_token")
	private String accessToken;

	@SerializedName("refresh_token")
	private String refreshToken;

	@SerializedName("send_data")
	private SendData sendData;
}