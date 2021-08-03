package com.minfin.Minfin.ui.pageobjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class HeaderPO {
    public SelenideElement authButton = $(".js-toggle-auth , .minfin-profile-widget");

    public LoginPO clickAuthButton() {
        step("when click auth button ", ()-> authButton.click());
        return new LoginPO();
    }
}
