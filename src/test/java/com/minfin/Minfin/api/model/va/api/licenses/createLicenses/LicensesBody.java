package com.minfin.Minfin.api.model.va.api.licenses.createLicenses;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LicensesBody{

	@SerializedName("profile_id")
	private String profileId;

	@SerializedName("name")
	private String name;
}