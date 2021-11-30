package com.minfin.Minfin.ui.pageobjects.currency.auction;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class PaymentForSubscriptionPO {
    public SelenideElement term3MonthButton = $x("//div[@class='SubscriptionTypeCard SubscriptionTypeCard--Chosen']");
    public SelenideElement checkoutButton = $x("//button[@class='Button ChooseSubscriptionType__ServicesBlock__Submit__Button outlined']");
    public SelenideElement payOnPortmoneButton = $x("//button[@id='paymentButton']");
    public SelenideElement cardField = $x("//input[@id='single_portmone_pay_card']");
    public SelenideElement date = $x("//input[@id='single_portmone_pay_exp_date']");
    public SelenideElement cvv = $x("//input[@id='single_portmone_pay_cvv2']");
    public SelenideElement payOfPortmoneButton = $x("(//button[@class='pg-btn pg-btn__red action'])[1]");
    String visaCard = "4444333322221111";
    String cardDate = "1231";
    String cvvCard = "123";
    private final SelenideElement PAY_CARD_INPUT = $("#single_portmone_pay_card");
    private final SelenideElement PAY_EXP_DATE_INPUT = $("#single_portmone_pay_exp_date");
    private final SelenideElement PAY_CVV_INPUT = $("#single_portmone_pay_cvv2");
    private final SelenideElement SEND_PAYMENT_BUTTON = $("[data-action='cardPaymentInvoice']");

    public PaymentForSubscriptionPO clickTerm3MonthButton() {
        step("click term 3 month button", () -> term3MonthButton.click());
        return this;
    }

    public PaymentForSubscriptionPO clickSubmitPaymentButton() {
        step("click submit button", () -> checkoutButton.click());
        return this;
    }

    public PaymentForSubscriptionPO clickPayOnPortmone() {
        step("click pay button", () -> payOnPortmoneButton.click());
        return this;//return PortmonePO
    }

    public PaymentForSubscriptionPO makePortmonePayment() {
        step("When send payment", () ->
        {
            switchTo().innerFrame("portmonepaymentframe");
            PAY_CARD_INPUT.setValue(visaCard);
            PAY_EXP_DATE_INPUT.setValue(cardDate);
            PAY_CVV_INPUT.setValue(cvvCard);
            SEND_PAYMENT_BUTTON.click();
            switchTo().defaultContent();
        });
        return this;
    }

    public PaymentForSubscriptionPO setCardNumber() {
        switchTo().frame("portmonepaymentframe");
        step("input card to field", () -> cardField.setValue(visaCard));
        return this;
    }

    public PaymentForSubscriptionPO setCardDate() {
        step("input date", () -> date.setValue(cardDate));
        return this;
    }

    public PaymentForSubscriptionPO setCvv() {
        step("input cvv", () -> cvv.setValue(cvvCard));
        return this;
    }

    public PaymentForSubscriptionPO clickPayOfPortmoneButton() {
        step("click pay of portmone button", () -> payOfPortmoneButton.click());
        return this;
    }
}
