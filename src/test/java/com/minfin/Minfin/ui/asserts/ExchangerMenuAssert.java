package com.minfin.Minfin.ui.asserts;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.minfin.Minfin.ui.pageobjects.IBaseUrl;
import com.minfin.Minfin.ui.pageobjects.currency.auction.ProMenuPO;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

public class ExchangerMenuAssert implements IBaseUrl {
    @Override
    public String getUrl() {
        return "office/";
    }

    private static final SelenideElement ACCOUNT_TYPE = $x("//p[@class='header-message']");

    public ProMenuPO checkTypeExch(){
        step("When check type Pro", () -> ACCOUNT_TYPE.shouldHave(text("Подписка будет продлена. Снятие 12250 ₴ произойдет"), Duration.ofMinutes(10)));


                //.shouldBe(Condition.exactText("Подписка будет продлена. Снятие 12250 ₴ произойдет"), Duration.ofMinutes(10)));
        return new ProMenuPO();
    }

}
