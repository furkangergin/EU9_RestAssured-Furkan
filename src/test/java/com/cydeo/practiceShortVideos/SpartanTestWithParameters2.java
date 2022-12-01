package com.cydeo.practiceShortVideos;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.testng.annotations.BeforeClass;

public class SpartanTestWithParameters2 {


    @BeforeClass
    public void setUpClass(){
        RestAssured.baseURI = "http://54.160.179.72:8000";
    }

    @Test
    public void Test1 (){
        Response response1 = RestAssured.given().accept(ContentType.JSON)
                .and().pathParam("id",18)
                .when().get("/api/spartans/{id}");

        response1.body().prettyPrint();
    }
}
