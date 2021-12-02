package com.minfin.Minfin.model.api.products.v1.data.debitCards;

import com.google.gson.annotations.SerializedName;

public class PreparationTime{

	@SerializedName("min")
	private int min;

	@SerializedName("max")
	private int max;
}