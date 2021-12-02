package com.minfin.Minfin.model.api.products.v1.data.debitCards;

import java.util.List;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.minfin.Minfin.service.EmptyStringAsNullTypeAdapter;
import lombok.Data;

@Data
public class DebitCardsDataItem {

	@SerializedName("maintenance_other_year_fixed_price_multicurrency")
	private MaintenanceOtherYearFixedPriceMulticurrency maintenanceOtherYearFixedPriceMulticurrency;

	@SerializedName("additional_card_other_options_description")
	private String additionalCardOtherOptionsDescription;

	@SerializedName("card_class_visa")
	private List<Object> cardClassVisa;

	@SerializedName("transfer_world_multicurrency")
	private TransferWorldMulticurrency transferWorldMulticurrency;

	@SerializedName("sms_notify_comment")
	private String smsNotifyComment;

	@SerializedName("location_id")
	private List<Integer> locationId;

	@SerializedName("percent_on_balance_usd")
	private String percentOnBalanceUsd;

	@SerializedName("currency_list")
	private List<String> currencyList;

	@SerializedName("product_id")
	private int productId;

	@SerializedName("cashbox_own_bank_min_amount_multicurrency")
	private CashboxOwnBankMinAmountMulticurrency cashboxOwnBankMinAmountMulticurrency;

	@SerializedName("documents_required")
	private List<String> documentsRequired;

	@SerializedName("transfer_own_card_additional_amount_multicurrency")
	private TransferOwnCardAdditionalAmountMulticurrency transferOwnCardAdditionalAmountMulticurrency;

	@SerializedName("id")
	private int id;

	@SerializedName("minfin_type_priority")
	@JsonAdapter(EmptyStringAsNullTypeAdapter.class)
	private Boolean minfinTypePriority;

	@SerializedName("card_class_mc")
	private List<String> cardClassMc;

	@SerializedName("own_atm_additional_amount_multicurrency")
	private OwnAtmAdditionalAmountMulticurrency ownAtmAdditionalAmountMulticurrency;

	@SerializedName("partner_atm_min_amount_multicurrency")
	private PartnerAtmMinAmountMulticurrency partnerAtmMinAmountMulticurrency;

	@SerializedName("nationality_required")
	private boolean nationalityRequired;

	@SerializedName("not_partner_atm_additional_amount_multicurrency")
	private NotPartnerAtmAdditionalAmountMulticurrency notPartnerAtmAdditionalAmountMulticurrency;

	@SerializedName("pin_code_change_description")
	private String pinCodeChangeDescription;

	@SerializedName("active")
	private boolean active;

	@SerializedName("percent_on_balance_amount_usd")
	private double percentOnBalanceAmountUsd;

	@SerializedName("transfer_world_min_amount_multicurrency")
	private TransferWorldMinAmountMulticurrency transferWorldMinAmountMulticurrency;

	@SerializedName("balance_request_not_own_atm_amount_multicurrency")
	private BalanceRequestNotOwnAtmAmountMulticurrency balanceRequestNotOwnAtmAmountMulticurrency;

	@SerializedName("concierge_service")
	private boolean conciergeService;

	@SerializedName("transfer_own_bank_additional_amount_multicurrency")
	private TransferOwnBankAdditionalAmountMulticurrency transferOwnBankAdditionalAmountMulticurrency;

	@SerializedName("resident_required")
	private boolean residentRequired;

	@SerializedName("not_partner_atm_commission_percent_multicurrency")
	private NotPartnerAtmCommissionPercentMulticurrency notPartnerAtmCommissionPercentMulticurrency;

	@SerializedName("system")
	private List<String> system;

	@SerializedName("free_services_list")
	private Object freeServicesList;

	@SerializedName("vendor_id")
	private int vendorId;

	@SerializedName("percent_on_balance_uah")
	private String percentOnBalanceUah;

	@SerializedName("convert_commission")
	private double convertCommission;

	@SerializedName("transfer_own_bank_description")
	private String transferOwnBankDescription;

	@SerializedName("has_free_sms_notification")
	private boolean hasFreeSmsNotification;

	@SerializedName("online_order")
	private boolean onlineOrder;

	@SerializedName("partner_atm_commission_percent_multicurrency")
	private PartnerAtmCommissionPercentMulticurrency partnerAtmCommissionPercentMulticurrency;

	@SerializedName("transfer_not_own_bank_min_amount_multicurrency")
	private TransferNotOwnBankMinAmountMulticurrency transferNotOwnBankMinAmountMulticurrency;

	@SerializedName("type_priority")
	private Object typePriority;

	@SerializedName("own_atm_description")
	private String ownAtmDescription;

	@SerializedName("own_atm_commission_percent_multicurrency")
	private OwnAtmCommissionPercentMulticurrency ownAtmCommissionPercentMulticurrency;

	@SerializedName("personalisation")
	private List<String> personalisation;

	@SerializedName("travel_bonus_description")
	private Object travelBonusDescription;

	@SerializedName("free_maintenance_requirements_available")
	private boolean freeMaintenanceRequirementsAvailable;

	@SerializedName("additional_conditions_description")
	private String additionalConditionsDescription;

	@SerializedName("own_atm_min_amount_multicurrency")
	private OwnAtmMinAmountMulticurrency ownAtmMinAmountMulticurrency;

	@SerializedName("free_withdrawal_description")
	private Object freeWithdrawalDescription;

	@SerializedName("product_advantages")
	private List<Object> productAdvantages;

	@SerializedName("pin_code_change_amount")
	private int pinCodeChangeAmount;

	@SerializedName("tracking_url")
	private Object trackingUrl;

	@SerializedName("enrollment_description")
	private Object enrollmentDescription;

	@SerializedName("vendor_type")
	private int vendorType;

	@SerializedName("minfin_org_priority")
	@JsonAdapter(EmptyStringAsNullTypeAdapter.class)
	private Boolean minfinOrgPriority;

	@SerializedName("tariffs_url")
	private String tariffsUrl;

	@SerializedName("cashback_limit")
	private int cashbackLimit;

	@SerializedName("card_type")
	private String cardType;

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
	private List<String> advantages;

	@SerializedName("loyalty_program_description")
	private Object loyaltyProgramDescription;

	@SerializedName("validity")
	private int validity;

	@SerializedName("percent_on_balance_amount_uah")
	private double percentOnBalanceAmountUah;

	@SerializedName("page_url")
	private String pageUrl;

	@SerializedName("maintenance_first_year_fixed_price_multicurrency")
	private MaintenanceFirstYearFixedPriceMulticurrency maintenanceFirstYearFixedPriceMulticurrency;

	@SerializedName("card_issue_price_once_multicurrency")
	private CardIssuePriceOnceMulticurrency cardIssuePriceOnceMulticurrency;

	@SerializedName("product_slug")
	private String productSlug;

	@SerializedName("cashback_description")
	private Object cashbackDescription;

	@SerializedName("cashbox_own_bank_additional_amount_multicurrency")
	private CashboxOwnBankAdditionalAmountMulticurrency cashboxOwnBankAdditionalAmountMulticurrency;

	@SerializedName("contact_phone")
	private String contactPhone;

	@SerializedName("not_partner_atm_description")
	private String notPartnerAtmDescription;

	@SerializedName("partner_atm_description")
	private String partnerAtmDescription;

	@SerializedName("transfer_not_own_bank_multicurrency")
	private TransferNotOwnBankMulticurrency transferNotOwnBankMulticurrency;

	@SerializedName("minimal_age")
	private int minimalAge;

	@SerializedName("transfer_not_own_bank_additional_amount_multicurrency")
	private TransferNotOwnBankAdditionalAmountMulticurrency transferNotOwnBankAdditionalAmountMulticurrency;

	@SerializedName("transfer_not_own_bank_description")
	private String transferNotOwnBankDescription;

	@SerializedName("foreign_atm_min_amount_multicurrency")
	private ForeignAtmMinAmountMulticurrency foreignAtmMinAmountMulticurrency;

	@SerializedName("foreign_atm_description")
	private String foreignAtmDescription;

	@SerializedName("chat_support")
	private List<String> chatSupport;

	@SerializedName("free_withdrawal_available")
	private boolean freeWithdrawalAvailable;

	@SerializedName("slug")
	private String slug;

	@SerializedName("additional_card_issue_price_once_multicurrency")
	private AdditionalCardIssuePriceOnceMulticurrency additionalCardIssuePriceOnceMulticurrency;

	@SerializedName("only_for_existing_customers")
	private boolean onlyForExistingCustomers;

	@SerializedName("payed_status")
	private Object payedStatus;

	@SerializedName("cashbox_own_bank_description")
	private String cashboxOwnBankDescription;

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

	@SerializedName("transfer_own_card_min_amount_multicurrency")
	private TransferOwnCardMinAmountMulticurrency transferOwnCardMinAmountMulticurrency;

	@SerializedName("wizard_form_type")
	private Object wizardFormType;

	@SerializedName("cards_package_quantity")
	private int cardsPackageQuantity;

	@SerializedName("partner_atm_additional_amount_multicurrency")
	private PartnerAtmAdditionalAmountMulticurrency partnerAtmAdditionalAmountMulticurrency;

	@SerializedName("obtain_conditions_type")
	private List<String> obtainConditionsType;

	@SerializedName("card_reissue_other_case")
	private Object cardReissueOtherCase;

	@SerializedName("free_maintenance_requirements_description")
	private String freeMaintenanceRequirementsDescription;

	@SerializedName("transfer_world_additional_amount_multicurrency")
	private TransferWorldAdditionalAmountMulticurrency transferWorldAdditionalAmountMulticurrency;

	@SerializedName("org_priority")
	private Object orgPriority;

	@SerializedName("card_reissue_amount")
	private int cardReissueAmount;

	@SerializedName("card_image")
	private String cardImage;

	@SerializedName("title")
	private String title;

	@SerializedName("balance_request_own_atm_amount_multicurrency")
	private BalanceRequestOwnAtmAmountMulticurrency balanceRequestOwnAtmAmountMulticurrency;

	@SerializedName("transfer_own_bank_multicurrency")
	private TransferOwnBankMulticurrency transferOwnBankMulticurrency;

	@SerializedName("foreign_atm_additional_amount_multicurrency")
	private ForeignAtmAdditionalAmountMulticurrency foreignAtmAdditionalAmountMulticurrency;

	@SerializedName("video_url")
	private Object videoUrl;

	@SerializedName("not_partner_atm_min_amount_multicurrency")
	private NotPartnerAtmMinAmountMulticurrency notPartnerAtmMinAmountMulticurrency;

	@SerializedName("percent_on_balance_eur")
	private String percentOnBalanceEur;

	@SerializedName("preparation_time")
	private PreparationTime preparationTime;

	@SerializedName("transfer_own_bank_min_amount_multicurrency")
	private TransferOwnBankMinAmountMulticurrency transferOwnBankMinAmountMulticurrency;

	@SerializedName("transfer_own_card_multicurrency")
	private TransferOwnCardMulticurrency transferOwnCardMulticurrency;

	@SerializedName("delivery")
	private boolean delivery;

	@SerializedName("multi_currency")
	private boolean multiCurrency;

	@SerializedName("foreign_atm_commission_percent_multicurrency")
	private ForeignAtmCommissionPercentMulticurrency foreignAtmCommissionPercentMulticurrency;

	@SerializedName("foreign_atm_currency")
	private String foreignAtmCurrency;

	@SerializedName("balance_request_description")
	private String balanceRequestDescription;

	@SerializedName("percent_on_balance_amount_eur")
	private double percentOnBalanceAmountEur;

	@SerializedName("cashbox_own_bank_commission_percent_multicurrency")
	private CashboxOwnBankCommissionPercentMulticurrency cashboxOwnBankCommissionPercentMulticurrency;

	@SerializedName("card_provision")
	private String cardProvision;

	@SerializedName("card_issue_price_description")
	private String cardIssuePriceDescription;

	@SerializedName("technology")
	private List<String> technology;

	@SerializedName("hide_unauthorized_overdraft")
	private double hideUnauthorizedOverdraft;

	@SerializedName("cashback")
	private boolean cashback;

	@SerializedName("special")
	private boolean special;

	@SerializedName("product_type")
	private int productType;

	@SerializedName("transfer_world_description")
	private String transferWorldDescription;

	@SerializedName("cashback_max_interest")
	private double cashbackMaxInterest;

	@SerializedName("transfer_own_card_description")
	private String transferOwnCardDescription;

	@SerializedName("hide_callback_block")
	private boolean hideCallbackBlock;

	@SerializedName("card_image_full")
	private CardImageFull cardImageFull;

	@SerializedName("is_ppc_product")
	private boolean isPpcProduct;

	@SerializedName("calc_formulas")
	private List<Object> calcFormulas;

	@SerializedName("card_system_and_class")
	private String cardSystemAndClass;
}