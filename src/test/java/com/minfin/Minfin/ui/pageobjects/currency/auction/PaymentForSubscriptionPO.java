package com.minfin.Minfin.ui.pageobjects.currency.auction;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class PaymentForSubscriptionPO {
    public SelenideElement term3MonthButton = $x("//div[@class='SubscriptionTypeCard SubscriptionTypeCard--Chosen']");
    public SelenideElement checkoutButton = $x("//button[@class='Button ChooseSubscriptionType__ServicesBlock__Submit__Button outlined']");
    public SelenideElement payOnPortmoneButton = $x("//button[@id='paymentButton']");

    public PaymentForSubscriptionPO clickTerm3MonthButton() {
        step("When click term 3 month button", () -> term3MonthButton.click());
        return this;
    }

    public PaymentForSubscriptionPO clickSubmitPaymentButton() {
        step("When click submit button", () -> checkoutButton.click());
        return this;
    }

    public PortmonePO clickPayOnPortmone() {
        step("When click pay button", () -> payOnPortmoneButton.click());
        return new PortmonePO();
    }

}
