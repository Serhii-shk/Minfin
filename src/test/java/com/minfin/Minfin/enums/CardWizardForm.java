package com.minfin.Minfin.enums;

public enum CardWizardForm {
    BANK_SHORT_ORDER("short-lead","[data-wizardform='short-lead'] [data-gtm-ea='order-button']"),
    BANK_AUTH_ORDER("auth-order-card","[data-wizardform='auth-order-card'] [data-gtm-ea='order-button']"),
    BANK_ORDER_CARD("order-card", "[data-wizardform='order-card']");

    private final String name;
    private final String cardButtonSelector;

    CardWizardForm(String name, String cardButtonSelector) {
        this.name = name;
        this.cardButtonSelector = cardButtonSelector;
    }

    public String getName() {
        return name;
    }

    public String getCardButtonSelector() {
        return cardButtonSelector;
    }
}
