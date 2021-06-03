package com.minfin.Minfin.pageobjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class HeaderPO {
    public SelenideElement authButton = $(".js-toggle-auth , .minfin-profile-widget");

    public LoginPO clickAuthButton() {
        authButton.click();
        return new LoginPO();
    }
}
