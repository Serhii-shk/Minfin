package com.minfin.Minfin.api.model.va.api.payment.paymentRequestFormTwoLinks.response;

import com.google.gson.annotations.SerializedName;

public class PaymentRequestFormTwoLinksResponse{

	@SerializedName("amount")
	private double amount;

	@SerializedName("profile_type")
	private String profileType;

	@SerializedName("payment_id")
	private String paymentId;

	@SerializedName("payment_form")
	private String paymentForm;

	@SerializedName("nickname")
	private String nickname;

	@SerializedName("description")
	private String description;
}