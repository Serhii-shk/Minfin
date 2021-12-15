package com.minfin.Minfin.ui.pageobjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class LoginPO {

    public static SelenideElement getLoginInput() {
        return LOGIN_INPUT;
    }
    private static final SelenideElement LOGIN_INPUT = $(".mfm-auth--input");

    public static SelenideElement getPasswordInput() {
        return PASSWORD_INPUT;
    }
    private static final SelenideElement PASSWORD_INPUT = $("[name='Password']");

    public static SelenideElement getLoginButton() {
        return LOGIN_BUTTON;
    }
    private static final SelenideElement LOGIN_BUTTON = $(".mfm-auth--submit-btn");

    private static final SelenideElement REGISTER_BUTTON = $(".mfm-auth--footer [onclick*='/register']");


    public void login(String login, String password) {
        step("when login " + login + password
                , ()-> {
                    LOGIN_INPUT.sendKeys(login);
                    PASSWORD_INPUT.sendKeys(password);
                    LOGIN_BUTTON.click();
                });
    }

    public RegisterPO clickRegisterButton() {
        step("when click register button ", () -> REGISTER_BUTTON.click());
        return new RegisterPO();
    }
}
