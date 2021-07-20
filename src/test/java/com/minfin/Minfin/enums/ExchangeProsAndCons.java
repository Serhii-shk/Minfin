package com.minfin.Minfin.enums;

public enum ExchangeProsAndCons {

    ERRORS("", "В момент обмена были совершены ошибки", "[data-id='neg_errors']"),
    POS_NO_ERRORS("", "Превосходное обслуживание", "[data-id='pos_no_errors']"),
    FRAUD("", "Мошенничество/обман", "[data-id='neg_fraud']"),
    NO_AGREEMENTS("", "Не соблюдены договоренности", "[data-id='neg_no_agreements']"),
    UNSAFE("", "Было небезопасно", "[data-id='neg_unsafe']"),
    NO_REQUIRED_AMOUNT("", "В обменнике не было необходимой суммы", "[data-id='neg_no_required_amount']"),
    NOT_FOUND("", "Не смог быстро найти обменник", "[data-id='neg_found']");

    private String uaName;
    private String ruName;
    private String selector;

    ExchangeProsAndCons(String uaName, String ruName, String selector) {

        this.uaName = uaName;
        this.ruName = ruName;
        this.selector = selector;
    }

    public String getUaName() {
        return uaName;
    }

    public String getRuName() {
        return ruName;
    }

    public String getSelector() {
        return selector;
    }
}
