package org.api1;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import org.json.JSONObject;
import static io.restassured.matcher.RestAssuredMatchers.*;
import java.util.HashMap;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import  io.restassured.response.Response;


public class dbJsonSampleRequest {

    @Test
    public void test_get(){

        baseURI = "http://localhost:8000/";

        given().param("name", "Devops")
                .get("subject")

                .then()
                .statusCode(200)
                .log().all();

    }

    @Test
    public void test_post(){

        JSONObject request = new JSONObject();

        request.put("firstName", "Tommy");
        request.put("lastName", "Jay");
        request.put("subjectId", 1);
        request.put("courses","C");
        request.put("courses[0]","C++");

      //  baseURI = "https://2b61-77-191-173-223.ngrok-free.app/";

        given().header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                //.body(request.toString());
                .body(request.toString())

                .when().post("/users")

                .then()
                .statusCode(201)
                .log().all();

    }

    @Test
    public void test_patch(){

        JSONObject request = new JSONObject();

        request.put("lastName", "Blaze");


        baseURI = "http://localhost:8000/";

        given().header("Content-Type", "Application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toString())
                .body(request);


        when().patch("/users");

        given()
                .then()
                .statusCode(201)
                .log().all();

    }

    @Test
    public void test_put(){

        JSONObject request = new JSONObject();

        request.put("firstName", "Mary");
        request.put("lastName", "Jane");
        request.put("subjectId", 1);
        request.put("courses","C");
        request.put("courses[0]","C++");

        baseURI = "http://localhost:8000/";

        given().header("Content-Type", "Application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toString())
                .body(request)

                .when().put("/users")

                .then()
                .statusCode(200)
                .log().all();

    }
    @Test
    public void test_delete(){

        baseURI = "https://2b61-77-191-173-223.ngrok-free.app/";

        when()
                .delete("/users/d51f")

                .then()
                .statusCode(200);
    }
}
