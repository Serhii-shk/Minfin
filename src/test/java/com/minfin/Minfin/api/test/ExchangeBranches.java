package com.minfin.Minfin.api.test;

import com.minfin.Minfin.api.model.minfin.api.auth.auction.AuctionResponse;
import com.minfin.Minfin.api.model.minfin.api.user.register.RegisterRequest;
import com.minfin.Minfin.api.model.va.api.admin.profile.ProfileRequest;
import com.minfin.Minfin.api.model.va.api.auth.changeProfileType.ChangeProfileTypeRequest;
import com.minfin.Minfin.api.model.va.api.auth.minfinLogin.MinfinLoginRequest;
import com.minfin.Minfin.api.model.va.api.auth.minfinLogin.MinfinLoginResponse;
import com.minfin.Minfin.api.model.va.api.auth.userInfo.UserInfoResponse;
import com.minfin.Minfin.api.model.va.api.phones.PhonesResponse;
import com.minfin.Minfin.api.model.va.api.phones.VerifyCodeRequest;
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
import com.minfin.Minfin.api.services.va.api.phones.PhonesService;
import com.minfin.Minfin.api.services.va.api.phones.VerifyCodeService;
import com.minfin.Minfin.utils.StringUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import okhttp3.OkHttpClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.time.LocalDateTime;

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

        ProfileRequest profileRequest = ProfileRequest.builder()
                .activeAt(String.valueOf(LocalDateTime.now()))
                .countItems(1)
                .serviceProductId("5efdb5b6dda04383b8f03570")
                .build();
        assert new ProfileService().postChangeProfileType(userInfo.body().getProfileId(), minfinLoginResponse.body().getAccessToken(), profileRequest).code() == 200;


        Response<PhonesResponse> phonesResponse = new PhonesService().postPhones("380007960537", accessToken);
        assert phonesResponse.code() == 200;


        VerifyCodeRequest verifyCodeRequest = VerifyCodeRequest.builder()
                .verificationCode("234234")
                .build();
        assert new VerifyCodeService().postVerifyCode("380007960537", accessToken, verifyCodeRequest).code() == 200;





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
