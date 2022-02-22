package com.minfin.Minfin.ui.test.auction;

import com.minfin.Minfin.api.generation.UserGenerator;
import com.minfin.Minfin.api.model.common.UserProfile;
import com.minfin.Minfin.ui.asserts.ExchangerMenuAssert;
import com.minfin.Minfin.ui.asserts.ProMenuAssert;
import com.minfin.Minfin.ui.pageobjects.currency.auction.CurrencyPO;
import com.minfin.Minfin.ui.test.TestBase;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты UI")
public class BuySubscription extends TestBase {
    CurrencyPO whenCurrencyPO = new CurrencyPO();
    UserProfile userWithoutSubsc = new UserGenerator().createUserWithoutSubscription();
    ProMenuAssert thenProMenuAssert = new ProMenuAssert();
    ExchangerMenuAssert thenExchangerMenuAssert = new ExchangerMenuAssert();


    @Test
//    @RepeatedTest(10)
    @Issue("CA-563")
    @TmsLink("CA-A-63")
    @DisplayName("Покупка подписки User Pro")
    @Tag("UI")
    @Tag("CurrencyAuction")
    @Tag("BuySubscription")
    public void buySubscriptionUserPro(){
        whenCurrencyPO
                .openAs(userWithoutSubsc.getEmail(), userWithoutSubsc.getPassword())
                .clickChoosePlan()
                .clickSubscriptionCheckbox()
                .clickConfirmButton()
                .clickSubscriptionTypeProButton()
                .clickTerm3MonthButton()
                .clickSubmitPaymentButton()
                .clickPayOnPortmone()
                .makePortmonePaymentProSubscription();
        thenProMenuAssert
                .checkTypePRO();
    }

    @Test
//    @RepeatedTest(10)
    @Issue("CA-563")
    @TmsLink("CA-A-64")
    @DisplayName("Покупка подписки Exchanger")
    @Tag("UI")
    @Tag("CurrencyAuction")
    @Tag("BuySubscription")
    public void buySubscriptionExchanger(){
        whenCurrencyPO
                .openAs(userWithoutSubsc.getEmail(), userWithoutSubsc.getPassword())
                .clickChoosePlan()
                .clickSubscriptionCheckbox()
                .clickConfirmButton()
                .clickSubscriptionTypeExchangerButton()
                .clickAddApplication()
                .clickCityDropdown()
                .selectKiev()
                .clickAddress()
                .setAddress()
                .clickAddressList()
                .setPhone()
                .setSaturdayDayOff()
                .setSundayDayOff()
                .setDamagedBanknotes()
                .setVideoSurveillance()
                .setRecountRoom()
                .setExchangerDescriptionInput()
                .clickNextStepButton()
                .setSmsCodeInput()
                .clickConfirmButton()
                .clickAddCurrencyButton()
                .clickCurrencyDropdown()
                .setCurrencyEur()
                .clickBuySellDropdown()
                .setCurrencyBuy()
                .setExactAmountCheckbox()
                .setBuyRate()
                .setSumBuy()
                .clickCreateExchangerButton()
                .setLicenseInput()
                .sendToCheckButton()
                .clickAmountExchangerDropdown()
                .clickExchangePoints2List()
                .clickTerm3MonthButton()
                .clickSubmitPaymentButton()
                .clickPayOnPortmone()
                .makePortmonePaymentExchangerSubscription();
        thenExchangerMenuAssert
                .checkTypeExch(); //checking

    }


}














