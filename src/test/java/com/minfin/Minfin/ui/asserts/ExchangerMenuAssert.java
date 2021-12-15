package com.minfin.Minfin.ui.asserts;

import com.minfin.Minfin.ui.pageobjects.IBaseUrl;
import com.minfin.Minfin.ui.pageobjects.currency.auction.ExchangerMenuPO;
import com.minfin.Minfin.ui.pageobjects.currency.auction.ProMenuPO;
import java.time.Duration;
import static com.codeborne.selenide.Condition.text;
import static io.qameta.allure.Allure.step;

public class ExchangerMenuAssert implements IBaseUrl {
    @Override
    public String getUrl() {
        return "office/";
    }



    public ProMenuPO checkTypeExch(){
        step("When check type Pro", () -> ExchangerMenuPO.getAccountType().shouldHave(text("Подписка будет продлена. Снятие 12250 ₴ произойдет"), Duration.ofMinutes(10)));
        return new ProMenuPO();
    }

}
