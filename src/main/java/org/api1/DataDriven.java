package org.api1;

import org.testng.annotations.DataProvider;

import static io.restassured.RestAssured.baseURI;

public class DataDriven {

    @DataProvider(name = "DataForPost")
    public Object[][] dataForPost() {

        return new Object[][]{

                {"Graham", "Bell", 1},
                {"Germ", "Ball", 2},
                {"Gerry", "Belly", 3},
        };
    }

    @DataProvider(name = "DeleteData")
    public Object[][] dataForDelete() {
        return new Object[][]{

                {}


        };

    }

    {
        // baseURI = "http://localhost:8000/";
        baseURI = "https://6af6-77-191-153-101.ngrok-free.app/";
    }
}