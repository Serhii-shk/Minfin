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
    public SelenideElement addApplication = $x("//a[@class='CreateApplicationLink']");

    public AddExchangerPO clickAddApplication(){
        step("When click add application", () -> addApplication.click());
        return new AddExchangerPO();
    }
}
