package com.minfin.Minfin.ui.asserts;

import com.codeborne.selenide.Condition;
import com.minfin.Minfin.ui.pageobjects.currency.auction.ProMenuPO;

import java.time.Duration;

public class ProMenuAssert {
    ProMenuPO proMenuPO = new ProMenuPO();

    public ProMenuPO checkTypePRO(){
        proMenuPO.accountType.shouldBe(Condition.exactText("Тип вашего аккаунта: PRO"), Duration.ofMinutes(10));
        return new ProMenuPO();
    }
}
