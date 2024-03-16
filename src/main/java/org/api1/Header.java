package org.api1;

import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.nio.charset.StandardCharsets;

import static io.restassured.RestAssured.given;

public class Header {

    @Test(priority = 1)
    void testHeaders(){

        given()

                .when().get("https://www.google.com")
                    .then().header("Content-Type", "text/html; charset=ISO-8859-1")
                .header("Cache-Control", "private, max-age=0")
                .header("Content-Encoding", "gzip")

                .log().headers(); // all headers info
    }


}

