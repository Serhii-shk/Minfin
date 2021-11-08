package com.minfin.Minfin.ui.pageobjects.currency.auction;

import com.codeborne.selenide.SelenideElement;
import com.minfin.Minfin.ui.pageobjects.LoginPO;

import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

public class ModalAuthRegPO {
    public SelenideElement authRegButton = $x("//button[@id='loginReview']");

    public LoginPO clickAuthRegButton() {
        step("when click auth reg button ", ()->authRegButton.click());
        return new LoginPO();
    }

}
