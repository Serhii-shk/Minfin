package com.minfin.Minfin.api.model.va.api.branches.body;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Location{

	@SerializedName("coordinates")
	private List<Double> coordinates;

	@SerializedName("type")
	private String type;
}