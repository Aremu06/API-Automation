package org.api1;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Authentication {
    @Test(priority = 1)
    void testBasicAuthentication() {

        given().auth().basic("postman", "password")

                .when()
                .get("http://postman-echo.com/basic-auth")
                .then()
                .statusCode(200).body("authenticated", equalTo(true)).log().all();


    }

    @Test(priority = 2)
    void testDigestAuthentication() {

        given().auth().digest("postman", "password")

                .when().get("http://postman-echo.com/basic-auth")
                .then().statusCode(200).body("authenticated", equalTo(true)).log().all();
    }

    @Test(priority = 3)
    void testPreemptiveAuthentication() {

        given().auth().preemptive().basic("postman", "password")

                .when().get("http://postman-echo.com/basic-auth")
                .then().statusCode(200).body("authenticated", equalTo(true)).log().all();

    }

    @Test(priority = 4)
    void testBearerToken() {

        given().header("Authorization", "Bearer Token")
                .when().get("https://github.com/Aremu06/API-Automation")
                .then().statusCode(200).log().all();


    }

    void testOAuthentication() { // this is for OAuth 1.0

        given().auth().oauth("consumerKey", "consumerSecrete", "accessToken", "tokenSecrete")
                .when().get("url")
                .then().statusCode(200).log().all();
    }

    @Test
    void testOAu2Authentication() { // this is for OAuth 2.0

        given().auth().oauth2("BearerToken")
                .when().get("https://github.com/Aremu06/API-Automation")
                .then().statusCode(200).log().all();

    }

    void testAPIKey() { // this is for APIKey

        given().queryParam("appid", "appidkey")
                .when().get("url")
                .then().statusCode(200).log().all();


    }
}
