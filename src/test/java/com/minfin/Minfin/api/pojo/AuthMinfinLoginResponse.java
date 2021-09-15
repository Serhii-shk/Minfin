package com.minfin.Minfin.api.pojo;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class AuthMinfinLoginResponse{

	@SerializedName("access_token")
	private String accessToken;

	@SerializedName("refresh_token")
	private String refreshToken;

	@SerializedName("dbg")
	private Dbg dbg;
}