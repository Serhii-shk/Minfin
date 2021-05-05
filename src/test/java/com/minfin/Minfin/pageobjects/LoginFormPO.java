package com.minfin.Minfin.pageobjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class LoginFormPO {
    public SelenideElement loginButton = $("[class='mfm-auth--submit-btn login-form-submit-button']");
    public SelenideElement loginField = $x("//form[@action='//minfin.com.ua/login/']//input[@name='Login']");
    public SelenideElement passwordField = $x("//div[@class='mfm-auth--screen']//input[@type='password']");

    String login = "kider73274@netjook.com";
    String password = "123qweQWE";
    public void login(String login, String password ) {
        open("https://minfin.com.ua/currency/auction-review/");
        MainPagePO mainPage = new MainPagePO();
        mainPage.authButton.click();
        loginButton.should(visible);
    }

}
