package com.minfin.Minfin.api.model.va.api.branches.body;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Sat{

	@SerializedName("worked")
	private boolean worked;

	@SerializedName("breaks")
	private List<Object> breaks;

	@SerializedName("start")
	private String start;

	@SerializedName("end")
	private String end;
}