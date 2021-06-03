package com.minfin.Minfin.test.ui;

import com.minfin.Minfin.asserts.currency.auction.LoginPageAssert;
import com.minfin.Minfin.pageobjects.HeaderPO;
import com.minfin.Minfin.test.TestBase;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class Header extends TestBase {

    @Test
    public void loginForm() {
        open("https://minfin.com.ua/ua/");
        new HeaderPO().clickAuthButton();

        new LoginPageAssert()
                .loginButtonShouldBeVisible()
                .passwordInputShouldBeVisible()
                .loginInputShouldBeVisible();
    }

}
