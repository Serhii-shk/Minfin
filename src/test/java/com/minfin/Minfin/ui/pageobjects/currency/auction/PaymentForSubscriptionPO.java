package com.minfin.Minfin.ui.pageobjects.currency.auction;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

public class PaymentForSubscriptionPO {
    public SelenideElement term3MonthButton = $x("//div[@class='SubscriptionTypeCard SubscriptionTypeCard--Chosen']");
    public SelenideElement checkoutButton = $x("//button[@class='Button ChooseSubscriptionType__ServicesBlock__Submit__Button outlined']");

    public PaymentForSubscriptionPO clickTerm3MonthButton(){
        step("click term 3 month button", () -> term3MonthButton.click());
        return this;
    }

    public PaymentForSubscriptionPO clickCheckoutButton() {
        step("click checkout button", () -> checkoutButton.click());
        return this;
    }
}
