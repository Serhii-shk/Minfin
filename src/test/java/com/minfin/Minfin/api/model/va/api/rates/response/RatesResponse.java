package com.minfin.Minfin.api.model.va.api.rates.response;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RatesResponse {

	@SerializedName("added")
	private List<String> added;

	@SerializedName("updated")
	private List<Object> updated;
}