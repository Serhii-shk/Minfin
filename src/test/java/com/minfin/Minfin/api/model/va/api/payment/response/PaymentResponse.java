package com.minfin.Minfin.api.model.va.api.payment.response;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class PaymentResponse{

	@SerializedName("lastName")
	private String lastName;

	@SerializedName("subscribe")
	private boolean subscribe;

	@SerializedName("verified")
	private boolean verified;

	@SerializedName("active")
	private boolean active;

	@SerializedName("minfin_tarif_slug")
	private Object minfinTarifSlug;

	@SerializedName("_updated")
	private String updated;

	@SerializedName("agree")
	private boolean agree;

	@SerializedName("subscription")
	private Object subscription;

	@SerializedName("type")
	private String type;

	@SerializedName("firstName")
	private String firstName;

	@SerializedName("bank_id")
	private Object bankId;

	@SerializedName("service")
	private Object service;

	@SerializedName("_created")
	private String created;

	@SerializedName("nickname")
	private String nickname;

	@SerializedName("payment")
	private Payment payment;

	@SerializedName("_id")
	private String id;
}