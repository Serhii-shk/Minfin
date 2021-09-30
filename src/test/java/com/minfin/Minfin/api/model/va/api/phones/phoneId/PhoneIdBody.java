package com.minfin.Minfin.api.model.va.api.phones.phoneId;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class PhoneIdBody {

	@SerializedName("profile_id")
	private String profileId;
}