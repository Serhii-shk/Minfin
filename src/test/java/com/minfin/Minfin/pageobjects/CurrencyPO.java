package com.minfin.Minfin.pageobjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CurrencyPO {

   public SelenideElement nawBarAll = $x("//button[@id='navigation-undefined']");
   public SelenideElement card = $x("//button[@data-gtm-ea='undefined-5f0e43bd66bf9b665803abac']");

}
