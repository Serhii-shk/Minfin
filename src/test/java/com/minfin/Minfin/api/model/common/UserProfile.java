package com.minfin.Minfin.api.model.common;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserProfile {
    //RegisterRequest
    String email;
    String password;
//    String login;
//    boolean privacy;
//    boolean rules;
//    int check;
//    String firstName;
//    String phone;

//    //AuctionResponse.SendData
//    private String accountType;
//    private List<Object> profilePhones;
//    private boolean subscribe;
//    private boolean verified;
//    private String lastName;
//    private boolean agree;
//    private String login;
//    private boolean subscriptionActive;
//    private int userId;
//    private String nickname;
//    private String firstName;
//    private Object slug;
//    private String subscriptionExpire;

//    //ChangeProfileTypeRequest
//    String type;

//    //UserInfoResponse
//    private Object serviceKey;
//    private String profileType;
//    private String authId;
//    private String profileId;
//    private Object serviceExpire;
//    private String nickname;
//    private Boolean verified;
//    private Boolean activeSubscription;
//    private Object lastSubscriptionPayment;
//    private Object lastSubscriptionUpdatePayment;
//
//    //PhonesResponse
//    private String sentBy;
//    private String phone;
//    private String profileId;
//    private String message;
//    private String phoneId;

//    //PhoneIdResponse.ItemsItem[]
//    private String phone;
//    private String profileId;
//    private String created;
//    private boolean verified;
//    private String updated;
//    private String id;
//
//    //BranchesBody
    private String address;
//    private String branchType;
//    private int city;
//    private String profileId;
//    private String siteId;
//    private Location location;
//    private WorkTime workTime;
//    private Services services;
//    private String phoneId;

//    //BranchesResponse
//    private String created;
//    private String updated;
      private String id;
//    private String status;
//
//    //LicensesBody

//    //LicensesResponse
//
//    //RatesBody
}
