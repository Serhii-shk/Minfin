package com.minfin.Minfin.api.pojo;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RatingReviewPojo {
	@SerializedName("target_id")
	private String target_id;

	@SerializedName("rating")
	private Rating rating;

	@SerializedName("text")
	private String text;
}