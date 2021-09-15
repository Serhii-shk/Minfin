package com.minfin.Minfin.api.pojo;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MinfinAuthUser{

	@SerializedName("account_type")
	private String accountType;

	@SerializedName("user_id")
	private Integer userId;

	@SerializedName("nickname")
	private String nickname;

	@SerializedName("verified")
	private boolean verified;

	@SerializedName("agree")
	private boolean agree;

	@SerializedName("login")
	private String login;

	@SerializedName("password")
	private String password;

	@SerializedName("first_name")
	private String firstName;

	@SerializedName("last_name")
	private String lastName;

	@SerializedName("slug")
	private Object slug;

}
