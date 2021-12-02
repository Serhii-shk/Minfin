package com.minfin.Minfin.enums;

public enum CreditWizardForm {

    AUTH_ORDER_CREDIT("auth-order-credit","[data-wizardform='auth-order-credit']"),
    W14("w14","[data-wizardform='w14']"),
    SHORT_LEAD("short-lead","[data-wizardform='short-lead'][data-affiseurl]"),
    AMP_SHORT_LEAD("short-lead",".fua-product__center a[data-vars-ea='order-button'][role='button']"),
    PURE_REDIRECT("direct","[data-wizardform='direct']"),
    MONEYVEO("Moneyveo",".fua-mfo-main__btn [class$='fua-btn-primary']");

    private final String name;
    private final String cardButtonSelector;

    CreditWizardForm(String name, String cardButtonSelector) {
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
