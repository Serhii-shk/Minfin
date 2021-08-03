package com.minfin.Minfin.api.test;

import com.minfin.Minfin.api.pojo.MinfinAuthUser;
import com.minfin.Minfin.utils.StringUtils;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static io.restassured.config.ObjectMapperConfig.objectMapperConfig;

    @DisplayName("Тесты API")
    public class ExchangeBranches {
    @BeforeEach
    void setupRaConfig() {
        RestAssuredConfig.config().objectMapperConfig(
                objectMapperConfig().defaultObjectMapperType(ObjectMapperType.GSON));
    }
    String baseUrl = "https://va-backend-stage2.treeum.net/";

    @Test
    @DisplayName("Получение всех обменников")
    @Tag("Api")
    @Tag("Currency auction")
    void getExchangeBranchesReturn200(){
        when().get(baseUrl + "api/branches")
                .then().statusCode(200);
    }

    @Test
    @DisplayName("Получение конкретного обменника")
    @Tag("Api")
    @Tag("Currency auction")
    void getGivenExchangeBranchesReturn200() {
        when().get(baseUrl + "api/branches/609a62e0d7df019585ada406")
                .then().statusCode(200);
    }

    @Test
    @DisplayName("Получение отзывов конкретного обменника")
    @Tag("Api")
    @Tag("Currency auction")
    void getReviewsGivenExchangeBranchesReturn200(){
        when().get(baseUrl + "api/branches/609a62e0d7df019585ada406")
                .then().statusCode(200);
    }

    @Test
    @DisplayName("Создание отзыва для обменника")
    @Tag("Api")
    @Tag("Currency auction")
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
        RestAssured
                .given()
                .headers("Authorization",
                        "Bearer " + accessToken,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON

                )
                .body("{\n" +
                        "    \"target_id\":\"609a62e0d7df019585ada406\",\n" +
                        "    \"rating\": {\n" +
                        "        \"availability\": 3,\n" +
                        "        \"common\": 2,\n" +
                        "        \"currency_rate\": 1,\n" +
                        "        \"quality\": 4,\n" +
                        "        \"safety\": 5\n" +
                        "    },\n" +
                        "    \"text\": \"Test bank66  Test bank66 revie66w bank Tes66t revie bank\"\n" +
                        "}")
                .post(baseUrl + "api/branches/reviews")
                .then().statusCode(201);
    }

    @Test
    @DisplayName("Создание жалобы")
    @Tag("Api")
    @Tag("Currency auction")
    void createComplaint201() {
        Object accessToken = RestAssured
                .given()
                .body("{\n" +
                        "    \"user_id\":1146314,\n" +
                        "    \"first_name\":\"Serhii123321\",\n" +
                        "    \"last_name\":\"Serhii123321\",\n" +
                        "    \"account_type\":\"register_user\",\n" +
                        "    \"login\":\"kider73274@netjook.com\",\n" +
                        "    \"nickname\":\"Serhii123321\",\n" +
                        "    \"slug\":null,\n" +
                        "    \"agree\":true,\n" +
                        "    \"verified\":false\n" +
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
    @Tag("Currency auction")
    void createUser200() {
        String email = "test_" + StringUtils.randomAlphabeticString(5) + "@test.test";
        String login = "test_" + StringUtils.randomAlphabeticString(5);
        given().log().all().accept(ContentType.JSON)
                .auth().basic("minfin", "Vs7ek37PQk")
                .contentType("multipart/form-data")
                .multiPart("Email", email)
                .multiPart("Login", "test_xesil26867")
                .multiPart("Password", "123qweQWE")
                .multiPart("Privacy", true)
                .multiPart("Rules", true)
                .multiPart("check", 2)
                .multiPart("first_name", "test_xesil26867")
                .multiPart("phone", "380970004432")
        .when().post("https://minfin.com.ua/api/user/register/")
                .then().log().body().statusCode(200);

        given()
                .with()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .formParam("Login", email)
                .formParam("Password", "123qweQWE")
                .post("https://minfin.com.ua/api/ib/partner/auth").then().statusCode(200);


        given()
                .header("Cookie", "minfin_sessions=a7497b06881fa70bc5bc7ed6ca0c6387a1c6b781")
                .when().get("https://minfin.com.ua/api/auth/auction-stage/")
                .then().log().body().statusCode(200);


    }

    @Test
    @DisplayName("Создание обменника")
    @Tag("Api")
    @Tag("Currency auction")
    void createExchanger() {

    }

    @Test
    @DisplayName("Получение всех отзывов всех обменников Администратором")
    @Tag("Api")
    @Tag("Currency auction")
    void getAllReviewsByBranchesAdmin200() {
        when().get(baseUrl + "api/profiles/reviews/")
                .then().statusCode(200);
    }


}
