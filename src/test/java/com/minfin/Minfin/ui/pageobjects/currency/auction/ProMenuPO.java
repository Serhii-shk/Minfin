package com.minfin.Minfin.ui.pageobjects.currency.auction;

import com.codeborne.selenide.SelenideElement;
import com.minfin.Minfin.ui.pageobjects.IBaseUrl;

import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

public class ProMenuPO implements IBaseUrl {
    @Override
    public String getUrl() {
        return "my/";
    }

    private static final SelenideElement ACCOUNT_TYPE = $x("//span[@class='Typography proInfo body1 align']");


}
