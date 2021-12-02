package com.minfin.Minfin.model.api.products.v1.data.creditCards;

import java.util.List;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.minfin.Minfin.service.EmptyStringAsNullTypeAdapter;
import lombok.Data;

@Data
public class CreditCardsDataItem {

	@SerializedName("additional_card_other_options_description")
	private String additionalCardOtherOptionsDescription;

	@SerializedName("main_card_service_monthly_percent")
	private double mainCardServiceMonthlyPercent;

	@SerializedName("partner_atm_additional_amount")
	private int partnerAtmAdditionalAmount;

	@SerializedName("location_id")
	private List<Integer> locationId;

	@SerializedName("age_range")
	private AgeRange ageRange;

	@SerializedName("own_funds_not_partner_atm_commission_percent")
	private double ownFundsNotPartnerAtmCommissionPercent;

	@SerializedName("additional_conditions")
	private String additionalConditions;

	@SerializedName("product_id")
	private int productId;

	@SerializedName("documents_required")
	private List<String> documentsRequired;

	@SerializedName("id")
	private int id;

	@SerializedName("own_funds_own_atm_additional_amount")
	private int ownFundsOwnAtmAdditionalAmount;

	@SerializedName("own_funds_cashbox_own_bank_additional_amount")
	private int ownFundsCashboxOwnBankAdditionalAmount;

	@SerializedName("transfer_own_card_commission_min_amount")
	private int transferOwnCardCommissionMinAmount;

	@SerializedName("cashbox_own_bank_additional_amount")
	private int cashboxOwnBankAdditionalAmount;

	@SerializedName("card_benefits_description")
	private List<String> cardBenefitsDescription;

	@SerializedName("obtain_conditions_description")
	private Object obtainConditionsDescription;

	@SerializedName("minfin_type_priority")
	@JsonAdapter(EmptyStringAsNullTypeAdapter.class)
	private Boolean minfinTypePriority;

	@SerializedName("foreign_atm_commission_percent")
	private double foreignAtmCommissionPercent;

	@SerializedName("nationality_required")
	private boolean nationalityRequired;

	@SerializedName("pin_code_change_description")
	private String pinCodeChangeDescription;

	@SerializedName("own_funds_partner_atm_additional_amount")
	private int ownFundsPartnerAtmAdditionalAmount;

	@SerializedName("own_funds_own_atm_min_amount")
	private int ownFundsOwnAtmMinAmount;

	@SerializedName("transfer_own_bank_loan_money_commission_percent")
	private double transferOwnBankLoanMoneyCommissionPercent;

	@SerializedName("active")
	private boolean active;

	@SerializedName("card_create_price_description")
	private Object cardCreatePriceDescription;

	@SerializedName("internet_payment_commission_amount")
	private int internetPaymentCommissionAmount;

	@SerializedName("foreign_atm_min_amount")
	private int foreignAtmMinAmount;

	@SerializedName("omp_percent")
	private double ompPercent;

	@SerializedName("resident_required")
	private boolean residentRequired;

	@SerializedName("cashback_max_amount")
	private int cashbackMaxAmount;

	@SerializedName("own_funds_partner_atm_commission_percent")
	private double ownFundsPartnerAtmCommissionPercent;

	@SerializedName("own_funds_partner_atm_description")
	private Object ownFundsPartnerAtmDescription;

	@SerializedName("loan_close_form_day")
	private int loanCloseFormDay;

	@SerializedName("card_re_issue_other_case")
	private String cardReIssueOtherCase;

	@SerializedName("system")
	private List<String> system;

	@SerializedName("finline_product")
	private boolean finlineProduct;

	@SerializedName("vendor_id")
	private int vendorId;

	@SerializedName("maintenance_monthly_price")
	private int maintenanceMonthlyPrice;

	@SerializedName("card_page")
	private String cardPage;

	@SerializedName("transfer_not_own_bank_commission_additional_amount")
	private int transferNotOwnBankCommissionAdditionalAmount;

	@SerializedName("transfer_own_bank_description")
	private String transferOwnBankDescription;

	@SerializedName("has_free_sms_notification")
	private boolean hasFreeSmsNotification;

	@SerializedName("online_order")
	private boolean onlineOrder;

	@SerializedName("type_priority")
	private Object typePriority;

	@SerializedName("own_atm_description")
	private Object ownAtmDescription;

	@SerializedName("transfer_own_bank_commission_min_amount")
	private int transferOwnBankCommissionMinAmount;

	@SerializedName("loan_rate_effective")
	private LoanRateEffective loanRateEffective;

	@SerializedName("personalisation")
	private List<String> personalisation;

	@SerializedName("travel_bonus_description")
	private String travelBonusDescription;

	@SerializedName("mini_extraction_amount")
	private int miniExtractionAmount;

	@SerializedName("transfer_not_own_bank_commission_min_amount")
	private int transferNotOwnBankCommissionMinAmount;

	@SerializedName("cashbox_own_bank_min_amount")
	private int cashboxOwnBankMinAmount;

	@SerializedName("sms_notify")
	private String smsNotify;

	@SerializedName("additional_conditions_description")
	private Object additionalConditionsDescription;

	@SerializedName("own_funds_cashbox_own_bank_min_amount")
	private int ownFundsCashboxOwnBankMinAmount;

	@SerializedName("product_advantages")
	private List<Object> productAdvantages;

	@SerializedName("foreign_atm_additional_amount")
	private int foreignAtmAdditionalAmount;

	@SerializedName("own_funds_foreign_atm_additional_amount")
	private int ownFundsForeignAtmAdditionalAmount;

	@SerializedName("tariff")
	private String tariff;

	@SerializedName("term")
	private int term;

	@SerializedName("pin_code_change_amount")
	private int pinCodeChangeAmount;

	@SerializedName("own_funds_not_partner_atm_min_amount")
	private int ownFundsNotPartnerAtmMinAmount;

	@SerializedName("tracking_url")
	private Object trackingUrl;

	@SerializedName("enrollment_description")
	private Object enrollmentDescription;

	@SerializedName("vendor_type")
	private int vendorType;

	@SerializedName("omp_timeout_penalty_percent")
	private double ompTimeoutPenaltyPercent;

	@SerializedName("minfin_org_priority")
	@JsonAdapter(EmptyStringAsNullTypeAdapter.class)
	private Boolean minfinOrgPriority;

	@SerializedName("cashbox_own_bank_commission_percent")
	private double cashboxOwnBankCommissionPercent;

	@SerializedName("transfer_own_card_loan_money_commission_percent")
	private double transferOwnCardLoanMoneyCommissionPercent;

	@SerializedName("card_type")
	private String cardType;

	@SerializedName("not_partner_atm_additional_amount")
	private int notPartnerAtmAdditionalAmount;

	@SerializedName("other_bonus_description")
	private Object otherBonusDescription;

	@SerializedName("is_in_minfin_catalog")
	private boolean isInMinfinCatalog;

	public boolean getIsInMinfinCatalog() {
		return isInMinfinCatalog;
	}

	public void setIsInMinfinCatalog(boolean isInMinfinCatalog) {
		this.isInMinfinCatalog = isInMinfinCatalog;
	}

	@SerializedName("advantages")
	private List<Object> advantages;

	@SerializedName("loan_rate_month")
	private double loanRateMonth;

	@SerializedName("loyalty_program_description")
	private String loyaltyProgramDescription;

	@SerializedName("additional_card_create_price_once")
	private int additionalCardCreatePriceOnce;

	@SerializedName("balance_request_own_atm_amount")
	private int balanceRequestOwnAtmAmount;

	@SerializedName("own_funds_not_partner_atm_description")
	private Object ownFundsNotPartnerAtmDescription;

	@SerializedName("insurance")
	private Object insurance;

	@SerializedName("not_partner_atm_min_amount")
	private int notPartnerAtmMinAmount;

	@SerializedName("balance_request_not_own_atm_amount")
	private int balanceRequestNotOwnAtmAmount;

	@SerializedName("loan_rate_text")
	private Object loanRateText;

	@SerializedName("product_slug")
	private String productSlug;

	@SerializedName("cashback_description")
	private Object cashbackDescription;

	@SerializedName("own_funds_not_partner_atm_additional_amount")
	private int ownFundsNotPartnerAtmAdditionalAmount;

	@SerializedName("omp_timeout_penalty_description")
	private Object ompTimeoutPenaltyDescription;

	@SerializedName("contact_phone")
	private String contactPhone;

	@SerializedName("not_partner_atm_description")
	private Object notPartnerAtmDescription;

	@SerializedName("grace_period_description")
	private String gracePeriodDescription;

	@SerializedName("maintenance_first_year_fixed_price")
	private int maintenanceFirstYearFixedPrice;

	@SerializedName("omp_description")
	private String ompDescription;

	@SerializedName("partner_atm_description")
	private Object partnerAtmDescription;

	@SerializedName("income_proof_amount")
	private int incomeProofAmount;

	@SerializedName("transfer_own_card_own_money_commission_percent")
	private double transferOwnCardOwnMoneyCommissionPercent;

	@SerializedName("for_clients_only")
	private boolean forClientsOnly;

	@SerializedName("transfer_world_loan_money_commission_percent")
	private double transferWorldLoanMoneyCommissionPercent;

	@SerializedName("cities_only")
	private Object citiesOnly;

	@SerializedName("transfer_own_card_commission_additional_amount")
	private int transferOwnCardCommissionAdditionalAmount;

	@SerializedName("own_funds_partner_atm_min_amount")
	private int ownFundsPartnerAtmMinAmount;

	@SerializedName("card_re_issue_amount")
	private int cardReIssueAmount;

	@SerializedName("transfer_world_commission_additional_amount")
	private int transferWorldCommissionAdditionalAmount;

	@SerializedName("transfer_not_own_bank_loan_money_commission_percent")
	private double transferNotOwnBankLoanMoneyCommissionPercent;

	@SerializedName("transfer_not_own_bank_description")
	private String transferNotOwnBankDescription;

	@SerializedName("no_payment_penalty_description")
	private String noPaymentPenaltyDescription;

	@SerializedName("foreign_atm_description")
	private Object foreignAtmDescription;

	@SerializedName("slug")
	private String slug;

	@SerializedName("own_funds_foreign_atm_min_amount")
	private int ownFundsForeignAtmMinAmount;

	@SerializedName("transfer_own_bank_own_money_commission_percent")
	private double transferOwnBankOwnMoneyCommissionPercent;

	@SerializedName("other_penalty_description")
	private Object otherPenaltyDescription;

	@SerializedName("card_create_price_once")
	private int cardCreatePriceOnce;

	@SerializedName("payed_status")
	private Object payedStatus;

	@SerializedName("transfer_own_bank_commission_additional_amount")
	private int transferOwnBankCommissionAdditionalAmount;

	@SerializedName("cashbox_own_bank_description")
	private Object cashboxOwnBankDescription;

	@SerializedName("withdrawal_additional_conditions_description")
	private String withdrawalAdditionalConditionsDescription;

	@SerializedName("partner_atm_commission_percent")
	private double partnerAtmCommissionPercent;

	@SerializedName("own_funds_own_atm_commission_percent")
	private double ownFundsOwnAtmCommissionPercent;

	@SerializedName("maintenance_other_year_fixed_price")
	private int maintenanceOtherYearFixedPrice;

	@SerializedName("is_in_catalog")
	private boolean isInCatalog;

	public boolean getIsInCatalog() {
		return isInCatalog;
	}

	public void setIsInCatalog(boolean isInCatalog) {
		this.isInCatalog = isInCatalog;
	}

	@SerializedName("product_name")
	private String productName;

	@SerializedName("own_atm_commission_percent")
	private double ownAtmCommissionPercent;

	@SerializedName("employment_term")
	private int employmentTerm;

	@SerializedName("own_atm_additional_amount")
	private int ownAtmAdditionalAmount;

	@SerializedName("loan_limit_text")
	private Object loanLimitText;

	@SerializedName("wizard_form_type")
	private String wizardFormType;

	@SerializedName("loan_rate_privilege")
	private double loanRatePrivilege;

	@SerializedName("own_funds_foreign_atm_commission_percent")
	private double ownFundsForeignAtmCommissionPercent;

	@SerializedName("cashback_limit_description")
	private Object cashbackLimitDescription;

	@SerializedName("obtain_conditions_type")
	private List<String> obtainConditionsType;

	@SerializedName("min_monthly_income")
	private int minMonthlyIncome;

	@SerializedName("employment_type")
	private List<String> employmentType;

	@SerializedName("org_priority")
	private Object orgPriority;

	@SerializedName("shop_payment_commission_amount")
	private double shopPaymentCommissionAmount;

	@SerializedName("video")
	private Object video;

	@SerializedName("title")
	private String title;

	@SerializedName("card_image")
	private String cardImage;

	@SerializedName("cities_except")
	private Object citiesExcept;

	@SerializedName("unauthorized_overdraft_penalty_percent")
	private double unauthorizedOverdraftPenaltyPercent;

	@SerializedName("own_funds_cashbox_own_bank_description")
	private Object ownFundsCashboxOwnBankDescription;

	@SerializedName("omp_min")
	private int ompMin;

	@SerializedName("unauthorized_overdraft_penalty_description")
	private String unauthorizedOverdraftPenaltyDescription;

	@SerializedName("transfer_world_commission_min_amount")
	private int transferWorldCommissionMinAmount;

	@SerializedName("no_payment_penalty_amount")
	private int noPaymentPenaltyAmount;

	@SerializedName("maintenance_other_year_percent_price")
	private int maintenanceOtherYearPercentPrice;

	@SerializedName("balance_request_online_amount")
	private int balanceRequestOnlineAmount;

	@SerializedName("transfer_not_own_bank_own_money_commission_percent")
	private double transferNotOwnBankOwnMoneyCommissionPercent;

	@SerializedName("own_funds_own_atm_description")
	private Object ownFundsOwnAtmDescription;

	@SerializedName("preparation_time")
	private PreparationTime preparationTime;

	@SerializedName("loan_close_form_description")
	private String loanCloseFormDescription;

	@SerializedName("class")
	private List<String> jsonMemberClass;

	@SerializedName("percent_on_balance")
	private double percentOnBalance;

	@SerializedName("loan_rate_standard")
	private double loanRateStandard;

	@SerializedName("not_partner_atm_commission_percent")
	private double notPartnerAtmCommissionPercent;

	@SerializedName("delivery")
	private boolean delivery;

	@SerializedName("multi_currency")
	private List<String> multiCurrency;

	@SerializedName("loan_limit_number")
	private LoanLimitNumber loanLimitNumber;

	@SerializedName("grace_period_begin_day")
	private int gracePeriodBeginDay;

	@SerializedName("foreign_atm_currency")
	private String foreignAtmCurrency;

	@SerializedName("balance_request_description")
	private Object balanceRequestDescription;

	@SerializedName("exchange_commission_percent")
	private int exchangeCommissionPercent;

	@SerializedName("own_funds_foreign_atm_description")
	private Object ownFundsForeignAtmDescription;

	@SerializedName("own_funds_cashbox_own_bank_commission_percent")
	private double ownFundsCashboxOwnBankCommissionPercent;

	@SerializedName("technology")
	private List<String> technology;

	@SerializedName("maintenance_first_year_percent_price")
	private int maintenanceFirstYearPercentPrice;

	@SerializedName("cashback")
	private boolean cashback;

	@SerializedName("special")
	private boolean special;

	@SerializedName("own_funds_foreign_atm_currency")
	private String ownFundsForeignAtmCurrency;

	@SerializedName("product_type")
	private int productType;

	@SerializedName("grace_period_days_limit")
	private GracePeriodDaysLimit gracePeriodDaysLimit;

	@SerializedName("transfer_world_description")
	private String transferWorldDescription;

	@SerializedName("omp_timeout_penalty_amount")
	private int ompTimeoutPenaltyAmount;

	@SerializedName("transfer_own_card_description")
	private Object transferOwnCardDescription;

	@SerializedName("hide_callback_block")
	private boolean hideCallbackBlock;

	@SerializedName("card_image_full")
	private CardImageFull cardImageFull;

	@SerializedName("is_ppc_product")
	private boolean isPpcProduct;

	@SerializedName("calc_formulas")
	private List<Object> calcFormulas;

	@SerializedName("partner_atm_min_amount")
	private int partnerAtmMinAmount;

	@SerializedName("consierge_service")
	private boolean consiergeService;

	@SerializedName("own_atm_min_amount")
	private int ownAtmMinAmount;

	@SerializedName("transfer_world_own_money_commission_percent")
	private double transferWorldOwnMoneyCommissionPercent;
}