package com.minfin.Minfin.test.ui;

import com.minfin.Minfin.pageobjects.LoginFormPO;
import com.minfin.Minfin.pageobjects.MainPagePO;
import com.minfin.Minfin.test.TestBase;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class MainPagePOTest extends TestBase {
    MainPagePO mainPage = new MainPagePO();
    LoginFormPO loginFormPO = new LoginFormPO();

    @Test
    public void search() {
        open("https://minfin.com.ua/ua/");
        mainPage.authButton.click();

        loginFormPO.loginButton.should(visible);
        //comment
    }

}
