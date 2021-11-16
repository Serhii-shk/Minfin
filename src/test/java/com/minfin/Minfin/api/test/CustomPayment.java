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
        UserProfile exchanger = new UserGenerator()
                .createRandomExchanger();

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
                .createRandomExchanger();

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
                .createRandomExchanger();

        Steps steps = new Steps();

        AdminProfile adminAuth = steps
                .loginAsAdmin();
        steps
                .creatingPaymentToAdminForUserTwoPays(exchanger, adminAuth);

        steps
                .sendNotificationTwoPays(exchanger,adminAuth);
        steps.
                paymentFormTwoPays(exchanger);




//        String paymentId = paymentResponse.body().getPayment().getId();
//
//        PaymentRequestFormTwoLinksBody paymentRequestFormTwoLinksBody = PaymentRequestFormTwoLinksBody.builder()
//                .partId(0)
//                .build();
//
//        Response<PaymentRequestFormTwoLinksResponse> paymentRequestFormTwoLinksResponse = new PaymentRequestFormTwoLinksService()
//                .postPaymentRequestFormTwoLinks(paymentId,paymentRequestFormTwoLinksBody);
//        then(paymentRequestFormTwoLinksResponse.code())
//                .isEqualTo(200);


//
//        paymentResponse.body().getPayment().getId();
//        paymentRequestFormTwoLinksBody = PaymentRequestFormTwoLinksBody.builder()
//                .partId(1)
//                .build();
//
//        paymentRequestFormTwoLinksResponse = new PaymentRequestFormTwoLinksService()
//                .postPaymentRequestFormTwoLinks(paymentId,paymentRequestFormTwoLinksBody);
//        then(paymentRequestFormTwoLinksResponse.code())
//                .isEqualTo(200);

    }
}












