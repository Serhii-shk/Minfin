package com.minfin.Minfin.ui.pageobjects.currency.auction;

import com.codeborne.selenide.SelenideElement;
import com.minfin.Minfin.ui.pageobjects.LoginPO;

import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

public class ModalAuthRegPO {
    private static final SelenideElement AUTH_REG_BUTTON = $x("//button[@id='loginReview']");

    public LoginPO clickAuthRegButton() {
        step("when click auth reg button ", ()-> AUTH_REG_BUTTON.click());
        return new LoginPO();
    }

}
