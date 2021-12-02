package com.minfin.Minfin.model.api.products.v1.data.debitCards;

import com.google.gson.annotations.SerializedName;

public class OwnAtmMinAmountMulticurrency{

	@SerializedName("eur")
	private Object eur;

	@SerializedName("usd")
	private Object usd;

	@SerializedName("uah")
	private Object uah;
}