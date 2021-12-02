package com.minfin.Minfin.model.api.organizations.v1.list;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class OrganizationsResponse {

	@SerializedName("data")
	private List<DataItem> data;
}