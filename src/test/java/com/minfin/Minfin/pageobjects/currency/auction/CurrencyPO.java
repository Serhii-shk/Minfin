package com.minfin.Minfin.pageobjects.currency.auction;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class CurrencyPO {

   public SelenideElement nawBarAll = $x("//button[@id='navigation-undefined']");
   public SelenideElement firstCard = $x("(//button[@class='Card'])[1]");

   public CurrencyPO selectNawBarAll() {
      nawBarAll.click();
      return this;
   }
   public ExchangeCardPO selectFirstCard() {
      firstCard.shouldBe(Condition.visible, Duration.ofSeconds(10)).click(ClickOptions.usingJavaScript());
      return new ExchangeCardPO();
   }

}
