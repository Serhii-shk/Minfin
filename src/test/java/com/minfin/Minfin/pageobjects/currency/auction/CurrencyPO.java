package com.minfin.Minfin.pageobjects.currency.auction;

import com.codeborne.selenide.*;
import com.minfin.Minfin.pageobjects.HeaderPO;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CurrencyPO {

    public SelenideElement nawBarAll = $x("//button[@id='navigation-undefined']");
    public SelenideElement firstCard = $x("(//button[@class='Card'])[1]");
    String cardId = "[data-gtm-ea='%s']";
    String baseUrl = "/currency/auction-review/";

    public CurrencyPO selectNawBarAll() {
        nawBarAll.click();
        return this;
    }

    public CurrencyPO openAs(String login, String password) {
        open();
        new HeaderPO().clickAuthButton().login(login, password);
        return this;
    }

    public CurrencyPO open() {
        Selenide.open(baseUrl, AuthenticationType.BASIC, "tester", "qO5pI8fD1wN4qZ3w");
        return this;
    }

    public ExchangeCardPO selectFirstCard() {
        firstCard.shouldBe(Condition.visible, Duration.ofSeconds(10)).click(ClickOptions.usingJavaScript());
        return new ExchangeCardPO();
    }

    public ExchangeCardPO selectCardById(String id) {
        $(String.format(cardId, id)).shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        return new ExchangeCardPO();
    }

}
