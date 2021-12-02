package com.minfin.Minfin.model.api.products.v1.list;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class ProductsDataResponse {

	@SerializedName("data")
	private List<Integer> data;

	@SerializedName("info")
	private List<Object> info;
}