package com.minfin.Minfin.api.model.va.api.applications.body;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApplicationsBody{

	@SerializedName("amount")
	private int amount;

	@SerializedName("address")
	private String address;

	@SerializedName("city")
	private int city;

	@SerializedName("description")
	private String description;

	@SerializedName("services")
	private Services services;

	@SerializedName("type")
	private String type;

	@SerializedName("rate")
	private int rate;

	@SerializedName("profile_id")
	private String profileId;

	@SerializedName("site_id")
	private String siteId;

	@SerializedName("currency")
	private String currency;

	@SerializedName("location")
	private Location location;

	@SerializedName("phone_id")
	private String phoneId;

	@SerializedName("modifications")
	private Modifications modifications;
}