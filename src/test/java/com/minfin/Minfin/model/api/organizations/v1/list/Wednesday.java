package com.minfin.Minfin.model.api.organizations.v1.list;

import com.google.gson.annotations.SerializedName;

public class Wednesday{

	@SerializedName("closeTime")
	private Object closeTime;

	@SerializedName("closed")
	private boolean closed;

	@SerializedName("fullTime")
	private boolean fullTime;

	@SerializedName("openTime")
	private Object openTime;
}