package com.minfin.Minfin.api.model.va.api.branches.body;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BranchesBody{

	@SerializedName("address")
	private String address;

	@SerializedName("branch_type")
	private String branchType;

	@SerializedName("city")
	private int city;

	@SerializedName("profile_id")
	private String profileId;

	@SerializedName("site_id")
	private String siteId;

	@SerializedName("location")
	private Location location;

	@SerializedName("work_time")
	private WorkTime workTime;

	@SerializedName("services")
	private Services services;

	@SerializedName("phone_id")
	private String phoneId;
}