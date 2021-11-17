package com.minfin.Minfin.api.test;

import com.minfin.Minfin.api.generation.UserGenerator;
import com.minfin.Minfin.api.model.common.AdminProfile;
import com.minfin.Minfin.api.model.common.UserProfile;
import com.minfin.Minfin.api.steps.Steps;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;

public class CustomPayment {

    @Test
    @Issue("CA-813")
    @TmsLink("CA-A-40")
    @DisplayName("Создание платежа с одной оплатой для юзера от админа")
    @Tag("Api")
    @Tag("CurrencyAuction")
    @Tag("CustomPayment")
    void creationOfPaymentByAdminWithOnePay200() {
        UserProfile exchanger = new UserGenerator()
                .createPureRandomExchanger();

        Steps steps = new Steps();

        AdminProfile adminAuth = steps
                .loginAsAdmin();

        steps
            .creatingPaymentToAdminForUser(exchanger, adminAuth);

    }

    @Test
    @Issue("CA-813")
    @TmsLink("CA-A-41")
    @DisplayName("Отправка уведомления пользователю по электронной почте и/или телефону")
    @Tag("Api")
    @Tag("CurrencyAuction")
    @Tag("CustomPayment")
    void sendingNotificationToUserByEmailOrPhone200() {

        UserProfile exchanger = new UserGenerator()
                .createPureRandomExchanger();

        Steps steps = new Steps();

        AdminProfile adminAuth = steps
                .loginAsAdmin();

        steps
                .creatingPaymentToAdminForUser(exchanger, adminAuth);

        steps
                .sendNotification(exchanger, adminAuth);

    }

    @Test
    @Issue("CA-813")
    @TmsLink("CA-A-47")
    @DisplayName("Перенаправление пользователя на страницу платежной формы")
    @Tag("Api")
    @Tag("CurrencyAuction")
    @Tag("CustomPayment")
    void redirectingUserToPaymentFormPage200() {

        UserProfile exchanger = new UserGenerator()
                .createPureRandomExchanger();

        Steps steps = new Steps();

        AdminProfile adminAuth = steps
                .loginAsAdmin();

        steps
                .creatingPaymentToAdminForUser(exchanger, adminAuth);

        steps
                .sendNotification(exchanger, adminAuth);

        steps
                .paymentForm(exchanger);

    }


    @Test
    @Issue("CA-813")
    @TmsLink("CA-A-53")
    @DisplayName("Создание платежа с двумя оплатами для юзера от админа")
    @Tag("Api")
    @Tag("CurrencyAuction")
    @Tag("CustomPayment")
    void creationOfPaymentByAdminWithTwoPay200() {
        UserProfile exchanger = new UserGenerator()
                .createPureRandomExchanger();

        Steps steps = new Steps();

        AdminProfile adminAuth = steps
                .loginAsAdmin();
        steps
                .creatingPaymentToAdminForUserTwoPays(exchanger, adminAuth);

    }


    @Test
    @Issue("CA-813")
    @TmsLink("CA-A-55")
    @DisplayName("Отправка двух ссылок в уведомлении пользователю по электронной почте и/или телефону")
    @Tag("Api")
    @Tag("CurrencyAuction")
    @Tag("CustomPayment")
    void sendingTwoLinksNotificationToUserByEmailOrPhone200() {
        UserProfile exchanger = new UserGenerator()
                .createPureRandomExchanger();

        Steps steps = new Steps();

        AdminProfile adminAuth = steps
                .loginAsAdmin();
        steps
                .creatingPaymentToAdminForUserTwoPays(exchanger, adminAuth);

        steps
                .sendNotificationTwoPays(exchanger,adminAuth);


    }


    @Test
    @Issue("CA-813")
    @TmsLink("CA-A-58")
    @DisplayName("Перенаправление пользователя на страницу платежной формы по двум ссылкам")
    @Tag("Api")
    @Tag("CurrencyAuction")
    @Tag("CustomPayment")
    void redirectingUserToTwoPaymentFormPage200() {


        UserProfile exchanger = new UserGenerator()
                .createPureRandomExchanger();

        Steps steps = new Steps();

        AdminProfile adminAuth = steps
                .loginAsAdmin();
        steps
                .creatingPaymentToAdminForUserTwoPays(exchanger, adminAuth);

        steps
                .sendNotificationTwoPays(exchanger,adminAuth);
        steps.
                paymentFormTwoPays(exchanger);


    }
}












