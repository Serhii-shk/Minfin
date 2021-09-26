package com.minfin.Minfin.api.model.minfin.api.auth.auction;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class AuctionResponse {

	@SerializedName("access_token")
	private String accessToken;

	@SerializedName("refresh_token")
	private String refreshToken;

	@SerializedName("send_data")
	private SendData sendData;
}