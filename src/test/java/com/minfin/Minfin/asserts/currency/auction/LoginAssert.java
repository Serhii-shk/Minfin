package com.minfin.Minfin.asserts.currency.auction;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.minfin.Minfin.pageobjects.LoginPO;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;

public class LoginAssert {

    private final LoginPO loginPO = new LoginPO();

    public LoginAssert loginButtonShouldBeVisible() {
        loginPO.loginButton.shouldBe(Condition.visible);
        return this;
    }

    public LoginAssert passwordInputShouldBeVisible() {
        loginPO.passwordInput.shouldBe(Condition.visible);
        return this;
    }

    public LoginAssert loginInputShouldBeVisible() {
        loginPO.loginInput.shouldBe(Condition.visible);
        return this;
    }

    public LoginAssert currentUrlContainsBaseLoginUrl() {
        Assertions.assertThat(Selenide.Wait()
                .withTimeout(Duration.ofSeconds(5))
                .until(urlContains("https://minfin.com.ua/login"))
        ).isTrue();
        return this;
    }

}
