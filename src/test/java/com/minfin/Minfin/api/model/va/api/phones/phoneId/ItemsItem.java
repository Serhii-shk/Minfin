package com.minfin.Minfin.api.model.va.api.phones.phoneId;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class ItemsItem{

	@SerializedName("phone")
	private String phone;

	@SerializedName("profile_id")
	private String profileId;

	@SerializedName("_created")
	private String created;

	@SerializedName("verified")
	private boolean verified;

	@SerializedName("_updated")
	private String updated;

	@SerializedName("_id")
	private String id;
}