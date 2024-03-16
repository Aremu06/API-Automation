package org.api1;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;


public class ParsingJsonResponseData extends DataDriven {
    @Test(priority = 1)
    void testParsingJsonResponseBodyData() {
        // approach 1
//    given().contentType(ContentType.JSON)
//
//            .when().get(baseURI).then().statusCode(200)
//            .header("Content-Type", "text/html; charset=utf-8")
//            //.body("subjects[0].name",equalTo("Devops"));


        // approach 2

        Response response = given().contentType(ContentType.JSON)
                .when().get(baseURI + "users");

/*    Assert.assertEquals(response.getStatusCode(),200);
      Assert.assertEquals(response.header("Content-Type"),"text/html; charset=utf-8");

      String subject= response.jsonPath().get(".subjects[0].name").toString();
      Assert.assertEquals(subject,"Devops");
*/


//        JSONObject jo = new JSONObject(response.toString()); // converting response into json objet type
//        for (int i = 0; i < jo.getJSONArray("users").length(); i++) {
//            String usersFirstName = jo.getJSONArray("users").getJSONObject(i).get("firstName").toString();
//            System.out.println(usersFirstName);

        boolean status = false;
        JSONObject jo = new JSONObject(response.toString());
        for (int i = 0; i < jo.getJSONArray("users").length(); i++) {
            String usersFirstName = jo.getJSONArray("users").getJSONObject(i).get("firstName").toString();

            if (usersFirstName.equals("Ben")) {
                status = true;
                break;
            }

            Assert.assertEquals(status, true);
        }
    }
}