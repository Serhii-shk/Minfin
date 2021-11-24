package com.minfin.Minfin.ui.pageobjects.currency.auction;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

public class SubscriptionSelectionPO {
    public SelenideElement checkbox = $x("//span[@class='CheckboxCheckmark']");
    public SelenideElement confirmButton = $x("//button[@class='Button offer-agreement-modal__confirm primary']");
    public SelenideElement subscriptionTypeProButton = $x("(//button[@class='Button TypeCard__Footer__ChooseButton outlined'])[2]");

    public SubscriptionSelectionPO clickCheckbox(){
        step("when click checkbox", () -> checkbox.click());
        return this;
    }

    public SubscriptionSelectionPO clickConfirmButton(){
        step("when click confirm button", () -> confirmButton.click());
        return this;
    }

    public PaymentForSubscriptionPO clickSubscriptionTypeProButton(){
        step("click subscription type pro button", () -> subscriptionTypeProButton.click());
        return new PaymentForSubscriptionPO();
    }

}
