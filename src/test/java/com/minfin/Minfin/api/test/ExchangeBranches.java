package com.minfin.Minfin.api.test;

import com.google.gson.Gson;
import com.minfin.Minfin.api.pojo.*;
import com.minfin.Minfin.utils.StringUtils;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import okhttp3.*;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static io.restassured.RestAssured.when;
import static io.restassured.config.ObjectMapperConfig.objectMapperConfig;

    @DisplayName("Тесты API")
    public class ExchangeBranches {
    @BeforeEach
    void setupRaConfig() {
        RestAssuredConfig.config().objectMapperConfig(
                objectMapperConfig().defaultObjectMapperType(ObjectMapperType.GSON));
    }

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
    @Tag("CurrencyAuction")
    void createUser200() throws IOException, InterruptedException {
        // new UserService().createRandomUser();
        String email = "test_" + StringUtils.randomAlphabeticString(5) + "@test.test";
        client
                .newBuilder()
                .build();
        MediaType mediaTypeText = MediaType.parse("text/plain");
        RequestBody bodyMultipart = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("Email", email)
                .addFormDataPart("Login", "secene10test")
                .addFormDataPart("Password", "123qweQWE")
                .addFormDataPart("Privacy", "true")
                .addFormDataPart("Rules", "true")
                .addFormDataPart("check", "2")
                .addFormDataPart("first_name", "secene1856")
                .addFormDataPart("phone", "+380005554455")
                .build();
        Request request1 = new Request.Builder()
                .url("https://minfin.com.ua/api/user/register/")
                .method("POST", bodyMultipart)
                .addHeader("Authorization", "Basic bWluZmluOlZzN2VrMzdQUWs=")
                .build();
        Response response1 = client.newCall(request1).execute();
        System.out.println(response1.code() == 200);


        client
                .newBuilder()
                .build();
        MediaType mediaTypeXForm = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody bodyXForm = RequestBody.create(mediaTypeXForm, "Login=" + email +"&Password=123qweQWE");
        Request request2 = new Request.Builder()
                .url("https://minfin.com.ua/api/ib/partner/auth")
                .method("POST", bodyXForm)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("Cookie", "minfin_sessions=a77f3459ab2b5ac9e2369f8ef78d3d17fbda754a")
                .build();
        Response response2 = client.newCall(request2).execute();
        System.out.println(response2.code() == 200);


        client
                .newBuilder()
                .build();
        Request request3 = new Request.Builder()
                .url("https://minfin.com.ua/api/auth/auction-stage/")
                .method("GET", null)
                .addHeader("Cookie", "minfin_sessions=a77f3459ab2b5ac9e2369f8ef78d3d17fbda754a")
                .build();
        Response response3 = client.newCall(request3).execute();
        AuthAuctioneResponse authAuctioneResponse = new Gson().fromJson(response3.body().string(), AuthAuctioneResponse.class);
        System.out.println(response3.code() == 200);


        client.newBuilder()
                .build();
        MediaType mediaTypeApplicationJson = MediaType.parse("application/json");
        RequestBody bodyRaw = RequestBody.create(mediaTypeApplicationJson, "{\n\"type\": \"exchanger\"\n}\n");
        Request request4 = new Request.Builder()
                .url("https://va-backend-stage.treeum.net/api/auth/change_profile_type")
                .method("POST", bodyRaw)
                .addHeader("Authorization", "Bearer " + authAuctioneResponse.getAccessToken())
                .addHeader("Content-Type", "application/json")
                .build();
        Response response4 = client.newCall(request4).execute();
        System.out.println(response4.code() == 200);



        client.newBuilder()
                .build();
        Request requestUserInfo = new Request.Builder()
                .url("https://va-backend-stage.treeum.net/api/auth/user_info")
                .method("GET", null)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + authAuctioneResponse.getAccessToken())
                .build();
        Response responseUserInfo = client.newCall(requestUserInfo).execute();
        AuthUserInfoResponse authUserInfoResponse = new Gson().fromJson(responseUserInfo.body().string(), AuthUserInfoResponse.class);
        System.out.println(responseUserInfo.code() == 200);



        client
                .newBuilder()
                .build();
        MediaType mediaTypeAdmin = MediaType.parse("application/json");
        RequestBody bodyAdmin = RequestBody.create(mediaTypeAdmin, "{\n\"user_id\":870351,\n\"first_name\":\"testRVKtest\",\n\"last_name\":\"testRVKtest\",\n\"account_type\":\"register_user\",\n\"login\":\"newusertest94@yopmail.com\",\n\"nickname\":\"testRVKtest\",\n\"slug\":null,\n\"agree\":true,\n\"verified\":false\n}");
        Request request = new Request.Builder()
                .url("https://va-backend-stage.treeum.net/api/auth/minfin_login")
                .method("POST", bodyAdmin)
                .addHeader("Content-Type", "application/json")
                .build();
        Response responseAdmin = client.newCall(request).execute();
        AuthMinfinLoginResponse authMinfinLoginResponse = new Gson().fromJson(responseAdmin.body().string(), AuthMinfinLoginResponse.class);
        System.out.println(responseAdmin.code() == 200);




        client
                .newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody bodyRaw2 = RequestBody.create(mediaType, "{\n\"service_product_id\": \"5efdb5b6dda04383b8f03570\",\n\"active_at\": \"" + LocalDateTime.now() +"\",\n\"count_items\": 1\n}");
        Request request5 = new Request.Builder()
                .url("https://va-backend-stage.treeum.net/api/admin/profile/" + authUserInfoResponse.getProfileId() +"/subscription")
                .method("POST", bodyRaw2)
                .addHeader("Authorization", "Bearer " + authMinfinLoginResponse.getAccessToken())
                .addHeader("Content-Type", "application/json")
                .build();
        Response response5 = client.newCall(request5).execute();
        System.out.println(response5.code() == 200);


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
