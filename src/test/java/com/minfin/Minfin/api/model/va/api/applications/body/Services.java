package com.minfin.Minfin.api.model.va.api.applications.body;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Services{

	@SerializedName("damaged_bills")
	private boolean damagedBills;

	@SerializedName("transfer")
	private boolean transfer;

	@SerializedName("parts")
	private boolean parts;
}