package com.minfin.Minfin.pageobjects.currency.auction;

import com.codeborne.selenide.SelenideElement;
import com.minfin.Minfin.pageobjects.LoginPO;

import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

public class ModalAuthRegPO {
    public SelenideElement authRegButton = $x("//button[@class='styles__Button-sc-1phpxpj-34 fcurHU']");

    public LoginPO clickAuthRegButton() {
        step("when click auth reg button ", ()->authRegButton.click());
        return new LoginPO();
    }

}
