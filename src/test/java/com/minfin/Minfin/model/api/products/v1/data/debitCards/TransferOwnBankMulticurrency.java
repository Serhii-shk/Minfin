package com.minfin.Minfin.model.api.products.v1.data.debitCards;

import com.google.gson.annotations.SerializedName;

public class TransferOwnBankMulticurrency{

	@SerializedName("eur")
	private Object eur;

	@SerializedName("usd")
	private Object usd;

	@SerializedName("uah")
	private double uah;
}