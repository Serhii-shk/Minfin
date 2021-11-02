package com.minfin.Minfin.api.test;

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
import com.minfin.Minfin.utils.StringUtils;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

public class CustomPayment {

    @Test
    @Issue("CA-813")
    @TmsLink("CA-A-40")
    @DisplayName("Создание платежа с одной оплатой для юзера от админа")
    @Tag("Api")
    @Tag("CurrencyAuction")
    @Tag("CustomPayment")
    void creationOfPaymentByAdminWithOnePay200() {
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
        assert new RegisterService().postRegister(registerRequest).code() == 200;

        assert new AuthService().postAuth(email, password).code() == 200;

        Response<AuctionResponse> auction = new AuctionService().getAuction();
        assert auction.code() == 200;

        ChangeProfileTypeRequest typeRequest = ChangeProfileTypeRequest.builder().type("exchanger").build();
        String accessToken = auction.body().getAccessToken();
        assert new ChangeProfileTypeService().postChangeProfileType(accessToken, typeRequest).code() == 200;

        Response<UserInfoResponse> userInfo = new UserInfoService().getUserInfo(accessToken);
        assert userInfo.code() == 200;


        MinfinLoginRequest minfinLoginRequest = MinfinLoginRequest.builder()
                .userId(870351)
                .firstName("testRVKtest")
                .lastName("testRVKtest")
                .accountType("register_user")
                .login("newusertest94@yopmail.com")
                .nickname("testRVKtest")
                .slug("null")
                .agree(true)
                .verified(false)
                .build();
        Response<MinfinLoginResponse> minfinLoginResponse = new MinfinLoginService().postMinfinLogin(minfinLoginRequest);
        assert minfinLoginResponse.code() == 200;

        LocalDateTime date = LocalDateTime.now();
        PaymentBody paymentBody = PaymentBody.builder()
                .serviceProductId("5efdb5b6dda04383b8f03570")
                .activeAt(String.valueOf(date.plusMonths(1)))
                .countItems(1)
                .amount(0)
                .payByLink(true)
                .paymentExpiresDays(3)
                .paymentCount(1)
                .build();

        Response<PaymentResponse> paymentResponse = new PaymentService()
                .postPayment(
                userInfo.body().getProfileId(),
                minfinLoginResponse.body().getAccessToken(),
                paymentBody);
        assert paymentResponse.code() == 200;

    }

    @Test
    @Issue("CA-813")
    @TmsLink("CA-A-41")
    @DisplayName("Отправка уведомления пользователю по электронной почте и/или телефону")
    @Tag("Api")
    @Tag("CurrencyAuction")
    @Tag("CustomPayment")
    void sendingNotificationToUserByEmailOrPhone200() {
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
        assert new RegisterService().postRegister(registerRequest).code() == 200;

        assert new AuthService().postAuth(email, password).code() == 200;

        Response<AuctionResponse> auction = new AuctionService().getAuction();
        assert auction.code() == 200;

        ChangeProfileTypeRequest typeRequest = ChangeProfileTypeRequest.builder().type("exchanger").build();
        String accessToken = auction.body().getAccessToken();
        assert new ChangeProfileTypeService().postChangeProfileType(accessToken, typeRequest).code() == 200;

        Response<UserInfoResponse> userInfo = new UserInfoService().getUserInfo(accessToken);
        assert userInfo.code() == 200;


        MinfinLoginRequest minfinLoginRequest = MinfinLoginRequest.builder()
                .userId(870351)
                .firstName("testRVKtest")
                .lastName("testRVKtest")
                .accountType("register_user")
                .login("newusertest94@yopmail.com")
                .nickname("testRVKtest")
                .slug("null")
                .agree(true)
                .verified(false)
                .build();
        Response<MinfinLoginResponse> minfinLoginResponse = new MinfinLoginService().postMinfinLogin(minfinLoginRequest);
        assert minfinLoginResponse.code() == 200;

        LocalDateTime date = LocalDateTime.now();
        PaymentBody paymentBody = PaymentBody.builder()
                .serviceProductId("5efdb5b6dda04383b8f03570")
                .activeAt(String.valueOf(date.plusMonths(1)))
                .countItems(1)
                .amount(0)
                .payByLink(true)
                .paymentExpiresDays(3)
                .paymentCount(1)
                .build();

        Response<PaymentResponse> paymentResponse = new PaymentService()
                .postPayment(
                        userInfo.body().getProfileId(),
                        minfinLoginResponse.body().getAccessToken(),
                        paymentBody);
        assert paymentResponse.code() == 200;


        SendNotificationBody sendNotificationBody = SendNotificationBody.builder()
                .email("s.shkurenko@treeum.net")
                .phone("380979979468")
                .build();

        Response<SendNotificationResponse> sendNotificationResponse = new SendNotificationService()
                .postSendNotification(
                        userInfo.body().getProfileId(),
                        minfinLoginResponse.body().getAccessToken(),
                        sendNotificationBody);
        assert sendNotificationResponse.code() == 200;


    }

    @Test
    @Issue("CA-813")
    @TmsLink("CA-A-47")
    @DisplayName("Перенаправление пользователя на страницу платежной формы")
    @Tag("Api")
    @Tag("CurrencyAuction")
    @Tag("CustomPayment")
    void redirectingUserToPaymentFormPage200() {
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
        assert new RegisterService().postRegister(registerRequest).code() == 200;

        assert new AuthService().postAuth(email, password).code() == 200;

        Response<AuctionResponse> auction = new AuctionService().getAuction();
        assert auction.code() == 200;

        ChangeProfileTypeRequest typeRequest = ChangeProfileTypeRequest.builder().type("exchanger").build();
        String accessToken = auction.body().getAccessToken();
        assert new ChangeProfileTypeService().postChangeProfileType(accessToken, typeRequest).code() == 200;

        Response<UserInfoResponse> userInfo = new UserInfoService().getUserInfo(accessToken);
        assert userInfo.code() == 200;


        MinfinLoginRequest minfinLoginRequest = MinfinLoginRequest.builder()
                .userId(870351)
                .firstName("testRVKtest")
                .lastName("testRVKtest")
                .accountType("register_user")
                .login("newusertest94@yopmail.com")
                .nickname("testRVKtest")
                .slug("null")
                .agree(true)
                .verified(false)
                .build();
        Response<MinfinLoginResponse> minfinLoginResponse = new MinfinLoginService().postMinfinLogin(minfinLoginRequest);
        assert minfinLoginResponse.code() == 200;

        LocalDateTime date = LocalDateTime.now();
        PaymentBody paymentBody = PaymentBody.builder()
                .serviceProductId("5efdb5b6dda04383b8f03570")
                .activeAt(String.valueOf(date.plusMonths(1)))
                .countItems(1)
                .amount(0)
                .payByLink(true)
                .paymentExpiresDays(3)
                .paymentCount(1)
                .build();

        Response<PaymentResponse> paymentResponse = new PaymentService()
                .postPayment(
                        userInfo.body().getProfileId(),
                        minfinLoginResponse.body().getAccessToken(),
                        paymentBody);
        assert paymentResponse.code() == 200;


        SendNotificationBody sendNotificationBody = SendNotificationBody.builder()
                .email("s.shkurenko@treeum.net")
                .phone("380979979468")
                .build();

        Response<SendNotificationResponse> sendNotificationResponse = new SendNotificationService()
                .postSendNotification(
                        userInfo.body().getProfileId(),
                        minfinLoginResponse.body().getAccessToken(),
                        sendNotificationBody);

        assert sendNotificationResponse.code() == 200;

        String paymentId = paymentResponse.body().getPayment().getId();
        Response<PaymentRequestFormResponse> paymentRequestFormResponse = new PaymentRequestFormService()
                .postPaymentRequestForm(paymentId);
        assert paymentRequestFormResponse.code() == 200;

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
        assert new RegisterService().postRegister(registerRequest).code() == 200;

        assert new AuthService().postAuth(email, password).code() == 200;

        Response<AuctionResponse> auction = new AuctionService().getAuction();
        assert auction.code() == 200;

        ChangeProfileTypeRequest typeRequest = ChangeProfileTypeRequest.builder().type("exchanger").build();
        String accessToken = auction.body().getAccessToken();
        assert new ChangeProfileTypeService().postChangeProfileType(accessToken, typeRequest).code() == 200;

        Response<UserInfoResponse> userInfo = new UserInfoService().getUserInfo(accessToken);
        assert userInfo.code() == 200;


        MinfinLoginRequest minfinLoginRequest = MinfinLoginRequest.builder()
                .userId(870351)
                .firstName("testRVKtest")
                .lastName("testRVKtest")
                .accountType("register_user")
                .login("newusertest94@yopmail.com")
                .nickname("testRVKtest")
                .slug("null")
                .agree(true)
                .verified(false)
                .build();
        Response<MinfinLoginResponse> minfinLoginResponse = new MinfinLoginService().postMinfinLogin(minfinLoginRequest);
        assert minfinLoginResponse.code() == 200;

        LocalDateTime date = LocalDateTime.now();
        PaymentBody paymentBody = PaymentBody.builder()
                .serviceProductId("5efdb5b6dda04383b8f03570")
                .activeAt(String.valueOf(date.plusMonths(1)))
                .countItems(1)
                .amount(0)
                .payByLink(true)
                .paymentExpiresDays(3)
                .paymentCount(2)
                .build();

        Response<PaymentResponse> paymentResponse = new PaymentService()
                .postPayment(
                        userInfo.body().getProfileId(),
                        minfinLoginResponse.body().getAccessToken(),
                        paymentBody);
        assert paymentResponse.code() == 200;

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
        assert new RegisterService().postRegister(registerRequest).code() == 200;

        assert new AuthService().postAuth(email, password).code() == 200;

        Response<AuctionResponse> auction = new AuctionService().getAuction();
        assert auction.code() == 200;

        ChangeProfileTypeRequest typeRequest = ChangeProfileTypeRequest.builder().type("exchanger").build();
        String accessToken = auction.body().getAccessToken();
        assert new ChangeProfileTypeService().postChangeProfileType(accessToken, typeRequest).code() == 200;

        Response<UserInfoResponse> userInfo = new UserInfoService().getUserInfo(accessToken);
        assert userInfo.code() == 200;


        MinfinLoginRequest minfinLoginRequest = MinfinLoginRequest.builder()
                .userId(870351)
                .firstName("testRVKtest")
                .lastName("testRVKtest")
                .accountType("register_user")
                .login("newusertest94@yopmail.com")
                .nickname("testRVKtest")
                .slug("null")
                .agree(true)
                .verified(false)
                .build();
        Response<MinfinLoginResponse> minfinLoginResponse = new MinfinLoginService().postMinfinLogin(minfinLoginRequest);
        assert minfinLoginResponse.code() == 200;

        LocalDateTime date = LocalDateTime.now();
        PaymentBody paymentBody = PaymentBody.builder()
                .serviceProductId("5efdb5b6dda04383b8f03570")
                .activeAt(String.valueOf(date.plusMonths(1)))
                .countItems(1)
                .amount(0)
                .payByLink(true)
                .paymentExpiresDays(3)
                .paymentCount(2)
                .build();

        Response<PaymentResponse> paymentResponse = new PaymentService()
                .postPayment(
                        userInfo.body().getProfileId(),
                        minfinLoginResponse.body().getAccessToken(),
                        paymentBody);
        assert paymentResponse.code() == 200;


        SendNotificationBody sendNotificationBody = SendNotificationBody.builder()
                .email("s.shkurenko@treeum.net")
                .phone("380979979468")
                .build();

        Response<SendNotificationResponse> sendNotificationResponse = new SendNotificationService()
                .postSendNotification(
                        userInfo.body().getProfileId(),
                        minfinLoginResponse.body().getAccessToken(),
                        sendNotificationBody);
        assert sendNotificationResponse.code() == 200;


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
        assert new RegisterService().postRegister(registerRequest).code() == 200;

        assert new AuthService().postAuth(email, password).code() == 200;

        Response<AuctionResponse> auction = new AuctionService().getAuction();
        assert auction.code() == 200;

        ChangeProfileTypeRequest typeRequest = ChangeProfileTypeRequest.builder().type("exchanger").build();
        String accessToken = auction.body().getAccessToken();
        assert new ChangeProfileTypeService().postChangeProfileType(accessToken, typeRequest).code() == 200;

        Response<UserInfoResponse> userInfo = new UserInfoService().getUserInfo(accessToken);
        assert userInfo.code() == 200;


        MinfinLoginRequest minfinLoginRequest = MinfinLoginRequest.builder()
                .userId(870351)
                .firstName("testRVKtest")
                .lastName("testRVKtest")
                .accountType("register_user")
                .login("newusertest94@yopmail.com")
                .nickname("testRVKtest")
                .slug("null")
                .agree(true)
                .verified(false)
                .build();
        Response<MinfinLoginResponse> minfinLoginResponse = new MinfinLoginService().postMinfinLogin(minfinLoginRequest);
        assert minfinLoginResponse.code() == 200;

        LocalDateTime date = LocalDateTime.now();
        PaymentBody paymentBody = PaymentBody.builder()
                .serviceProductId("5efdb5b6dda04383b8f03570")
                .activeAt(String.valueOf(date.plusMonths(1)))
                .countItems(1)
                .amount(0)
                .payByLink(true)
                .paymentExpiresDays(3)
                .paymentCount(2)
                .build();

        Response<PaymentResponse> paymentResponse = new PaymentService()
                .postPayment(
                        userInfo.body().getProfileId(),
                        minfinLoginResponse.body().getAccessToken(),
                        paymentBody);
        assert paymentResponse.code() == 200;


        SendNotificationBody sendNotificationBody = SendNotificationBody.builder()
                .email("s.shkurenko@treeum.net")
                .phone("380979979468")
                .build();

        Response<SendNotificationResponse> sendNotificationResponse = new SendNotificationService()
                .postSendNotification(
                        userInfo.body().getProfileId(),
                        minfinLoginResponse.body().getAccessToken(),
                        sendNotificationBody);

        assert sendNotificationResponse.code() == 200;

        String paymentId = paymentResponse.body().getPayment().getId();
        PaymentRequestFormTwoLinksBody paymentRequestFormTwoLinksBody = PaymentRequestFormTwoLinksBody.builder()
                .partId(0)
                .build();

        Response<PaymentRequestFormTwoLinksResponse> paymentRequestFormTwoLinksResponse = new PaymentRequestFormTwoLinksService()
                .postPaymentRequestFormTwoLinks(paymentId,paymentRequestFormTwoLinksBody);
        assert paymentRequestFormTwoLinksResponse.code() == 200;

        paymentResponse.body().getPayment().getId();
        paymentRequestFormTwoLinksBody = PaymentRequestFormTwoLinksBody.builder()
                .partId(1)
                .build();

        paymentRequestFormTwoLinksResponse = new PaymentRequestFormTwoLinksService()
                .postPaymentRequestFormTwoLinks(paymentId,paymentRequestFormTwoLinksBody);
        assert paymentRequestFormTwoLinksResponse.code() == 200;


    }
}












