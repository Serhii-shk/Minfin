package com.minfin.Minfin.api.generation;

import com.github.javafaker.Faker;
import com.minfin.Minfin.api.model.common.UserProfile;
import com.minfin.Minfin.api.model.minfin.api.auth.auction.AuctionResponse;
import com.minfin.Minfin.api.model.minfin.api.user.register.RegisterRequest;
import com.minfin.Minfin.api.model.va.api.admin.profile.ProfileRequest;
import com.minfin.Minfin.api.model.va.api.applications.body.ApplicationsBody;
import com.minfin.Minfin.api.model.va.api.applications.body.Modifications;
import com.minfin.Minfin.api.model.va.api.applications.response.ApplicationsResponse;
import com.minfin.Minfin.api.model.va.api.auth.changeProfileType.ChangeProfileTypeRequest;
import com.minfin.Minfin.api.model.va.api.auth.minfinLogin.MinfinLoginRequest;
import com.minfin.Minfin.api.model.va.api.auth.minfinLogin.MinfinLoginResponse;
import com.minfin.Minfin.api.model.va.api.auth.userInfo.UserInfoResponse;
import com.minfin.Minfin.api.model.va.api.branches.body.*;
import com.minfin.Minfin.api.model.va.api.branches.response.BranchesResponse;
import com.minfin.Minfin.api.model.va.api.licenses.createLicenses.LicensesBody;
import com.minfin.Minfin.api.model.va.api.licenses.createLicenses.LicensesResponse;
import com.minfin.Minfin.api.model.va.api.licenses.setLicenseStatus.SetLicenseStatusBody;
import com.minfin.Minfin.api.model.va.api.phones.PhonesResponse;
import com.minfin.Minfin.api.model.va.api.phones.VerifyCodeRequest;
import com.minfin.Minfin.api.model.va.api.phones.phoneId.PhoneIdBody;
import com.minfin.Minfin.api.model.va.api.phones.phoneId.PhoneIdResponse;
import com.minfin.Minfin.api.model.va.api.rates.body.Buy;
import com.minfin.Minfin.api.model.va.api.rates.body.Rate;
import com.minfin.Minfin.api.model.va.api.rates.body.RatesBody;
import com.minfin.Minfin.api.model.va.api.rates.body.Sell;
import com.minfin.Minfin.api.services.minfin.api.auth.auction.AuctionService;
import com.minfin.Minfin.api.services.minfin.api.ib.partner.auth.AuthService;
import com.minfin.Minfin.api.services.minfin.api.user.register.RegisterService;
import com.minfin.Minfin.api.services.va.api.admin.profile.ProfileService;
import com.minfin.Minfin.api.services.va.api.applications.ApplicationsService;
import com.minfin.Minfin.api.services.va.api.auth.changeProfileType.ChangeProfileTypeService;
import com.minfin.Minfin.api.services.va.api.auth.minfinLogin.MinfinLoginService;
import com.minfin.Minfin.api.services.va.api.auth.usesrInfo.UserInfoService;
import com.minfin.Minfin.api.services.va.api.branches.BranchesService;
import com.minfin.Minfin.api.services.va.api.licenses.createLicenses.LicensesService;
import com.minfin.Minfin.api.services.va.api.licenses.setLicenseStatus.SetLicenseStatusService;
import com.minfin.Minfin.api.services.va.api.phones.PhoneIdService;
import com.minfin.Minfin.api.services.va.api.phones.PhonesService;
import com.minfin.Minfin.api.services.va.api.phones.VerifyCodeService;
import com.minfin.Minfin.api.services.va.api.rates.RatesService;
import com.minfin.Minfin.api.steps.Steps;
import com.minfin.Minfin.utils.StringUtils;
import lombok.NonNull;
import retrofit2.Response;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

import static org.assertj.core.api.BDDAssertions.then;

public class UserGenerator {
    final String isoTime;
    String street = new Faker(new Locale("uk")).address().streetAddress();

    {
        DateTimeFormatter ISO_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        isoTime = LocalDateTime.now().plusMonths(1).format(ISO_FORMATTER);
    }

    public UserProfile createPureRandomExchanger() {
        String email = "test_" + StringUtils.randomAlphabeticString(5) + "@test.test";
        String password = "123qweQWE";

        RegisterRequest registerRequest = RegisterRequest.builder()
                .email(email)
                .login("secene10test")
                .password(password)
                .privacy(true)
                .rules(true)
                .check(2)
                .firstName("secene1856")
                .phone("+380005554455")
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

        return UserProfile.builder().email(email).password(password)
                .profileId(userInfo.body().getProfileId()).build();
    }


    public UserProfile createRandomExchangerWithPaidSubscription() {
        String email = "test_" + StringUtils.randomAlphabeticString(5) + "@test.test";
        String password = "123qweQWE";

        UserProfile exchanger = UserProfile.builder()
                .email(email)
                .password(password)
                .build();


        RegisterRequest registerRequest = RegisterRequest.builder()
                .email(exchanger.getEmail())
                .login("secene10test")
                .password(exchanger.getPassword())
                .privacy(true)
                .rules(true)
                .check(2)
                .firstName("secene1856")
                .phone("+380005554455")
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
        then(minfinLoginResponse.code())
                .isEqualTo(200);

        ProfileRequest profileRequest = ProfileRequest.builder()
                .activeAt(isoTime)
                .countItems(1)
                .serviceProductId("5efdb5b6dda04383b8f03570")
                .build();
        String adminToken = new Steps().loginAsAdmin().getAccessToken();
        then(new ProfileService().postChangeProfileType(userInfo.body().getProfileId(), adminToken, profileRequest).code())
                .isEqualTo(200);

        String phoneNumber = getRandomPhoneNumber();
        Response<PhonesResponse> phonesResponse = phonesServicePostPhones(phoneNumber, accessToken);
        then(phonesResponse.code())
                .isEqualTo(200);

        VerifyCodeRequest verifyCodeRequest = VerifyCodeRequest.builder()
                .verificationCode("234234")
                .build();
        then(new VerifyCodeService().postVerifyCode(phoneNumber, accessToken, verifyCodeRequest).code()).isEqualTo(200);

        PhoneIdBody phoneIdBody = new PhoneIdBody();
        phoneIdBody.setProfileId(userInfo.body().getProfileId());
        Response<PhoneIdResponse> phonesIdResponse = new PhoneIdService().getPhonesId(phoneIdBody);
        then(phonesIdResponse.code())
                .isEqualTo(200);

        Mon mon = Mon.builder().worked(true).start("9:00").end("20:00").breaks(new ArrayList<>()).build();
        Sat sat = Sat.builder().worked(true).start("9:00").end("20:00").breaks(new ArrayList<>()).build();
        Sun sun = Sun.builder().worked(true).start("9:00").end("20:00").breaks(new ArrayList<>()).build();
        Tue tue = Tue.builder().worked(true).start("9:00").end("20:00").breaks(new ArrayList<>()).build();
        Wed wed = Wed.builder().worked(true).start("9:00").end("20:00").breaks(new ArrayList<>()).build();
        Thu thu = Thu.builder().worked(true).start("9:00").end("20:00").breaks(new ArrayList<>()).build();
        Fri fri = Fri.builder().worked(true).start("9:00").end("20:00").breaks(new ArrayList<>()).build();
        BranchesBody branchesBody = BranchesBody.builder()
                .siteId("5e9457447c84a212fbe91ecd")
                .branchType("exchanger")
                .profileId(userInfo.body().getProfileId())
                .phoneId(phonesIdResponse.body().getItems().get(0).getId())
                .location(Location.builder().coordinates(List.of(50.403326, 30.630425)).type("Point").build())
                .address(street)
                .city(1)
                .workTime(WorkTime.builder()
                        .mon(mon)
                        .tue(tue)
                        .wed(wed)
                        .thu(thu)
                        .fri(fri)
                        .sat(sat)
                        .sun(sun)
                        .build())
                .services(Services.builder()
                        .cctv(false)
                        .damagedBills(false)
                        .recountRoom(false)
                        .parts(false)
                        .transfer(false)
                        .verified(false)
                        .build())
                .build();
        Response<BranchesResponse> branchesResponseResponse = new BranchesService().postBranches(accessToken, branchesBody);
        then(branchesResponseResponse.code())
                .isEqualTo(201);

        String licensesNumber = "123" + ThreadLocalRandom.current().nextLong(91000000L, 91099999L);
        LicensesBody licensesBody = LicensesBody.builder()
                .profileId(userInfo.body().getProfileId())
                .name(licensesNumber)
                .build();
        Response<LicensesResponse> licensesResponseResponse = new LicensesService().postLicenses(accessToken, licensesBody);
        then(licensesResponseResponse.code())
                .isEqualTo(201);

        SetLicenseStatusBody setLicenseStatusBody = SetLicenseStatusBody.builder()
                .licenseId(licensesResponseResponse.body().getId())
                .status("success")
                .build();
        then(new SetLicenseStatusService().postSetLicenseStatus(setLicenseStatusBody).code())
                .isEqualTo(200);

        Buy buy = Buy.builder()
                .minCount(1000)
                .maxCount(20000)
                .value(27.00)
                .build();
        Sell sell = Sell.builder()
                .minCount(1000)
                .maxCount(20000)
                .value(28.00)
                .build();

        RatesBody ratesBody = RatesBody.builder()
                .branchId(branchesResponseResponse.body().getId())
                .profileId(userInfo.body().getProfileId())
                .currency("usd")
                .rate(Rate.builder()
                        .buy(buy)
                        .sell(sell)
                        .build())
                .build();

        then(new RatesService().postRates(adminToken, ratesBody).code())
                .isEqualTo(200);

        return UserProfile.builder().email(email).password(password)
                .address(street).id(branchesResponseResponse.body().getId()).profileId(userInfo.body().getProfileId()).build();
    }

    private Response<PhonesResponse> phonesServicePostPhones(@NonNull UserProfile exchanger) {
        Response<PhonesResponse> phonesResponse = null;
        for (int i = 0; i < 10; i++) {
            String randomPhoneNumber = getRandomPhoneNumber();
            phonesResponse = new PhonesService().postPhones(exchangerrandomPhoneNumber, exchanger.get);
            if (phonesResponse.isSuccessful()) {
                exchanger.setPhone(randomPhoneNumber);
                return phonesResponse;
            } else if (i == 9) {
                throw new IllegalStateException("Please clear DB unique phone numbers are over");
            }
        }
        return phonesResponse;
    }

    private String getRandomPhoneNumber() {
        return "38000" + ThreadLocalRandom.current().nextLong(9100000L, 9109999L);
    }


    public UserProfile createPureRandomCustomerPro() {
        String email = "test_" + StringUtils.randomAlphabeticString(5) + "@test.test";
        String password = "123qweQWE";

        RegisterRequest registerRequest = RegisterRequest.builder()
                .email(email)
                .login("secene10test")
                .password(password)
                .privacy(true)
                .rules(true)
                .check(2)
                .firstName("secene1856")
                .phone("+380005554455")
                .build();
        then(new RegisterService().postRegister(registerRequest).code())
                .isEqualTo(200);
        then(new AuthService().postAuth(email, password).code())
                .isEqualTo(200);

        Response<AuctionResponse> auction = new AuctionService().getAuction();
        then(auction.code())
                .isEqualTo(200);

        ChangeProfileTypeRequest typeRequest = ChangeProfileTypeRequest.builder().type("customer").build();
        String accessToken = auction.body().getAccessToken();
        then(new ChangeProfileTypeService().postChangeProfileType(accessToken, typeRequest).code())
                .isEqualTo(200);

        Response<UserInfoResponse> userInfo = new UserInfoService().getUserInfo(accessToken);
        then(userInfo.code())
                .isEqualTo(200);

        return UserProfile.builder().email(email).password(password).build();
    }


    public UserProfile createRandomCustomerProWithPaidSubscription() {
        String email = "test_" + StringUtils.randomAlphabeticString(5) + "@test.test";
        String password = "123qweQWE";

        RegisterRequest registerRequest = RegisterRequest.builder()
                .email(email)
                .login("secene10test")
                .password(password)
                .privacy(true)
                .rules(true)
                .check(2)
                .firstName("secene1856")
                .phone("+380005554455")
                .build();
        then(new RegisterService().postRegister(registerRequest).code())
                .isEqualTo(200);
        then(new AuthService().postAuth(email, password).code())
                .isEqualTo(200);

        Response<AuctionResponse> auction = new AuctionService().getAuction();
        then(auction.code())
                .isEqualTo(200);

        ChangeProfileTypeRequest typeRequest = ChangeProfileTypeRequest.builder().type("customer").build();
        String accessToken = auction.body().getAccessToken();
        then(new ChangeProfileTypeService().postChangeProfileType(accessToken, typeRequest).code())
                .isEqualTo(200);

        Response<UserInfoResponse> userInfo = new UserInfoService().getUserInfo(accessToken);
        then(userInfo.code())
                .isEqualTo(200);

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
        then(minfinLoginResponse.code())
                .isEqualTo(200);

        ProfileRequest profileRequest = ProfileRequest.builder()
                .activeAt(isoTime)
                .countItems(1)
                .serviceProductId("5efdb5b6dda04383b8f0355f")
                .build();
        String adminToken = minfinLoginResponse.body().getAccessToken();
        then(new ProfileService().postChangeProfileType(userInfo.body().getProfileId(), adminToken, profileRequest).code())
                .isEqualTo(200);

        String phoneNumber = "38000" + ThreadLocalRandom.current().nextLong(9100000L, 9109999L);
        Response<PhonesResponse> phonesResponse = new PhonesService().postPhones(phoneNumber, accessToken);
        then(phonesResponse.code())
                .isEqualTo(200);

        VerifyCodeRequest verifyCodeRequest = VerifyCodeRequest.builder()
                .verificationCode("234234")
                .build();
        then(new VerifyCodeService().postVerifyCode(phoneNumber, accessToken, verifyCodeRequest).code())
                .isEqualTo(200);

        PhoneIdBody phoneIdBody = new PhoneIdBody();
        phoneIdBody.setProfileId(userInfo.body().getProfileId());
        Response<PhoneIdResponse> phonesIdResponse = new PhoneIdService().getPhonesId(phoneIdBody);
        then(phonesIdResponse.code())
                .isEqualTo(200);

        ApplicationsBody applicationsBody = ApplicationsBody.builder()
                .siteId("5e9457447c84a212fbe91ecd")
                .profileId(userInfo.body().getProfileId())
                .phoneId(phonesIdResponse.body().getItems().get(0).getId())
                .location(com.minfin.Minfin.api.model.va.api.applications.body.Location.builder()
                        .coordinates(List.of(50.400679, 30.616587))
                        .type("Point")
                        .build())
                .address("ул. Княжий Затон 21")
                .city(1)
                .type("buy")
                .currency("usd")
                .rate(27)
                .amount(1000)
                .description("Test test test")
                .modifications(Modifications.builder()
                        .pinned(false)
                        .painted(false)
                        .build())
                .services(com.minfin.Minfin.api.model.va.api.applications.body.Services.builder()
                        .parts(false)
                        .transfer(false)
                        .damagedBills(false)
                        .build())
                .build();
        Response<ApplicationsResponse> applicationsResponseResponse = new ApplicationsService().postApplications(accessToken, applicationsBody);
        then(applicationsResponseResponse.code())
                .isEqualTo(201);

        return UserProfile.builder()
                .email(email)
                .password(password)
                .id(applicationsResponseResponse.body().getId())
                .build();
    }


    public UserProfile createPureRandomCustomerFree() {
        String email = "test_" + StringUtils.randomAlphabeticString(5) + "@test.test";
        String password = "123qweQWE";

        RegisterRequest registerRequest = RegisterRequest.builder()
                .email(email)
                .login("secene10test")
                .password(password)
                .privacy(true)
                .rules(true)
                .check(2)
                .firstName("secene1856")
                .phone("+380005554455")
                .build();
        then(new RegisterService().postRegister(registerRequest).code())
                .isEqualTo(200);

        then(new AuthService().postAuth(email, password).code())
                .isEqualTo(200);

        Response<AuctionResponse> auction = new AuctionService().getAuction();
        then(auction.code())
                .isEqualTo(200);

        ChangeProfileTypeRequest typeRequest = ChangeProfileTypeRequest.builder().type("customer").build();
        String accessToken = auction.body().getAccessToken();
        then(new ChangeProfileTypeService().postChangeProfileType(accessToken, typeRequest).code())
                .isEqualTo(200);

        Response<UserInfoResponse> userInfo = new UserInfoService().getUserInfo(accessToken);
        then(userInfo.code())
                .isEqualTo(200);

        return UserProfile.builder().email(email).password(password).build();
    }


    public UserProfile createRandomCustomerFreeWithAdt() {
        String email = "test_" + StringUtils.randomAlphabeticString(5) + "@test.test";
        String password = "123qweQWE";

        RegisterRequest registerRequest = RegisterRequest.builder()
                .email(email)
                .login("secene10test")
                .password(password)
                .privacy(true)
                .rules(true)
                .check(2)
                .firstName("secene1856")
                .phone("+380005554455")
                .build();
        then(new RegisterService().postRegister(registerRequest).code())
                .isEqualTo(200);

        then(new AuthService().postAuth(email, password).code())
                .isEqualTo(200);

        Response<AuctionResponse> auction = new AuctionService().getAuction();
        then(auction.code())
                .isEqualTo(200);

        ChangeProfileTypeRequest typeRequest = ChangeProfileTypeRequest.builder().type("customer").build();
        String accessToken = auction.body().getAccessToken();
        then(new ChangeProfileTypeService().postChangeProfileType(accessToken, typeRequest).code())
                .isEqualTo(200);

        Response<UserInfoResponse> userInfo = new UserInfoService().getUserInfo(accessToken);
        then(userInfo.code())
                .isEqualTo(200);

        String phoneNumber = "38000" + ThreadLocalRandom.current().nextLong(9100000L, 9109999L);

        Response<PhonesResponse> phonesResponse = new PhonesService().postPhones(phoneNumber, accessToken);
        then(phonesResponse.code())
                .isEqualTo(200);

        VerifyCodeRequest verifyCodeRequest = VerifyCodeRequest.builder()
                .verificationCode("234234")
                .build();
        then(new VerifyCodeService().postVerifyCode(phoneNumber, accessToken, verifyCodeRequest).code())
                .isEqualTo(200);

        PhoneIdBody phoneIdBody = new PhoneIdBody();
        phoneIdBody.setProfileId(userInfo.body().getProfileId());
        Response<PhoneIdResponse> phonesIdResponse = new PhoneIdService().getPhonesId(phoneIdBody);
        then(phonesIdResponse.code())
                .isEqualTo(200);

        ApplicationsBody applicationsBody = ApplicationsBody.builder()
                .siteId("5e9457447c84a212fbe91ecd")
                .profileId(userInfo.body().getProfileId())
                .phoneId(phonesIdResponse.body().getItems().get(0).getId())
                .location(com.minfin.Minfin.api.model.va.api.applications.body.Location.builder()
                        .coordinates(List.of(50.400679, 30.616587))
                        .type("Point")
                        .build())
                .address("ул. Княжий Затон 21")
                .city(1)
                .type("buy")
                .currency("usd")
                .rate(27)
                .amount(1000)
                .description("Test test test")
                .modifications(Modifications.builder()
                        .pinned(false)
                        .painted(false)
                        .build())
                .services(com.minfin.Minfin.api.model.va.api.applications.body.Services.builder()
                        .parts(false)
                        .transfer(false)
                        .damagedBills(false)
                        .build())
                .build();
        Response<ApplicationsResponse> applicationsResponseResponse = new ApplicationsService().postApplications(accessToken, applicationsBody);
        then(applicationsResponseResponse.code())
                .isEqualTo(201);

        return UserProfile.builder()
                .email(email)
                .password(password)
                .id(applicationsResponseResponse.body().getId())
                .build();
    }

    public UserProfile createUserWithoutSubscription() {
        String email = "test_" + StringUtils.randomAlphabeticString(5) + "@test.test";
        String password = "123qweQWE";

        RegisterRequest registerRequest = RegisterRequest.builder()
                .email(email)
                .login("secene10test")
                .password(password)
                .privacy(true)
                .rules(true)
                .check(2)
                .firstName("secene1856")
                .phone("+380005554455")
                .build();
        then(new RegisterService().postRegister(registerRequest).code())
                .isEqualTo(200);
        then(new AuthService().postAuth(email, password).code())
                .isEqualTo(200);

        Response<AuctionResponse> auction = new AuctionService().getAuction();
        then(auction.code())
                .isEqualTo(200);

        //ChangeProfileTypeRequest typeRequest = ChangeProfileTypeRequest.builder().type("exchanger").build();

        String accessToken = auction.body().getAccessToken();
//        then(new ChangeProfileTypeService().postChangeProfileType(accessToken, typeRequest).code())
//                .isEqualTo(200);

        Response<UserInfoResponse> userInfo = new UserInfoService().getUserInfo(accessToken);
        then(userInfo.code())
                .isEqualTo(200);

        return UserProfile.builder().email(email).password(password)
                .profileId(userInfo.body().getProfileId()).build();
    }


}
