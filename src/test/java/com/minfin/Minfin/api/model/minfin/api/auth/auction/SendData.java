package com.minfin.Minfin.api.model.minfin.api.auth.auction;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SendData{

	@SerializedName("account_type")
	private String accountType;

	@SerializedName("profile_phones")
	private List<Object> profilePhones;

	@SerializedName("subscribe")
	private boolean subscribe;

	@SerializedName("verified")
	private boolean verified;

	@SerializedName("last_name")
	private String lastName;

	@SerializedName("agree")
	private boolean agree;

	@SerializedName("login")
	private String login;

	@SerializedName("subscription_active")
	private boolean subscriptionActive;

	@SerializedName("user_id")
	private int userId;

	@SerializedName("nickname")
	private String nickname;

	@SerializedName("first_name")
	private String firstName;

	@SerializedName("slug")
	private Object slug;

	@SerializedName("subscription_expire")
	private String subscriptionExpire;
}