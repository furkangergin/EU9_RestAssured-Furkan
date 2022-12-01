package com.cydeo.practiceShortVideos;

import com.cydeo.utilities.SpartanTestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testng.annotations.BeforeClass;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class SpartanTestWithQueryParams2 {

    @BeforeAll
    static void setUpClass() {
        RestAssured.baseURI = "http://54.160.179.72:8000";
    }

    @Test
    public void Test1() {
        Response response1 = given().accept(ContentType.JSON)
                .and().queryParam("gender", "Female")
                .queryParam("nameContains", "e")
                .when().get("/api/spartans/search");

        response1.prettyPeek();
    }

    @Test
    public void Test2() {
        //creating map for query
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("gender", "Female");
        paramsMap.put("nameContains", "e");

        //send request
        Response response1 = given().accept(ContentType.JSON)
                .and().queryParams(paramsMap)
                .when().get("/api/spartans/search");

    }
}
