package com.minfin.Minfin.api.model.va.api.phones.phoneId;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class PhoneIdResponse{

	@SerializedName("_meta")
	private Meta meta;

	@SerializedName("_items")
	private List<ItemsItem> items;
}