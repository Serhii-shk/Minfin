package com.minfin.Minfin.api.model.va.api.rates.body;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Sell{

	@SerializedName("max_count")
	private int maxCount;

	@SerializedName("value")
	private double value;

	@SerializedName("min_count")
	private int minCount;
}