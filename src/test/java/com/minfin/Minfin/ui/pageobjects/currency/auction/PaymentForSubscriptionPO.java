package com.minfin.Minfin.ui.pageobjects.currency.auction;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

public class PaymentForSubscriptionPO {
    public SelenideElement term3MonthButton = $x("//div[@class='SubscriptionTypeCard SubscriptionTypeCard--Chosen']");
    public SelenideElement checkoutButton = $x("//button[@class='Button ChooseSubscriptionType__ServicesBlock__Submit__Button outlined']");
    public SelenideElement payButtonOfModal = $x("//button[@id='paymentButton']");
    public SelenideElement cardField = $x("//input[@id='single_portmone_pay_card']");
    public SelenideElement date = $x("//input[@id='single_portmone_pay_exp_date']");
    public SelenideElement cvv = $x("//input[@id='single_portmone_pay_cvv2']");
    public SelenideElement payOfPortmoneButton = $x("(//button[@class='pg-btn pg-btn__red action'])[1]");
    String visaCard = "4444333322221111";
    String cardDate = "1231";
    String cvvCard = "123";

    public PaymentForSubscriptionPO clickTerm3MonthButton(){
        step("click term 3 month button", () -> term3MonthButton.click());
        return this;
    }

    public PaymentForSubscriptionPO clickCheckoutButton() {
        step("click checkout button", () -> checkoutButton.click());
        return this;
    }

    public PaymentForSubscriptionPO clickPayButtonOfModal() {
        step("click pay button of modal", () -> payButtonOfModal.click());
        return this;
    }

    public PaymentForSubscriptionPO inputCardToField() {
        step("input card to field", () -> cardField.setValue(visaCard));
        return this;
    }

    public PaymentForSubscriptionPO inputDate() {
        step("input date", () -> date.setValue(cardDate));
        return this;
    }

    public PaymentForSubscriptionPO inputCvv() {
        step("input cvv", () -> cvv.setValue(cvvCard));
        return this;
    }

    public PaymentForSubscriptionPO clickPayOfPortmoneButton() {
        step("click pay of portmone button", () -> payOfPortmoneButton.click());
        return this;
    }
}
