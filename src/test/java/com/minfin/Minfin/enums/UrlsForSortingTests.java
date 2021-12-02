package com.minfin.Minfin.enums;

public enum UrlsForSortingTests {
    NO_WITHDRAWAL_FEE ("no-withdrawal-fee/"),
    NO_INQUIRIES ("no-inquiries/"),
    BAD_CREDIT_HISTORY ("bad-credit-history/"),
    GRACE_PERIOD ("grace-period/"),
    DELIVERY ("delivery/"),
    EIGHTEEN_YEARS ("18-years/"),
    MOMENTARY ("momentary/"),
    CURRENCY_CARD ("currency-cards/"),
    VIRTUAL ("virtual/"),
    VIRTUAL_DEBIT ("?virtual=true"),
    PAY_WIRE ("pay-wire/"),
    CHILDREN ("children/"),
    CHILDREN_DEBIT ("?children=true"),
    CASHBACK ("cashback/"),
    CASHBACK_DEBIT ("?cashback=true"),
    CARDS_CREDIT ("credit/"),
    CARDS_DEBIT ("debit/");
    
    private final String linkForSortingType;
    
    UrlsForSortingTests(String linkForSortingType) {
        this.linkForSortingType = linkForSortingType;
    }
    
    public String getLinkForSortingType() {
        return linkForSortingType;
    }
}
