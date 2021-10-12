package com.minfin.Minfin.api.model.va.api.applications.response;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class ApplicationsResponse{

	@SerializedName("_created")
	private String created;

	@SerializedName("_updated")
	private String updated;

	@SerializedName("_id")
	private String id;

	@SerializedName("_status")
	private String status;
}