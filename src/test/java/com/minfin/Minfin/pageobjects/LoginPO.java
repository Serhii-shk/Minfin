package com.minfin.Minfin.pageobjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPO {

    public SelenideElement loginInput = $(".mfm-auth--input");
    public SelenideElement passwordInput = $("[name='Password']");
    public SelenideElement loginButton = $(".mfm-auth--submit-btn");
    public SelenideElement registerButton = $(".mfm-auth--footer [onclick*='/register']");

    public void login(String login, String password) {
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public RegisterPO clickRegisterButton(){
        registerButton.click();
        return new RegisterPO();
    }
}
