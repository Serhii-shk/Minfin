package com.minfin.Minfin.model.api.products.v1.data.creditCards;

import com.google.gson.annotations.SerializedName;

public class LoanRateEffective{

	@SerializedName("min")
	private double min;

	@SerializedName("max")
	private double max;
}