package com.minfin.Minfin.pageobjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPagePO {
    public SelenideElement authButton = $x("//div[@class='js-toggle-auth']");

    public LoginPagePO clickAuthButton(){
        authButton.click();
        return new LoginPagePO();
    }
}
