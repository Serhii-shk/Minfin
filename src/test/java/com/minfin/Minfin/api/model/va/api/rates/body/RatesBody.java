package com.minfin.Minfin.api.model.va.api.rates.body;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RatesBody {

	@SerializedName("branch_id")
	private String branchId;

	@SerializedName("rate")
	private Rate rate;

	@SerializedName("profile_id")
	private String profileId;

	@SerializedName("currency")
	private String currency;
}