package com.minfin.Minfin.model.api.organizations.v1.list;

import com.google.gson.annotations.SerializedName;

public class WorkSchedule{

	@SerializedName("sunday")
	private Sunday sunday;

	@SerializedName("saturday")
	private Saturday saturday;

	@SerializedName("tuesday")
	private Tuesday tuesday;

	@SerializedName("wednesday")
	private Wednesday wednesday;

	@SerializedName("thursday")
	private Thursday thursday;

	@SerializedName("friday")
	private Friday friday;

	@SerializedName("monday")
	private Monday monday;
}