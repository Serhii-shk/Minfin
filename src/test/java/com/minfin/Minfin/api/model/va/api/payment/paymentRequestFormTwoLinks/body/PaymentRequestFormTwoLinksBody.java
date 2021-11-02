package com.minfin.Minfin.api.model.va.api.payment.paymentRequestFormTwoLinks.body;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentRequestFormTwoLinksBody{

	@SerializedName("part_id")
	private int partId;
}