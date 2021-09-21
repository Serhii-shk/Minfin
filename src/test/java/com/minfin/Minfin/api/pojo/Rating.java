package com.minfin.Minfin.api.pojo;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Rating{

	@SerializedName("currency_rate")
	private int currencyRate;

	@SerializedName("common")
	private int common;

	@SerializedName("safety")
	private int safety;

	@SerializedName("availability")
	private int availability;

	@SerializedName("quality")
	private int quality;


}