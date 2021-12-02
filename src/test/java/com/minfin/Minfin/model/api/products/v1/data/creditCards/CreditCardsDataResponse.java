package com.minfin.Minfin.model.api.products.v1.data.creditCards;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class CreditCardsDataResponse {

	@SerializedName("data")
	private List<CreditCardsDataItem> data;

	@SerializedName("info")
	private List<Object> info;
}