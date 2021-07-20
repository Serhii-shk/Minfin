package com.minfin.Minfin.pageobjects.currency.auction;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

public class MyExchangersPO {
    public SelenideElement myExchangersButton = $x("//button[@data-gtm-ea='my-branches-top']");
    public SelenideElement myFirstExchanger = $x("(//div[@class='exchanger-card__content'])[1]");

    public MyExchangersPO clickOnMyExchangersButton() {
        step("when click on my exchangers button ",()->myExchangersButton.click());
        return new MyExchangersPO();
    }

    public ExchangeCardPO clickMyFirstExchanger() {
        step("when click my first exchanger ", ()->myFirstExchanger.click());
        return new ExchangeCardPO();
    }

}
