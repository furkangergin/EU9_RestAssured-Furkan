package com.cydeo.practiceShortVideos;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;

public class SpartanTests {

    String url = "http://54.160.179.72:8000";

    @Test
    public void Test1() {
        Response response = get(url + "/api/spartans");

        //response.prettyPeek();

        // System.out.println("response.path(\"name\") = " + response.path("name"));

        System.out.println("response.statusCode() = " + response.statusCode());

        System.out.println("response.body().prettyPeek() = " + response.body().prettyPrint());

        //  System.out.println("response.body().asString() = " + response.body().asString());
    }


    @Test
    public void Test2() {
        Response response1 = get(url + "/api/spartans");

        Assertions.assertEquals(200, response1.statusCode());
        Assertions.assertTrue(response1.body().asString().contains("Allen"));

    }

    @Test
    public void Test3() {
        Response response3 = RestAssured.given().accept(ContentType.JSON)
                .when().get(url + "/api/spartans");


        Assertions.assertEquals(response3.contentType(), "application/json");

    }











}
