package com.cydeo.practiceShortVideos;

import com.cydeo.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class SpartanTestWithHamcrest extends SpartanTestBase {

    @Test
    public void test1() {

        given().accept(ContentType.JSON)
                .and().pathParam("id", 15)
                .when().get("/api/spartans/{id}")
                //respone
                .then().statusCode(200)
                .and().assertThat().contentType("application/json");

    }

    @Test
    public void test2() {

        given().accept(ContentType.JSON)
                .and().pathParam("id", 15)
                .when().get("/api/spartans/{id}")
                .then().statusCode(200)
                .and().assertThat().contentType("application/json")
                .and().assertThat().body("id", equalTo(15), "name", equalTo("Meta"));
    }
}