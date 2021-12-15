package com.minfin.Minfin.model.api.products.v1.data.creditCards;

import com.google.gson.annotations.SerializedName;

public class LoanLimitNumber{

	@SerializedName("min")
	private int min;

	@SerializedName("max")
	private int max;
}