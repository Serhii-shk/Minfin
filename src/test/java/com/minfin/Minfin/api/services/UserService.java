package com.minfin.Minfin.api.services;

import com.minfin.Minfin.api.pojo.MinfinAuthUser;
import com.minfin.Minfin.utils.StringUtils;
import io.restassured.http.ContentType;
import io.restassured.response.ResponseBody;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class UserService {

    public MinfinAuthUser createRandomUser() {
        String email = "test_" + StringUtils.randomAlphabeticString(5) + "@test.test";
        ResponseBody body = given().log().all().accept(ContentType.JSON)
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
                .body();
        int userIdGet = body.jsonPath().get("$.send_data.user_id");
        return MinfinAuthUser.builder()
                .login(email)
                .accountType("register_user")
                .userId(userIdGet)
                .nickname("nickname_test")
                .verified(false)
                .agree(true)
                .firstName("first_name_test")
                .lastName("last_name_test")
                .slug(null)
                .build();


    }

    public void authUser(String email) {
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

}
