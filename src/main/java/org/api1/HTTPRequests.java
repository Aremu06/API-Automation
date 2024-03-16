package org.api1;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

/*
    given()
         content type,set cookies, add auth, add param, set headers info etc....

    .when()
        Specify the request type , get put, delete

    .then()
        validate status code, extract response, extract headers cookies & response body....
 */
public class HTTPRequests {

    int id;

    @Test(priority = 1)
    void getUser() {

        Response response = get("https://reqres.in/api/users/2");

        System.out.println("Response : " + response.asString());
        System.out.println("Response : " + response.getStatusCode());
        System.out.println("Response : " + response.getBody().asString());
        System.out.println("Response : " + response.getTime());
        System.out.println("Response : " + response.getHeader("Content-type"));

    }

    @Test(priority = 2)
    void createUser() {

        HashMap data = new HashMap();
        data.put("name", "paven");
        data.put("job", "trainer");

        id = given()
                .contentType("application/json")
                .body(data)

                .when()
                .post("https://reqres.in/api/users")
                .jsonPath().getInt("id");

        //  .then().
        //   statusCode(201)
        //  .log().all();
    }

    @Test(priority = 3)
    void updateUsers() {
        HashMap data = new HashMap();
        data.put("name", "john");
        data.put("job", "teacher");

        given()
                .contentType("application.json")

                .when()
                .put("https://reqres.in/api/users/" + id)

                .then()
                .statusCode(200)
                .log().all();
    }

    @Test(priority = 4)
    void deleteUser() {

        given()

                .when()
                .delete("https://reqres.in/api/users/" + id)

                .then()
                .statusCode(204)
                .log().all();

    }

}