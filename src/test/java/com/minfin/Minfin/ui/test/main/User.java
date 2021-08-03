package com.minfin.Minfin.ui.test.main;

import com.minfin.Minfin.ui.pageobjects.HeaderPO;
import com.minfin.Minfin.ui.pageobjects.currency.auction.CurrencyPO;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class User {

    @Disabled //todo
    @Test
    void currencyAuctionCreateUser(){
        new CurrencyPO().open();
        new HeaderPO().clickAuthButton();
    }


}
