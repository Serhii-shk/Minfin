package com.minfin.Minfin.enums;

public enum RequiredAmountByButton {

    ONE_THOUSAND(1_000),
    THREE_THOUSANDS(3_000),
    FIVE_THOUSAND(5_000),
    TEN_THOUSANDS(10_000),
    TWENTY_THOUSANDS(20_000),
    FIFTY_THOUSANDS(50_000);

    private final int amount;

    RequiredAmountByButton(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
