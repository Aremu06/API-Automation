package org.api1;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
public class JSONSchemaValidation {

    @Test
    void JsonSchemaValidation(){

        given()

                .when().get("http://localhost:8090/users")
                .then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("storeJsonSchema.json"));

    }
}
