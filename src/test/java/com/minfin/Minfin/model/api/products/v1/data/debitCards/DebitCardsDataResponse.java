package com.minfin.Minfin.model.api.products.v1.data.debitCards;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class DebitCardsDataResponse {

	@SerializedName("data")
	private List<DebitCardsDataItem> data;

	@SerializedName("info")
	private List<Object> info;
}