package com.minfin.Minfin.ui.asserts;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.minfin.Minfin.ui.pageobjects.IBaseUrl;
import com.minfin.Minfin.ui.pageobjects.currency.auction.ProMenuPO;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

public class ProMenuAssert implements IBaseUrl {
    @Override
    public String getUrl() {
        return "my/";
    }

    public ProMenuPO checkTypePRO(){
        step("When check type Pro", () -> ProMenuPO.getAccountType().shouldBe(Condition.exactText("Тип вашего аккаунта: PRO"), Duration.ofMinutes(10)));
        return new ProMenuPO();
    }


}
