package com.minfin.Minfin.pageobjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

public class LoginPO {

    public SelenideElement loginInput = $(".mfm-auth--input");
    public SelenideElement passwordInput = $("[name='Password']");
    public SelenideElement loginButton = $(".mfm-auth--submit-btn");
    public SelenideElement registerButton = $(".mfm-auth--footer [onclick*='/register']");
    public SelenideElement modalAuthOrRegistration = $x("//div[@class='styles__ModalAuthWrapper-sc-1phpxpj-32 gRUelK']");


    public void login(String login, String password) {
        step("when login " + login + password
                , ()-> {
                    loginInput.sendKeys(login);
                    passwordInput.sendKeys(password);
                    loginButton.click();
                });
    }



    public RegisterPO clickRegisterButton() {
        step("when click register button ", () -> registerButton.click());
        return new RegisterPO();
    }
}
