package com.minfin.Minfin.model.api.products.v1.data.creditCards;

import com.google.gson.annotations.SerializedName;

public class AgeRange{

	@SerializedName("min")
	private int min;

	@SerializedName("max")
	private int max;
}