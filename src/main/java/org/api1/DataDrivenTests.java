package org.api1;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class DataDrivenTests extends DataDriven {
//    @DataProvider(name = "DataForPost")
//    public Object [] [] dataForPost(){
//
//        return new Object[] []{
//
//                {"Graham", "Bell", 1},
//                {"Germ", "Ball", 2},
//                {"Gerry", "Belly", 3},
//        };

    //  }
    @Test(dataProvider = "DataForPost")
    public void test_post(String firstName, String lastName, int subjectId) {

        Map<String, Object> request = new HashMap<>();

        request.put("firstName", firstName);
        request.put("lastName", lastName);
        request.put("subjectId", subjectId);

        // baseURI = "http://localhost:8000/users";

        given().header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request)

                .when().post(baseURI + "users")

                .then().statusCode(201).log().all();

    }

//    @DataProvider(name = "DeleteData")
//    public Object [] [] dataForDelete(){
//        return new Object[][]{
//
//                {1}
//
//        };
//    }

    @Test(dataProvider = "DeleteData")
    public void test_delete(int userId) {

        //  baseURI = "http://localhost:8000/";

        when()
                .delete(baseURI + "users/4")

                .then()
                .statusCode(200);
    }
}
