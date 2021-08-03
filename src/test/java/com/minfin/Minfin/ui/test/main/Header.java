package com.minfin.Minfin.ui.test.main;

import com.minfin.Minfin.ui.asserts.LoginAssert;
import com.minfin.Minfin.ui.pageobjects.HeaderPO;
import com.minfin.Minfin.ui.test.TestBase;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class Header extends TestBase {

    @Test
    public void loginForm() {
        open("https://minfin.com.ua/ua/");
        new HeaderPO().clickAuthButton();

        new LoginAssert()
                .loginButtonShouldBeVisible()
                .passwordInputShouldBeVisible()
                .loginInputShouldBeVisible();
    }

}
