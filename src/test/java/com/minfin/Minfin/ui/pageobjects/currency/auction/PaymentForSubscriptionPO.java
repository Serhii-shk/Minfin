package com.minfin.Minfin.ui.pageobjects.currency.auction;

import com.codeborne.selenide.SelenideElement;
import com.minfin.Minfin.ui.pageobjects.IBaseUrl;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class PaymentForSubscriptionPO implements IBaseUrl {
    @Override
    public String getUrl() {
        return "subscription-type/";
    }

    private static final SelenideElement TERM_3_MONTH_BUTTON = $x("(//div[@class='SubscriptionTypeCard'])[1]");
    private static final SelenideElement CHECKOUT_BUTTON = $x("//button[@class='Button ChooseSubscriptionType__ServicesBlock__Submit__Button outlined']");
    private static final SelenideElement PAY_ON_PORTMONE_BUTTON = $x("//button[@id='paymentButton']");
    private static final SelenideElement AMOUNT_EXCHANGER_DROPDOWN = $x("//div[@class='DropdownContent']");
    private static final SelenideElement EXCHANGE_POINTS_2_LIST = $x("(//div[@class='DropdownItemContainer Dropdown__Item'])[1]");

    public PaymentForSubscriptionPO clickTerm3MonthButton() {
        step("When click term 3 month button", () -> TERM_3_MONTH_BUTTON.click());
        return this;
    }

    public PaymentForSubscriptionPO clickSubmitPaymentButton() {
        step("When click submit button", () -> CHECKOUT_BUTTON.click());
        return this;
    }

    public PortmonePO clickPayOnPortmone() {
        step("When click pay button", () -> PAY_ON_PORTMONE_BUTTON.click());
        return new PortmonePO();
    }

    public PaymentForSubscriptionPO clickAmountExchangerDropdown() {
        step("When click amount exchanger dropdown", () -> AMOUNT_EXCHANGER_DROPDOWN.click());
        return this;
    }

    public PaymentForSubscriptionPO clickExchangePoints2List() {
        step("When click exchange points 2 list", () -> EXCHANGE_POINTS_2_LIST.click());
        return this;
    }


}


















