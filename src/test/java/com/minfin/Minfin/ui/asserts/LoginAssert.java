package com.minfin.Minfin.ui.asserts;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.minfin.Minfin.ui.pageobjects.LoginPO;
import org.assertj.core.api.Assertions;

import java.time.Duration;

import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;

public class LoginAssert {

    public LoginAssert loginButtonShouldBeVisible() {
        step("When login button should be visible", () -> LoginPO.getLoginButton().shouldBe(Condition.visible));
        return this;
    }

    public LoginAssert passwordInputShouldBeVisible() {
        step("When password in put should be visible", () -> LoginPO.getPasswordInput().shouldBe(Condition.visible));
        return this;
    }

    public LoginAssert loginInputShouldBeVisible() {
        step("When login input should be visible", () -> LoginPO.getLoginInput().shouldBe(Condition.visible));
        return this;
    }

    public LoginAssert currentUrlContainsBaseLoginUrl() {
        step("When current url contains base login url", () -> Assertions.assertThat(Selenide.Wait()
                .withTimeout(Duration.ofSeconds(5))
                .until(urlContains("https://minfin.com.ua/login"))
        ).isTrue());
        return this;
    }


}
