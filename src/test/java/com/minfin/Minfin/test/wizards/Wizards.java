package com.minfin.Minfin.test.wizards;

import com.minfin.Minfin.asserts.common.WizardAsserts;
import com.minfin.Minfin.enums.CardWizardForm;
import com.minfin.Minfin.pageobjects.CardsPO;
import com.minfin.Minfin.ui.TestBase;
import org.junit.jupiter.api.Test;

import static com.minfin.Minfin.enums.City.KYIV;
import static com.minfin.Minfin.enums.Employment.ILLEGAL_WORK;
import static com.minfin.Minfin.enums.PurposeOfUse.MONEY_BEFORE_PAYCHECK;
import static com.minfin.Minfin.enums.Users.USER_1;

public class Wizards  extends TestBase {

    protected CardsPO cardsPO = new CardsPO();
    protected WizardAsserts wizardAsserts = new WizardAsserts();

    @Test
    void cardCatalogAuthOrder() {
        cardsPO
                .open()
                .clickOnCardButton(CardWizardForm.BANK_ORDER_CARD)
                .setSurname(USER_1.getSurname())
                .setFirstName(USER_1.getFirstName())
                .setMiddleName(USER_1.getMiddleName())
                .clickForward()
                .setPhone(USER_1.getPhone())
                .setEmail(USER_1.getEmail())
                .clickForward()
                .clickModalSubmit()
                .setCreditCardUsage(MONEY_BEFORE_PAYCHECK)
                .setEmploymentByButton(ILLEGAL_WORK)
                .setCityByButton(KYIV)
                .setDayOfBirthday(USER_1.getDayOfBirth())
                .setMonthOfBirthday(USER_1.getMonthOfBirth())
                .setYearOfBirthday(USER_1.getYearOfBirth())
                .clickForward()
                .setINNNumber(USER_1.getInn())
                .clickSendOffer()
                .waitForResultScreen();

        wizardAsserts.proveTheOffer();
    }
}
