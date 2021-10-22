package com.minfin.Minfin.ui.pageobjects.currency.auction;

import com.codeborne.selenide.AuthenticationType;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.minfin.Minfin.ui.pageobjects.HeaderPO;
import com.minfin.Minfin.ui.pageobjects.LoginPO;
import com.minfin.Minfin.ui.test.TestBase;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

public class CurrencyPO {

    public SelenideElement nawBarAll = $x("//button[@id='navigation-undefined']");
    public SelenideElement firstCard = $x("(//button[@class='Card'])[1]");
    public SelenideElement authButton = $x("//div[@class='js-toggle-auth']");
    public SelenideElement registrButton = $(".mfm-auth--screen .mfm-auth--footer-btn");
    String cardId = "[id='%s']";
    //    String baseUrl = "/currency/auction-stage/";
    String baseUrl = "/currency/auction-%s/";

    public LoginPO clickLoginButton() {
        step("when click auth button", () -> authButton.click());
        return new LoginPO();
    }

    public CurrencyPO selectNawBarAll() {
        step("when select naw bar all ", () -> nawBarAll.click());
        return this;
    }


    public CurrencyPO openAs(String login, String password) {
        step("when open as " + login + password
                , () -> {
                    this.open();
                    new HeaderPO().clickAuthButton().login(login, password);

                });
        return this;

    }

    public CurrencyPO open() {
        step("when open ", () -> {
            Selenide.open(String.format(baseUrl, TestBase.getEnv()), AuthenticationType.BASIC, "tester", "qO5pI8fD1wN4qZ3w");
        });
        return this;
    }

    public ExchangeCardPO selectCardById(String id) {
        step("when select card by id "
                + id, () -> $(String.format(cardId, id)).shouldBe(Condition.visible, Duration.ofSeconds(10)).click());
        return new ExchangeCardPO();
    }

}
