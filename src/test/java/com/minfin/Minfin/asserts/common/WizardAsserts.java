package com.minfin.Minfin.asserts.common;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

public class WizardAsserts {

    public WizardAsserts() {
    }

    public WizardAsserts proveTheOffer() {
        step("Then title contains: 'Заявка'", () ->
                $x("//h3[contains(.,'аявка')]").shouldBe(Condition.visible)
                        .shouldBe(Condition.visible));
        return this;
    }
}
