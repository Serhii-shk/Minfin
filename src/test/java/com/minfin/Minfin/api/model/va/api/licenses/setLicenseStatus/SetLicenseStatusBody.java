package com.minfin.Minfin.api.model.va.api.licenses.setLicenseStatus;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SetLicenseStatusBody{

	@SerializedName("license_id")
	private String licenseId;

	@SerializedName("status")
	private String status;
}