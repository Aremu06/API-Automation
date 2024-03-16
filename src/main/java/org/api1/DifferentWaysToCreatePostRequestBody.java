package org.api1;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;


//1) Post request using Hashmap
public class DifferentWaysToCreatePostRequestBody extends DataDriven {
    @Test
    void testPostUsingHashMap() {

        HashMap data = new HashMap();

        data.put("firstName", "Romeo");
        data.put("lastName", "Jane");
        data.put("subjectId", 5);

        String courseArr[] = {"C", "C++"};
        data.put("courses", courseArr);

        given()
                .contentType("application/json")
                .body(data)

                .when()
                .post(baseURI + "users")

                .then()
                .statusCode(201)
                .body("firstName", equalTo("Romeo"))
                .body("lastName", equalTo("Jane"))
                .body("courses[0]", equalTo("C"))
                .body("courses[1]", equalTo("C++"))
                .header("Content-Type", "application/json")
                .log().all();

    }

    // 2) Post request using org.json library
    @Test
    void testPostUsingOrgLibrary() {

        JSONObject data = new JSONObject();
        data.put("firstName", "AnyName");
        data.put("lastName", "AnyLastName");
        data.put("subjectId", 2);

        String courseArr[] = {"C#", "PHP"};
        data.put("courses", courseArr);

        given()
                .contentType("application/json")
                .body(data.toString())

                .when()
                .post(baseURI + "users")
                //.post("http://localhost:8000/users/")

                .then()
                .statusCode(201)
                .body("firstName", equalTo("AnyName"))
                .body("lastName", equalTo("AnyLastName"))
                .body("courses[0]", equalTo("C#"))
                .body("courses[1]", equalTo("PHP"))
                .header("Content-Type", "application/json")
                .log().all();

    }


    // 3) Post request using POJO class
    @Test
    void testPostUsingPOJO() {

        Pojo_PostRequest data = new Pojo_PostRequest();

        data.setFirstName("James");
        data.setLastName("Gery");
        data.setId("12");

        String courses[] = {"API", "Java"};
        data.setCourses(courses);


        given()
                .contentType("application/json")
                .body(data)

                .when()
                .post(baseURI + "users/")

                .then()
                .statusCode(201)
                .header("Content-Type", "application/json")
                .log().all();

    }

    // 3) Post request using External json file
    @Test
    void testPostUsingExternalJson() throws FileNotFoundException {

        File file = new File("./external.json");

        FileReader fileReader = new FileReader(file);

        JSONTokener jsonTokener = new JSONTokener(fileReader);

        JSONObject data = new JSONObject(jsonTokener);


        given()
                .contentType("application/json")
                .body(data.toString())

                .when()
                .post(baseURI + "users/")

                .then()
                .statusCode(201)
                .header("Content-Type", "application/json")
                .log().all();

    }


    @Test
    void testDelete() {
        when().delete(baseURI + "users/3").then().statusCode(200);


    }
}