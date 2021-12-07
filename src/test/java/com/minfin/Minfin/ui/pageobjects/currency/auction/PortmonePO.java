package com.minfin.Minfin.ui.pageobjects.currency.auction;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

public class PortmonePO {

    private final SelenideElement PAY_CARD_INPUT = $("#single_portmone_pay_card");
    private final SelenideElement PAY_EXP_DATE_INPUT = $("#single_portmone_pay_exp_date");
    private final SelenideElement PAY_CVV_INPUT = $("#single_portmone_pay_cvv2");
    private final SelenideElement SEND_PAYMENT_BUTTON = $("[data-action='cardPaymentInvoice']");
    private final SelenideElement CLOSE_OFFER_MODAL = $x("(//div[@class='pg-flex pg-flex__center pg-flex__j-center'])[2]");
    String visaCard = "4444333322221111";
    String cardDate = "1231";
    String cvvCard = "123";

    public ProMenuPO makePortmonePayment() {
        step("When make portmone payment", () ->
        {
            switchTo().innerFrame("portmonepaymentframe");
            PAY_CARD_INPUT.setValue(visaCard);
            PAY_EXP_DATE_INPUT.setValue(cardDate);
            PAY_CVV_INPUT.setValue(cvvCard);
            SEND_PAYMENT_BUTTON.click();
            CLOSE_OFFER_MODAL.click();
            switchTo().defaultContent();
        });
        return new ProMenuPO();
    }


}
