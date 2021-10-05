package com.minfin.Minfin.api.model.va.api.licenses.setLicenseStatus;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class SetLicenseStatusResponse{

	@SerializedName("message")
	private String message;
}