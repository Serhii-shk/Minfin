package com.minfin.Minfin.api.model.va.api.payment.body;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentBody {

	@SerializedName("payment_count")
	private int paymentCount;

	@SerializedName("amount")
	private int amount;

//	@SerializedName("period_days")
//	private int periodDays;

	@SerializedName("service_product_id")
	private String serviceProductId;

	@SerializedName("active_at")
	private String activeAt;

	@SerializedName("payment_expires_days")
	private int paymentExpiresDays;

	@SerializedName("count_items")
	private int countItems;

	@SerializedName("pay_by_link")
	private boolean payByLink;
}