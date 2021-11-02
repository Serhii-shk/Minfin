package com.minfin.Minfin.api.model.va.api.payment;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentRequestFormResponse{

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