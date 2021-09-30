package com.minfin.Minfin.api.model.va.api.branches.body;

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

	@SerializedName("verified")
	private boolean verified;

	@SerializedName("cctv")
	private boolean cctv;

	@SerializedName("recount_room")
	private boolean recountRoom;
}