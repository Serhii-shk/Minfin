package com.minfin.Minfin.api.model.va.api.phones.phoneId;

import com.google.gson.annotations.SerializedName;

public class Meta{

	@SerializedName("total")
	private int total;

	@SerializedName("max_results")
	private int maxResults;

	@SerializedName("page")
	private int page;
}