package com.minfin.Minfin.pageobjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginFormPO {
    public SelenideElement loginButton = $("[class='mfm-auth--submit-btn login-form-submit-button']");

}
