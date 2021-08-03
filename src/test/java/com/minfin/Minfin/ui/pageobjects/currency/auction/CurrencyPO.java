package com.minfin.Minfin.ui.pageobjects.currency.auction;

import com.codeborne.selenide.*;
import com.minfin.Minfin.ui.pageobjects.HeaderPO;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

public class CurrencyPO {

    public SelenideElement nawBarAll = $x("//button[@id='navigation-undefined']");
    public SelenideElement firstCard = $x("(//button[@class='Card'])[1]");
    String cardId = "[data-gtm-ea='%s']";
    String baseUrl = "/currency/auction-stage/";

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
        step("when open "
                , () -> Selenide.open(baseUrl, AuthenticationType.BASIC, "tester", "qO5pI8fD1wN4qZ3w"));
        return this;
    }


    public ExchangeCardPO selectCardById(String id) {
        step("when select card by id "
                + id, () -> $(String.format(cardId, id)).shouldBe(Condition.visible, Duration.ofSeconds(10)).click());
        return new ExchangeCardPO();
    }

}
