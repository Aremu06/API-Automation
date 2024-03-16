package org.api1;

import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;

public class Test_POST {
    @Test(priority = 1)
    public void test_1_post() {

    /*    Map<String, Object> map = new HashMap<String, Object>();

        map.put("name", "Ramson");
        map.put("job", "Teacher");

        JSONObject request = new JSONObject(map);

        System.out.println(request);
     */
        JSONObject request = new JSONObject();
        request.put("name", "Ramson");
        request.put("job", "Teacher");

        System.out.println(request);

        given().header("Content-Type", "Application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request)

                .when()
                .post("https://reqres.in/api/Users")

                .then()
                .statusCode(201);
    }

    @Test(priority = 2)
    public void test_1_put() {

        JSONObject request = new JSONObject();
        request.put("name", "John");
        request.put("job", "Trainer");

        System.out.println(request);

        given().header("Content-Type", "Application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request)

                .when()
                .put("https://reqres.in/api/Users/2")

                .then()
                .statusCode(200)
                .log().all();
    }

    @Test(priority = 3)
    public void test_3_patch() {

        JSONObject request = new JSONObject();
        request.put("name", "John");
        request.put("job", "Trainer");

        System.out.println(request);

        given().header("Content-Type", "Application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request)

                .when()
                .patch("https://reqres.in/api/Users/2")

                .then()
                .statusCode(200)
                .log().all();
    }

    @Test(priority = 4)
    public void test_4_delete() {

        given()
                .when()
                .delete("https://reqres.in/api/Users/2")

                .then()
                .statusCode(204)
                .log().all();
    }
}
