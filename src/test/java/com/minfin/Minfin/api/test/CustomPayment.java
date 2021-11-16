package com.minfin.Minfin.api.test;

import com.minfin.Minfin.api.generation.UserGenerator;
import com.minfin.Minfin.api.model.common.AdminProfile;
import com.minfin.Minfin.api.model.common.UserProfile;
import com.minfin.Minfin.api.model.minfin.api.auth.auction.AuctionResponse;
import com.minfin.Minfin.api.model.minfin.api.user.register.RegisterRequest;
import com.minfin.Minfin.api.model.va.api.auth.changeProfileType.ChangeProfileTypeRequest;
import com.minfin.Minfin.api.model.va.api.auth.minfinLogin.MinfinLoginRequest;
import com.minfin.Minfin.api.model.va.api.auth.minfinLogin.MinfinLoginResponse;
import com.minfin.Minfin.api.model.va.api.auth.userInfo.UserInfoResponse;
import com.minfin.Minfin.api.model.va.api.notification.body.SendNotificationBody;
import com.minfin.Minfin.api.model.va.api.notification.response.SendNotificationResponse;
import com.minfin.Minfin.api.model.va.api.payment.PaymentRequestFormResponse;
import com.minfin.Minfin.api.model.va.api.payment.body.PaymentBody;
import com.minfin.Minfin.api.model.va.api.payment.paymentRequestFormTwoLinks.body.PaymentRequestFormTwoLinksBody;
import com.minfin.Minfin.api.model.va.api.payment.paymentRequestFormTwoLinks.response.PaymentRequestFormTwoLinksResponse;
import com.minfin.Minfin.api.model.va.api.payment.response.PaymentResponse;
import com.minfin.Minfin.api.services.minfin.api.auth.auction.AuctionService;
import com.minfin.Minfin.api.services.minfin.api.ib.partner.auth.AuthService;
import com.minfin.Minfin.api.services.minfin.api.user.register.RegisterService;
import com.minfin.Minfin.api.services.va.api.auth.changeProfileType.ChangeProfileTypeService;
import com.minfin.Minfin.api.services.va.api.auth.minfinLogin.MinfinLoginService;
import com.minfin.Minfin.api.services.va.api.auth.usesrInfo.UserInfoService;
import com.minfin.Minfin.api.services.va.api.notification.SendNotificationService;
import com.minfin.Minfin.api.services.va.api.payment.PaymentRequestFormService;
import com.minfin.Minfin.api.services.va.api.payment.PaymentRequestFormTwoLinksService;
import com.minfin.Minfin.api.services.va.api.payment.PaymentService;
import com.minfin.Minfin.api.steps.Steps;
import com.minfin.Minfin.utils.StringUtils;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

import static org.assertj.core.api.BDDAssertions.then;

public class CustomPayment {
    final String isoTime;

    {
        DateTimeFormatter ISO_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        isoTime = LocalDateTime.now().plusMonths(1).format(ISO_FORMATTER);
    }

    @Test
    @Issue("CA-813")
    @TmsLink("CA-A-40")
    @DisplayName("Создание платежа с одной оплатой для юзера от админа")
    @Tag("Api")
    @Tag("CurrencyAuction")
    @Tag("CustomPayment")
    void creationOfPaymentByAdminWithOnePay200() {
        UserProfile exchanger = new UserGenerator()
                .createRandomExchanger();

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
                .createRandomExchanger();

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
                .createRandomExchanger();

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
        String email = "test_" + StringUtils.randomAlphabeticString(5) + "@test.test";
        String phoneNumber = "38000" + ThreadLocalRandom.current().nextLong(9100000L, 9109999L);

        String password = "123qweQWE";

        RegisterRequest registerRequest = RegisterRequest.builder()
                .email(email)
                .login("secene10test")
                .password(password)
                .privacy(true)
                .rules(true)
                .check(2)
                .firstName("secene1856")
                .phone(phoneNumber)
                .build();
        then(new RegisterService().postRegister(registerRequest).code())
                .isEqualTo(200);
        then(new AuthService().postAuth(email, password).code())
                .isEqualTo(200);

        Response<AuctionResponse> auction = new AuctionService().getAuction();
        then(auction.code())
                .isEqualTo(200);

        ChangeProfileTypeRequest typeRequest = ChangeProfileTypeRequest.builder().type("exchanger").build();
        String accessToken = auction.body().getAccessToken();
        then(new ChangeProfileTypeService().postChangeProfileType(accessToken, typeRequest).code())
                .isEqualTo(200);

        Response<UserInfoResponse> userInfo = new UserInfoService().getUserInfo(accessToken);
        then(userInfo.code())
                .isEqualTo(200);

        AdminProfile adminAuth = new Steps()
                .loginAsAdmin();

        PaymentBody paymentBody = PaymentBody.builder()
                .serviceProductId("5efdb5b6dda04383b8f03570")
                .activeAt(isoTime)
                .countItems(1)
                .amount(0)
                .payByLink(true)
                .paymentExpiresDays(3)
                .paymentCount(2)
                .build();

        Response<PaymentResponse> paymentResponse = new PaymentService()
                .postPayment(
                        userInfo.body().getProfileId(),
                        adminAuth.getAccessToken(),
                        paymentBody);
        then(paymentResponse.code())
                .isEqualTo(200);

    }


    @Test
    @Issue("CA-813")
    @TmsLink("CA-A-55")
    @DisplayName("Отправка двух ссылок в уведомлении пользователю по электронной почте и/или телефону")
    @Tag("Api")
    @Tag("CurrencyAuction")
    @Tag("CustomPayment")
    void sendingTwoLinksNotificationToUserByEmailOrPhone200() {
        String email = "test_" + StringUtils.randomAlphabeticString(5) + "@test.test";
        String phoneNumber = "38000" + ThreadLocalRandom.current().nextLong(9100000L, 9109999L);

        String password = "123qweQWE";

        RegisterRequest registerRequest = RegisterRequest.builder()
                .email(email)
                .login("secene10test")
                .password(password)
                .privacy(true)
                .rules(true)
                .check(2)
                .firstName("secene1856")
                .phone(phoneNumber)
                .build();
        then(new RegisterService().postRegister(registerRequest).code())
                .isEqualTo(200);
        then(new AuthService().postAuth(email, password).code())
                .isEqualTo(200);

        Response<AuctionResponse> auction = new AuctionService().getAuction();
        then(auction.code())
                .isEqualTo(200);

        ChangeProfileTypeRequest typeRequest = ChangeProfileTypeRequest.builder().type("exchanger").build();
        String accessToken = auction.body().getAccessToken();
        then(new ChangeProfileTypeService().postChangeProfileType(accessToken, typeRequest).code())
                .isEqualTo(200);

        Response<UserInfoResponse> userInfo = new UserInfoService().getUserInfo(accessToken);
        then(userInfo.code())
                .isEqualTo(200);

        AdminProfile adminAuth = new Steps()
                .loginAsAdmin();

        PaymentBody paymentBody = PaymentBody.builder()
                .serviceProductId("5efdb5b6dda04383b8f03570")
                .activeAt(isoTime)
                .countItems(1)
                .amount(0)
                .payByLink(true)
                .paymentExpiresDays(3)
                .paymentCount(2)
                .build();

        Response<PaymentResponse> paymentResponse = new PaymentService()
                .postPayment(
                        userInfo.body().getProfileId(),
                        adminAuth.getAccessToken(),
                        paymentBody);
        then(paymentResponse.code())
                .isEqualTo(200);

        SendNotificationBody sendNotificationBody = SendNotificationBody.builder()
                .email("s.shkurenko@treeum.net")
                .phone("380979979468")
                .build();

        Response<SendNotificationResponse> sendNotificationResponse = new SendNotificationService()
                .postSendNotification(
                        userInfo.body().getProfileId(),
                        adminAuth.getAccessToken(),
                        sendNotificationBody);
        then(sendNotificationResponse.code())
                .isEqualTo(200);

    }


    @Test
    @Issue("CA-813")
    @TmsLink("CA-A-58")
    @DisplayName("Перенаправление пользователя на страницу платежной формы по двум ссылкам")
    @Tag("Api")
    @Tag("CurrencyAuction")
    @Tag("CustomPayment")
    void redirectingUserToTwoPaymentFormPage200() {
        String email = "test_" + StringUtils.randomAlphabeticString(5) + "@test.test";
        String phoneNumber = "38000" + ThreadLocalRandom.current().nextLong(9100000L, 9109999L);

        String password = "123qweQWE";

        RegisterRequest registerRequest = RegisterRequest.builder()
                .email(email)
                .login("secene10test")
                .password(password)
                .privacy(true)
                .rules(true)
                .check(2)
                .firstName("secene1856")
                .phone(phoneNumber)
                .build();
        then(new RegisterService().postRegister(registerRequest).code())
                .isEqualTo(200);
        then(new AuthService().postAuth(email, password).code())
                .isEqualTo(200);

        Response<AuctionResponse> auction = new AuctionService().getAuction();
        then(auction.code())
                .isEqualTo(200);

        ChangeProfileTypeRequest typeRequest = ChangeProfileTypeRequest.builder().type("exchanger").build();
        String accessToken = auction.body().getAccessToken();
        then(new ChangeProfileTypeService().postChangeProfileType(accessToken, typeRequest).code())
                .isEqualTo(200);

        Response<UserInfoResponse> userInfo = new UserInfoService().getUserInfo(accessToken);
        then(userInfo.code())
                .isEqualTo(200);

        AdminProfile adminAuth = new Steps()
                .loginAsAdmin();

        PaymentBody paymentBody = PaymentBody.builder()
                .serviceProductId("5efdb5b6dda04383b8f03570")
                .activeAt(isoTime)
                .countItems(1)
                .amount(0)
                .payByLink(true)
                .paymentExpiresDays(3)
                .paymentCount(2)
                .build();

        Response<PaymentResponse> paymentResponse = new PaymentService()
                .postPayment(
                        userInfo.body().getProfileId(),
                        adminAuth.getAccessToken(),
                        paymentBody);
        then(paymentResponse.code())
                .isEqualTo(200);

        SendNotificationBody sendNotificationBody = SendNotificationBody.builder()
                .email("s.shkurenko@treeum.net")
                .phone("380979979468")
                .build();

        Response<SendNotificationResponse> sendNotificationResponse = new SendNotificationService()
                .postSendNotification(
                        userInfo.body().getProfileId(),
                        adminAuth.getAccessToken(),
                        sendNotificationBody);
        then(sendNotificationResponse.code())
                .isEqualTo(200);

        String paymentId = paymentResponse.body().getPayment().getId();
        PaymentRequestFormTwoLinksBody paymentRequestFormTwoLinksBody = PaymentRequestFormTwoLinksBody.builder()
                .partId(0)
                .build();

        Response<PaymentRequestFormTwoLinksResponse> paymentRequestFormTwoLinksResponse = new PaymentRequestFormTwoLinksService()
                .postPaymentRequestFormTwoLinks(paymentId,paymentRequestFormTwoLinksBody);
        then(paymentRequestFormTwoLinksResponse.code())
                .isEqualTo(200);

        paymentResponse.body().getPayment().getId();
        paymentRequestFormTwoLinksBody = PaymentRequestFormTwoLinksBody.builder()
                .partId(1)
                .build();

        paymentRequestFormTwoLinksResponse = new PaymentRequestFormTwoLinksService()
                .postPaymentRequestFormTwoLinks(paymentId,paymentRequestFormTwoLinksBody);
        then(paymentRequestFormTwoLinksResponse.code())
                .isEqualTo(200);

    }
}












