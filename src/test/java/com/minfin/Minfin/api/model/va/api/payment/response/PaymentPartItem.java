package com.minfin.Minfin.api.model.va.api.payment.response;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class PaymentPartItem{

	@SerializedName("amount")
	private double amount;

	@SerializedName("pay_link")
	private String payLink;

	@SerializedName("status")
	private String status;
}