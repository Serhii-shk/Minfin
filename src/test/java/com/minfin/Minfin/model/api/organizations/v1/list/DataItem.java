package com.minfin.Minfin.model.api.organizations.v1.list;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class DataItem{

	@SerializedName("credit_wizard_form_type")
	private String creditWizardFormType;

	@SerializedName("own_capital")
	private Object ownCapital;

	@SerializedName("has_telegram_support")
	private int hasTelegramSupport;

	@SerializedName("card_commercial_order")
	private int cardCommercialOrder;

	@SerializedName("hide_recommended_product")
	private int hideRecommendedProduct;

	@SerializedName("type")
	private int type;

	@SerializedName("iosAppUrl")
	private String iosAppUrl;

	@SerializedName("has_loan_in_case_of_debt_in_another_mfo")
	private int hasLoanInCaseOfDebtInAnotherMfo;

	@SerializedName("logo")
	private List<String> logo;

	@SerializedName("androidAppUrl")
	private String androidAppUrl;

	@SerializedName("affise_index")
	private int affiseIndex;

	@SerializedName("has_business_loan")
	private int hasBusinessLoan;

	@SerializedName("id")
	private int id;

	@SerializedName("travel_license_number")
	private String travelLicenseNumber;

	@SerializedName("slug")
	private String slug;

	@SerializedName("card_tracking_url")
	private Object cardTrackingUrl;

	@SerializedName("order")
	private int order;

	@SerializedName("travel_license_description")
	private String travelLicenseDescription;

	@SerializedName("has_identification_through_diya")
	private int hasIdentificationThroughDiya;

	@SerializedName("has_identification_through_privat_bank_face_id")
	private int hasIdentificationThroughPrivatBankFaceId;

	@SerializedName("taxagent")
	private Object taxagent;

	@SerializedName("mortgage_tracking_url")
	private Object mortgageTrackingUrl;

	@SerializedName("has_twenty_four_on_seven_support")
	private int hasTwentyFourOnSevenSupport;

	@SerializedName("license_number")
	private String licenseNumber;

	@SerializedName("phone")
	private String phone;

	@SerializedName("regulator")
	private Object regulator;

	@SerializedName("has_loyalty_program_for_regular_customers")
	private int hasLoyaltyProgramForRegularCustomers;

	@SerializedName("rating_bank")
	private double ratingBank;

	@SerializedName("work_schedule")
	private WorkSchedule workSchedule;

	@SerializedName("card_wizard_form_type")
	private String cardWizardFormType;

	@SerializedName("travel_license_image")
	private String travelLicenseImage;

	@SerializedName("broker_wizard_form_type")
	private Object brokerWizardFormType;

	@SerializedName("description")
	private String description;

	@SerializedName("rating_mfo_place")
	private Object ratingMfoPlace;

	@SerializedName("title")
	private String title;

	@SerializedName("salesdoubler_id")
	private Object salesdoublerId;

	@SerializedName("has_viber_support")
	private int hasViberSupport;

	@SerializedName("license_description")
	private String licenseDescription;

	@SerializedName("order_counts")
	private OrderCounts orderCounts;

	@SerializedName("title_g")
	private String titleG;

	@SerializedName("legal_address")
	private String legalAddress;

	@SerializedName("license_image")
	private String licenseImage;

	@SerializedName("subtype")
	private Object subtype;

	@SerializedName("has_registration_through_bank_id")
	private int hasRegistrationThroughBankId;

	@SerializedName("schedule_full_time")
	private boolean scheduleFullTime;

	@SerializedName("credit_tracking_url")
	private Object creditTrackingUrl;

	@SerializedName("title_p")
	private String titleP;

	@SerializedName("email")
	private String email;

	@SerializedName("show_news")
	private int showNews;

	@SerializedName("is_active")
	private int isActive;

	@SerializedName("subbroker")
	private Object subbroker;

	@SerializedName("mortgage_wizard_form_type")
	private String mortgageWizardFormType;

	@SerializedName("has_facebook_support")
	private int hasFacebookSupport;

	@SerializedName("travel_license_date")
	private String travelLicenseDate;

	@SerializedName("rating_mfo")
	private int ratingMfo;

	@SerializedName("site")
	private String site;

	@SerializedName("broker_tracking_url")
	private Object brokerTrackingUrl;

	@SerializedName("show_map_with_bank_branches")
	private int showMapWithBankBranches;

	@SerializedName("license_date")
	private String licenseDate;

	@SerializedName("finline_id")
	private Object finlineId;

	@SerializedName("show_mobile_apps")
	private int showMobileApps;
}