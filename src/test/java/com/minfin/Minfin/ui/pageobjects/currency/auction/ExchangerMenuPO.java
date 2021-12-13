package com.minfin.Minfin.ui.pageobjects.currency.auction;

import com.codeborne.selenide.SelenideElement;
import com.minfin.Minfin.ui.pageobjects.IBaseUrl;

import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

public class ExchangerMenuPO implements IBaseUrl {

    @Override
    public String getUrl() {
        return "office";
    }

//    public SelenideElement accountType = $x("//span[@class='Typography proInfo body1 align']");
    private static final SelenideElement ADD_APPLICATION = $x("//a[@class='CreateApplicationLink']");
    private static final SelenideElement GO_TO_PAY_BUTTON = $x("(//div/button[@type='button'])[1]");

    public AddExchangerPO clickAddApplication() {
        step("When click add application", () -> ADD_APPLICATION.click());
        return new AddExchangerPO();
    }

    public PaymentForSubscriptionPO clickGoToPayButton() {
        step("When click go to pay button", () -> GO_TO_PAY_BUTTON.click());
        return new PaymentForSubscriptionPO();
    }
}
