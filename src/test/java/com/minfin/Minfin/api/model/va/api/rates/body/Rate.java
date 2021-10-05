package com.minfin.Minfin.api.model.va.api.rates.body;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Rate{

	@SerializedName("buy")
	private Buy buy;

	@SerializedName("sell")
	private Sell sell;
}