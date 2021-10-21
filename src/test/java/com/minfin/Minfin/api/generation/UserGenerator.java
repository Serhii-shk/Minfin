package com.minfin.Minfin.api.generation;

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
import com.minfin.Minfin.utils.StringUtils;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class UserGenerator {

    public UserProfile createRandomExchanger() {
        String[] streets = new String[]
                {"Миропольская 25",
                "Срибнокильская 16",
                "Крещатик 21",
                "Малоземельная 75б",
                "Григоренка 22",
                "Бажана 31",
                "Чавдар 20",
                "Русовой 1"};
        int n = (int)Math.floor(Math.random() * streets.length);
        System.out.println(streets[n]);

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
        ProfileRequest profileRequest = ProfileRequest.builder()
                .activeAt(String.valueOf(date.plusMonths(1)))
                .countItems(1)
                .serviceProductId("5efdb5b6dda04383b8f03570")
                .build();
        String adminToken = minfinLoginResponse.body().getAccessToken();
        assert new ProfileService().postChangeProfileType(userInfo.body().getProfileId(), adminToken, profileRequest).code() == 200;


        String phoneNumber = "38000" + ThreadLocalRandom.current().nextLong(9100000L, 9109999L);

        Response<PhonesResponse> phonesResponse = new PhonesService().postPhones(phoneNumber, accessToken);
        assert phonesResponse.code() == 200;


        VerifyCodeRequest verifyCodeRequest = VerifyCodeRequest.builder()
                .verificationCode("234234")
                .build();
        assert new VerifyCodeService().postVerifyCode(phoneNumber, accessToken, verifyCodeRequest).code() == 200;


        PhoneIdBody phoneIdBody = new PhoneIdBody();
        phoneIdBody.setProfileId(userInfo.body().getProfileId());
        Response<PhoneIdResponse> phonesIdResponse = new PhoneIdService().getPhonesId(phoneIdBody);
        assert phonesIdResponse.code() == 200;


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
                .address(streets[n])
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
        assert branchesResponseResponse.code() == 201;

        String licensesNumber = "123" + ThreadLocalRandom.current().nextLong(91000000L, 91099999L);
        LicensesBody licensesBody = LicensesBody.builder()
                .profileId(userInfo.body().getProfileId())
                .name(licensesNumber)
                .build();
        Response<LicensesResponse> licensesResponseResponse = new LicensesService().postLicenses(accessToken, licensesBody);
        assert licensesResponseResponse.code() == 201;


        SetLicenseStatusBody setLicenseStatusBody = SetLicenseStatusBody.builder()
                .licenseId(licensesResponseResponse.body().getId())
                .status("success")
                .build();
        assert new SetLicenseStatusService().postSetLicenseStatus(setLicenseStatusBody).code() == 200;


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
        assert new RatesService().postRates(adminToken, ratesBody).code() == 200;
        return UserProfile.builder().email(email).password(password).id(branchesResponseResponse.body().getId()).build();
    }




    public UserProfile createRandomCustomerPro() {
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
        assert new RegisterService().postRegister(registerRequest).code() == 200;

        assert new AuthService().postAuth(email, password).code() == 200;

        Response<AuctionResponse> auction = new AuctionService().getAuction();
        assert auction.code() == 200;

        ChangeProfileTypeRequest typeRequest = ChangeProfileTypeRequest.builder().type("customer").build();
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
        ProfileRequest profileRequest = ProfileRequest.builder()
                .activeAt(String.valueOf(date.plusMonths(1)))
                .countItems(1)
                .serviceProductId("5efdb5b6dda04383b8f0355f")
                .build();
        String adminToken = minfinLoginResponse.body().getAccessToken();
        assert new ProfileService().postChangeProfileType(userInfo.body().getProfileId(), adminToken, profileRequest).code() == 200;


        String phoneNumber = "38000" + ThreadLocalRandom.current().nextLong(9100000L, 9109999L);

        Response<PhonesResponse> phonesResponse = new PhonesService().postPhones(phoneNumber, accessToken);
        assert phonesResponse.code() == 200;


        VerifyCodeRequest verifyCodeRequest = VerifyCodeRequest.builder()
                .verificationCode("234234")
                .build();
        assert new VerifyCodeService().postVerifyCode(phoneNumber, accessToken, verifyCodeRequest).code() == 200;


        PhoneIdBody phoneIdBody = new PhoneIdBody();
        phoneIdBody.setProfileId(userInfo.body().getProfileId());
        Response<PhoneIdResponse> phonesIdResponse = new PhoneIdService().getPhonesId(phoneIdBody);
        assert phonesIdResponse.code() == 200;


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
    assert applicationsResponseResponse.code() == 201;

        return UserProfile.builder().email(email).password(password).build();
    }


    public UserProfile createRandomCustomerFree() {
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
        assert new RegisterService().postRegister(registerRequest).code() == 200;

        assert new AuthService().postAuth(email, password).code() == 200;

        Response<AuctionResponse> auction = new AuctionService().getAuction();
        assert auction.code() == 200;

        ChangeProfileTypeRequest typeRequest = ChangeProfileTypeRequest.builder().type("customer").build();
        String accessToken = auction.body().getAccessToken();
        assert new ChangeProfileTypeService().postChangeProfileType(accessToken, typeRequest).code() == 200;

        Response<UserInfoResponse> userInfo = new UserInfoService().getUserInfo(accessToken);
        assert userInfo.code() == 200;
//
//        MinfinLoginRequest minfinLoginRequest = MinfinLoginRequest.builder()
//                .userId(870351)
//                .firstName("testRVKtest")
//                .lastName("testRVKtest")
//                .accountType("register_user")
//                .login("newusertest94@yopmail.com")
//                .nickname("testRVKtest")
//                .slug("null")
//                .agree(true)
//                .verified(false)
//                .build();
//        Response<MinfinLoginResponse> minfinLoginResponse = new MinfinLoginService().postMinfinLogin(minfinLoginRequest);
//        assert minfinLoginResponse.code() == 200;

//
//        LocalDateTime date = LocalDateTime.now();
//        ProfileRequest profileRequest = ProfileRequest.builder()
//                .activeAt(String.valueOf(date.plusMonths(1)))
//                .countItems(1)
//                .serviceProductId("5efdb5b6dda04383b8f0355f")
//                .build();
//        String adminToken = minfinLoginResponse.body().getAccessToken();
//        assert new ProfileService().postChangeProfileType(userInfo.body().getProfileId(), adminToken, profileRequest).code() == 200;


        String phoneNumber = "38000" + ThreadLocalRandom.current().nextLong(9100000L, 9109999L);

        Response<PhonesResponse> phonesResponse = new PhonesService().postPhones(phoneNumber, accessToken);
        assert phonesResponse.code() == 200;


        VerifyCodeRequest verifyCodeRequest = VerifyCodeRequest.builder()
                .verificationCode("234234")
                .build();
        assert new VerifyCodeService().postVerifyCode(phoneNumber, accessToken, verifyCodeRequest).code() == 200;


        PhoneIdBody phoneIdBody = new PhoneIdBody();
        phoneIdBody.setProfileId(userInfo.body().getProfileId());
        Response<PhoneIdResponse> phonesIdResponse = new PhoneIdService().getPhonesId(phoneIdBody);
        assert phonesIdResponse.code() == 200;


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
        assert applicationsResponseResponse.code() == 201;

        return UserProfile.builder().email(email).password(password).build();
    }


}
