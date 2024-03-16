package org.api1;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.*;
public class Cookies {
    @Test(priority = 1)
    void testCookies(){

        given()

                .when().get("https://www.google.com")

                .then().cookies("AEC", "Ae3NU9PKyY9azFsJ17rogXLO4RCD1rQc8wc_AJjSluM5A470MJhzvJWYKwM")
                .log().all();
    }

    @Test(priority = 2)
    void testCookiesInfo(){

        Response response = given()

                .when().get("https://www.google.com");

        // get single cookies info

        //String cookies_value = response.cookie("AEC");
       // System.out.println("Value of cookies is ====>"+ cookies_value);

        // get all cookies info

      Map<String, String> cookies_value = response.getCookies();
     //   System.out.println(cookies_value.keySet());

        for (String k:cookies_value.keySet()){
            String cookie_value = response.getCookie(k);
            System.out.println(k+  "    "+ cookie_value);


        }



    }



}
