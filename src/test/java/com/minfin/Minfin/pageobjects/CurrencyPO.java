package com.minfin.Minfin.pageobjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CurrencyPO {

   public SelenideElement nawBarAll = $x("//button[@id='navigation-undefined']");
   public SelenideElement firstCard = $x("//button[@data-gtm-ea='undefined-5f0e43bd66bf9b665803abac']");

   public CurrencyPO selectNawBarAll() {
      nawBarAll.click();
      return this;
   }
   public CurrencyPO selectFirstCard() {
      firstCard.click();
      return this;
   }

}
