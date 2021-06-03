package com.minfin.Minfin.asserts.currency.auction;

import com.codeborne.selenide.Condition;
import com.minfin.Minfin.pageobjects.LoginPO;

public class LoginPageAssert {

    private final LoginPO loginPO = new LoginPO();

    public LoginPageAssert loginButtonShouldBeVisible() {
        loginPO.loginButton.shouldBe(Condition.visible);
        return this;
    }

    public LoginPageAssert passwordInputShouldBeVisible() {
        loginPO.passwordInput.shouldBe(Condition.visible);
        return this;
    }

    public LoginPageAssert loginInputShouldBeVisible() {
        loginPO.loginInput.shouldBe(Condition.visible);
        return this;
    }
}
