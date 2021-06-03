package com.minfin.Minfin.test.ui;

import com.minfin.Minfin.pageobjects.HeaderPO;
import com.minfin.Minfin.pageobjects.currency.auction.CurrencyPO;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class User {

    @Disabled //todo
    @Test
    void currencyAuctionCreateUser(){
        new CurrencyPO().open();
        new HeaderPO().clickAuthButton();
    }
}
