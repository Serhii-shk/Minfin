package com.minfin.Minfin.api.model.va.api.branches.body;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WorkTime{

	@SerializedName("thu")
	private Thu thu;

	@SerializedName("tue")
	private Tue tue;

	@SerializedName("sat")
	private Sat sat;

	@SerializedName("wed")
	private Wed wed;

	@SerializedName("fri")
	private Fri fri;

	@SerializedName("mon")
	private Mon mon;

	@SerializedName("sun")
	private Sun sun;
}