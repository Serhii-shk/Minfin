package com.minfin.Minfin.api.test;

import com.minfin.Minfin.api.model.minfin.api.auth.auction.AuctionResponse;
import com.minfin.Minfin.api.model.minfin.api.user.register.RegisterRequest;
import com.minfin.Minfin.api.model.va.api.admin.profile.ProfileRequest;
import com.minfin.Minfin.api.model.va.api.auth.changeProfileType.ChangeProfileTypeRequest;
import com.minfin.Minfin.api.model.va.api.auth.minfinLogin.MinfinLoginRequest;
import com.minfin.Minfin.api.model.va.api.auth.minfinLogin.MinfinLoginResponse;
import com.minfin.Minfin.api.model.va.api.auth.userInfo.UserInfoResponse;
import com.minfin.Minfin.api.model.va.api.branches.body.*;
import com.minfin.Minfin.api.model.va.api.branches.response.BranchesResponse;
import com.minfin.Minfin.api.model.va.api.licenses.createLicenses.LicensesBody;
import com.minfin.Minfin.api.model.va.api.licenses.createLicenses.LicensesResponse;
import com.minfin.Minfin.api.model.va.api.licenses.setLicenseStatus.SetLicenseStatusBody;
import com.minfin.Minfin.api.model.va.api.phones.phoneId.PhoneIdBody;
import com.minfin.Minfin.api.model.va.api.phones.PhonesResponse;
import com.minfin.Minfin.api.model.va.api.phones.VerifyCodeRequest;
import com.minfin.Minfin.api.model.va.api.phones.phoneId.PhoneIdResponse;
import com.minfin.Minfin.api.model.va.api.rates.body.Buy;
import com.minfin.Minfin.api.model.va.api.rates.body.RatesBody;
import com.minfin.Minfin.api.model.va.api.rates.body.Rate;
import com.minfin.Minfin.api.model.va.api.rates.body.Sell;
import com.minfin.Minfin.api.pojo.MinfinAuthUser;
import com.minfin.Minfin.api.pojo.Rating;
import com.minfin.Minfin.api.pojo.RatingReviewPojo;
import com.minfin.Minfin.api.services.minfin.api.auth.auction.AuctionService;
import com.minfin.Minfin.api.services.minfin.api.ib.partner.auth.AuthService;
import com.minfin.Minfin.api.services.minfin.api.user.register.RegisterService;
import com.minfin.Minfin.api.services.va.api.admin.profile.ProfileService;
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
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import okhttp3.OkHttpClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static io.restassured.RestAssured.when;
import static io.restassured.config.JsonConfig.jsonConfig;
import static io.restassured.path.json.config.JsonPathConfig.NumberReturnType.DOUBLE;

@DisplayName("Тесты API")
public class ExchangeBranches {
    String baseUrl = "https://va-backend-stage.treeum.net/";
    OkHttpClient client = new OkHttpClient();


    @BeforeEach
    void setupRaConfig() {
//        JsonConfig jsonConfig = JsonConfig.jsonConfig()
//                .numberReturnType(JsonPathConfig.NumberReturnType.DOUBLE);
//        RestAssuredConfig.config()
//                .jsonConfig(jsonConfig)
//                .getEncoderConfig()
//                .appendDefaultContentCharsetToContentTypeIfUndefined(false);
        RestAssured.config = RestAssured.config().jsonConfig(jsonConfig().numberReturnType((DOUBLE)));

    }

    @Test
    @DisplayName("Получение всех обменников")
    @Tag("Api")
    @Tag("CurrencyAuction")
    void getExchangeBranchesReturn200() {
        when().get(baseUrl + "api/branches")
                .then().statusCode(200);
    }

    @Test
    @DisplayName("Получение конкретного обменника")
    @Tag("Api")
    @Tag("CurrencyAuction")
    void getGivenExchangeBranchesReturn200() {
        when().get(baseUrl + "api/branches/609a62e0d7df019585ada406")
                .then().statusCode(200);
    }

    @Test
    @DisplayName("Получение отзывов конкретного обменника")
    @Tag("Api")
    @Tag("CurrencyAuction")
    void getReviewsGivenExchangeBranchesReturn200() {
        when().get(baseUrl + "api/branches/609a62e0d7df019585ada406")
                .then().statusCode(200);
    }

    @Test
    @DisplayName("Создание отзыва для обменника")
    @Tag("Api")
    @Tag("CurrencyAuction")
    void createReviewForExchangeBranch201() {
        MinfinAuthUser minfinAuthUser = MinfinAuthUser.builder()
                .userId(1146314)
                .firstName("Serhii123321")
                .lastName("Serhii123321")
                .accountType("register_user")
                .login("kider73274@netjook.com")
                .nickname("Serhii123321")
                .slug(null)
                .agree(true)
                .verified(false).build();
        Object accessToken = RestAssured
                .given()
                .body(minfinAuthUser)
                .post(baseUrl + "api/auth/minfin_login")
                .then().log().body().extract().body().jsonPath().get("access_token");
        RatingReviewPojo ratingReviewPojo = RatingReviewPojo.builder()
                .text("Test bank66  Test bank66 revie66w bank Tes66t revie bank")
                .target_id("609a62e0d7df019585ada406")
                .rating(Rating.builder()
                        .availability(3)
                        .common(5)
                        .currencyRate(3)
                        .quality(4)
                        .safety(5)
                        .build())
                .build();
        RestAssured
                .given()
                .headers("Authorization",
                        "Bearer " + accessToken,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON
                )
                .body(ratingReviewPojo)
                .post(baseUrl + "api/branches/reviews")
                .then().statusCode(201);
    }

    @Test
    @DisplayName("Создание жалобы")
    @Tag("Api")
    @Tag("CurrencyAuction")
    void createComplaint201() {
        Object accessToken = RestAssured
                .given()
                .body("{" +
                        "    \"user_id\":1146314," +
                        "    \"first_name\":\"Serhii123321\"," +
                        "    \"last_name\":\"Serhii123321\"," +
                        "    \"account_type\":\"register_user\"," +
                        "    \"login\":\"kider73274@netjook.com\"," +
                        "    \"nickname\":\"Serhii123321\"," +
                        "    \"slug\":null," +
                        "    \"agree\":true," +
                        "    \"verified\":false" +
                        "}")
                .post(baseUrl + "api/auth/minfin_login")
                .then().log().body().extract().body().jsonPath().get("access_token");
        RestAssured
                .given()
                .headers("Authorization",
                        "Bearer " + accessToken,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON

                )
                .body("\"text\": \"Test complaint for profile1 Test complaint for profile1\"")
                .post(baseUrl + "api/profiles/reviews/606b1ca4db2e061cdacfe293/complaint")
                .then().statusCode(201);
    }

    @Test
    @DisplayName("Создание юзера")
    @Tag("Api")
    @Tag("CurrencyAuction")
    void createUser200() {
        // new UserService().createRandomUser();
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
                .address("ул. Малоземельная 75")
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
        assert new RatesService().postRates(adminToken,ratesBody).code() == 200;



    }

    @Test
    @DisplayName("Создание обменника")
    @Tag("Api")
    @Tag("CurrencyAuction")
    void createExchanger() {

    }

    @Test
    @DisplayName("Получение всех отзывов всех обменников Администратором")
    @Tag("Api")
    @Tag("CurrencyAuction")
    void getAllReviewsByBranchesAdmin200() {
        when().get(baseUrl + "api/branches/reviews/")
                .then().statusCode(200);
    }


}
