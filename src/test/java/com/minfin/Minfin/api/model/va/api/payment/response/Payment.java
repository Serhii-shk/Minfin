package com.minfin.Minfin.api.model.va.api.payment.response;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
public class Payment{

	@SerializedName("service_key")
	private String serviceKey;

	@SerializedName("payment_url")
	private String paymentUrl;

	@SerializedName("project")
	private String project;

	@SerializedName("description")
	private String description;

	@SerializedName("payee_id")
	private int payeeId;

	@SerializedName("service_product_id")
	private String serviceProductId;

	@SerializedName("dummy")
	private boolean dummy;

	@SerializedName("payment_part")
	private List<PaymentPartItem> paymentPart;

	@SerializedName("currency")
	private String currency;

	@SerializedName("lang")
	private String lang;

	@SerializedName("success_url")
	private Object successUrl;

	@SerializedName("amount")
	private double amount;

	@SerializedName("months")
	private int months;

	@SerializedName("_updated")
	private String updated;

	@SerializedName("period_days")
	private int periodDays;

	@SerializedName("count_items")
	private int countItems;

	@SerializedName("payment_type")
	private String paymentType;

	@SerializedName("payment_expires_at")
	private String paymentExpiresAt;

	@SerializedName("profile_id")
	private String profileId;

	@SerializedName("payment_states")
	private List<Object> paymentStates;

	@SerializedName("_created")
	private String created;

	@SerializedName("_id")
	private String id;

	@SerializedName("failure_url")
	private Object failureUrl;

	@SerializedName("active_at")
	private String activeAt;

	@SerializedName("status")
	private String status;
}