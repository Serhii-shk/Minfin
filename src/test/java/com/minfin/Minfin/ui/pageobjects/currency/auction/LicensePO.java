package com.minfin.Minfin.ui.pageobjects.currency.auction;

import com.codeborne.selenide.SelenideElement;
import com.minfin.Minfin.ui.pageobjects.BasePO;
import com.minfin.Minfin.ui.pageobjects.IBaseUrl;
import lombok.SneakyThrows;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

public class LicensePO implements IBaseUrl {
    @Override
    public String getUrl() {
        return "office/add/license/";
    }

    private static final SelenideElement LICENSE_INPUT = $x("//input[@type='text']");
    private static final SelenideElement GO_PAYMENT_BUTTON = $x("//button[@id='licenseSubmitBtn']");




    public LicensePO clickGoPaymentButton() {
        step("When click go payment button", () -> GO_PAYMENT_BUTTON.click());
        return this;
    }

    @SneakyThrows
    public LicensePO setLicenseInput() {
        step("When set license input", () -> LICENSE_INPUT.setValue(BasePO.getLicensesNumber()));
        Thread.sleep (1000);
        return this;
    }


    public ExchangerMenuPO sendToCheckButton() {
        step("When click go payment button", () -> GO_PAYMENT_BUTTON.click());
        return new ExchangerMenuPO();
    }
}
