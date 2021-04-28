package com.minfin.Minfin.pageobjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPagePO {

    public SelenideElement loginInput = $(".mfm-auth--input");
    public SelenideElement passwordInput = $("[name='Password']");
    public SelenideElement loginButton = $(".mfm-auth--submit-btn");

    public void login(String login, String password) {
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
}
