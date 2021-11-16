package com.minfin.Minfin.api.steps;

import com.minfin.Minfin.api.model.common.AdminProfile;
import com.minfin.Minfin.api.model.common.UserProfile;
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
import com.minfin.Minfin.api.services.va.api.auth.minfinLogin.MinfinLoginService;
import com.minfin.Minfin.api.services.va.api.notification.SendNotificationService;
import com.minfin.Minfin.api.services.va.api.payment.PaymentRequestFormService;
import com.minfin.Minfin.api.services.va.api.payment.PaymentRequestFormTwoLinksService;
import com.minfin.Minfin.api.services.va.api.payment.PaymentService;
import lombok.NonNull;
import retrofit2.Response;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import static org.assertj.core.api.BDDAssertions.then;

public class Steps {
    final String isoTime;

    {
        DateTimeFormatter ISO_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        isoTime = LocalDateTime.now().plusMonths(1).format(ISO_FORMATTER);
    }
    int adminUserId = 870351;
    String exchangerM1 = "5efdb5b6dda04383b8f03570";

    public AdminProfile loginAsAdmin(){
        MinfinLoginRequest minfinLoginRequest = MinfinLoginRequest.builder()
                .userId(adminUserId)
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

        String accessToken = minfinLoginResponse.body().getAccessToken();
        String refreshToken = minfinLoginResponse.body().getRefreshToken();
        return AdminProfile.builder().accessToken(accessToken).refreshToken(refreshToken).build();


    }

    public UserProfile  creatingPaymentToAdminForUser(@NonNull UserProfile exchanger, @NonNull AdminProfile adminAuth) {

        PaymentBody paymentBody = PaymentBody.builder()
                .serviceProductId(exchangerM1)
                .activeAt(isoTime)
                .countItems(1)
                .amount(0)
                .payByLink(true)
                .paymentExpiresDays(3)
                .paymentCount(1)
                .build();
        Response<PaymentResponse> paymentResponse = new PaymentService()
                .postPayment(
                        exchanger.getProfileId(),
                        adminAuth.getAccessToken(),
                        paymentBody);

        exchanger.setPayment(paymentResponse.body().getPayment());
        exchanger.setId(Objects.requireNonNull(paymentResponse.body()).getId());
        exchanger.setProfileId(paymentResponse.body().getPayment().getProfileId());

        return exchanger;

    }

    public void sendNotification(@NonNull UserProfile exchanger, @NonNull AdminProfile adminAuth){
        SendNotificationBody sendNotificationBody = SendNotificationBody.builder()
                .email("s.shkurenko@treeum.net")
                .phone("380979979468")
                .build();

        Response<SendNotificationResponse> sendNotificationResponse = new SendNotificationService()
                .postSendNotification(
                        exchanger.getProfileId(),
                        adminAuth.getAccessToken(),
                        sendNotificationBody);
        then(sendNotificationResponse.code())
                .isEqualTo(200);
    }

    public UserProfile paymentForm(@NonNull UserProfile exchanger) {
        Response<PaymentRequestFormResponse> paymentRequestFormResponse = new PaymentRequestFormService()
                .postPaymentRequestForm(exchanger.getPayment().getId());
        return exchanger;
    }

    public UserProfile creatingPaymentToAdminForUserTwoPays(@NonNull UserProfile exchanger, @NonNull AdminProfile adminAuth){
        PaymentBody paymentBody = PaymentBody.builder()
                .serviceProductId(exchangerM1)
                .activeAt(isoTime)
                .countItems(1)
                .amount(0)
                .payByLink(true)
                .paymentExpiresDays(3)
                .paymentCount(2)
                .build();
        Response<PaymentResponse> paymentResponse = new PaymentService()
                .postPayment(
                        exchanger.getProfileId(),
                        adminAuth.getAccessToken(),
                        paymentBody);

        exchanger.setPayment(paymentResponse.body().getPayment());
        exchanger.setId(Objects.requireNonNull(paymentResponse.body()).getId());
        exchanger.setProfileId(paymentResponse.body().getPayment().getProfileId());

        return exchanger;
    }

    public void sendNotificationTwoPays(@NonNull UserProfile exchanger, @NonNull AdminProfile adminAuth){
        SendNotificationBody sendNotificationBody = SendNotificationBody.builder()
                .email("s.shkurenko@treeum.net")
                .phone("380979979468")
                .build();

        Response<SendNotificationResponse> sendNotificationResponse = new SendNotificationService()
                .postSendNotification(
                        exchanger.getProfileId(),
                        adminAuth.getAccessToken(),
                        sendNotificationBody);
        then(sendNotificationResponse.code())
                .isEqualTo(200);
    }

    public UserProfile paymentFormTwoPays(@NonNull UserProfile exchanger) {

        PaymentRequestFormTwoLinksBody paymentRequestFormTwoLinksBody = PaymentRequestFormTwoLinksBody.builder()
                .partId(0)
                .build();

        Response<PaymentRequestFormTwoLinksResponse> paymentRequestFormTwoLinksResponse = new PaymentRequestFormTwoLinksService()
                .postPaymentRequestFormTwoLinks(exchanger.getPayment().getId(),paymentRequestFormTwoLinksBody);
        then(paymentRequestFormTwoLinksResponse.code())
                .isEqualTo(200);

        PaymentRequestFormTwoLinksBody secondPaymentRequestFormTwoLinksBody = PaymentRequestFormTwoLinksBody.builder()
                .partId(1)
                .build();

        Response<PaymentRequestFormTwoLinksResponse> secondPaymentRequestFormTwoLinksResponse = new PaymentRequestFormTwoLinksService()
                .postPaymentRequestFormTwoLinks(exchanger.getPayment().getId(),secondPaymentRequestFormTwoLinksBody);
        then(secondPaymentRequestFormTwoLinksResponse.code())
                .isEqualTo(200);
        return exchanger;
    }

}
