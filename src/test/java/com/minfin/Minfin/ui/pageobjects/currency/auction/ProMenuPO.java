package com.minfin.Minfin.ui.pageobjects.currency.auction;

import com.codeborne.selenide.SelenideElement;
import com.minfin.Minfin.ui.pageobjects.IBaseUrl;
import static com.codeborne.selenide.Selenide.$x;

public class ProMenuPO implements IBaseUrl {
    @Override
    public String getUrl() {
        return "my/";
    }

    public static SelenideElement getAccountType() {
        return ACCOUNT_TYPE;
    }

    private static final SelenideElement ACCOUNT_TYPE = $x("//span[@class='Typography proInfo body1 align']");


}
