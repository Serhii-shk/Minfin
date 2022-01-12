package com.minfin.Minfin.ui.pageobjects.currency.auction;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

public class SubscriptionSelectionPO {
    public SelenideElement checkbox = $x("//span[@id='checkboxHover']");
    public SelenideElement confirmButton = $x("//button[@id='agreementModalBtn']");
    public SelenideElement subscriptionTypeProButton = $x("(//button[@id='chooseCardTypeBtn'])[2]");
    public SelenideElement subscriptionTypeExchangerButton = $x("(//button[@id='chooseCardTypeBtn'])[1]");

    public SubscriptionSelectionPO clickSubscriptionCheckbox(){
        step("When click subscription checkbox", () -> checkbox.click());
        return this;
    }

    public SubscriptionSelectionPO clickConfirmButton(){
        step("When click confirm button", () -> confirmButton.click());
        return this;
    }

    public PaymentForSubscriptionPO clickSubscriptionTypeProButton(){
        step("When click subscription type pro button", () -> subscriptionTypeProButton.click());
        return new PaymentForSubscriptionPO();
    }

    public ExchangerMenuPO clickSubscriptionTypeExchangerButton(){
        step("When click subscription type Exchanger button", () -> subscriptionTypeExchangerButton.click());
        return new ExchangerMenuPO();
    }

}
