package com.minfin.Minfin.api.model.va.api.licenses.createLicenses;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data

public class LicensesResponse{

	@SerializedName("_created")
	private String created;

	@SerializedName("_updated")
	private String updated;

	@SerializedName("_id")
	private String id;

	@SerializedName("_status")
	private String status;
}