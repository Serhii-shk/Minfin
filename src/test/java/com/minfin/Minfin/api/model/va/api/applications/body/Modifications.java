package com.minfin.Minfin.api.model.va.api.applications.body;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Modifications{

	@SerializedName("pinned")
	private boolean pinned;

	@SerializedName("painted")
	private boolean painted;
}