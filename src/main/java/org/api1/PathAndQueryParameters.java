package org.api1;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PathAndQueryParameters extends DataDriven {
    //https://reqres.in/api/users?page=2&id=5
    @Test
    void testPathAndQueryParameters() {

        given()
                .pathParam("mypath", "users")
                .queryParam("page", 2)
                .queryParam("id", 5)

                .when()
                .get("https://reqres.in/api/{mypath}")

                .then()
                .statusCode(200)
                .log().all();


    }
}
