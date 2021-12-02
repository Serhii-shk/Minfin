package com.minfin.Minfin.enums;

public enum PurposeOfUse {
    MONEY_BEFORE_PAYCHECK("Money before paycheck", "[data-state='button-target-untilSalary']"),
    FOR_TREATMENT("For treatment", "[data-state='button-target-cure']"),
    BUY_CAR("Buy a car", "[data-state='button-target-usedCar']"),
    FOR_BUSINESS("For business", "[data-state='button-target-business']"),
    PURCHASE_OR_REPAIR("Purchase or repair", "[data-state='button-target-technics']"),
    LOAN_REPAYMENT("Repayment of the next loan", "[data-state='button-target-otherCredit']"),
    MONEY_SECURED_BY_CAR("Money secured by car", "[data-state='button-target-humanDeposit']"),
    OTHER("Another", "[data-state='button-target-other']");


    private final String name;
    private final String selector;

    PurposeOfUse(String name, String selector) {
        this.selector = selector;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getSelector() {
        return selector;
    }
}
