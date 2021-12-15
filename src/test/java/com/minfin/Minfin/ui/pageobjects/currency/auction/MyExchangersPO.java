package com.minfin.Minfin.ui.pageobjects.currency.auction;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

public class MyExchangersPO {
    private static final SelenideElement MY_EXCHANGERS_BUTTON = $x("//button[@data-gtm-ea='my-branches-top']");
    private static final SelenideElement MY_FIRST_EXCHANGER = $x("(//div[@class='exchanger-card__content'])[1]");

    public MyExchangersPO clickOnMyExchangersButton() {
        step("when click on my exchangers button ",()-> MY_EXCHANGERS_BUTTON.click());
        return new MyExchangersPO();
    }

    public ExchangeCardPO clickMyFirstExchanger() {
        step("when click my first exchanger ", ()-> MY_FIRST_EXCHANGER.click());
        return new ExchangeCardPO();
    }

}
