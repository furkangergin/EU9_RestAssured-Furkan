package com.cydeo.practiceShortVideos;

import com.cydeo.utilities.SpartanTestBase;
import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SpartanTestsPOJODeserization extends SpartanTestBase {

    @Test
    public void test1() {

        Response response = given().accept(ContentType.JSON)
                .and().pathParam("id", 15)
                .when().get("/api/spartans/{id}");

        //GSON-->de-serialization
    //how to convert json response to our spartan class

    SpartanForPojo spartan = response.body().as(SpartanForPojo.class);
        System.out.println(spartan.toString());

        //verify
        Assertions.assertEquals(spartan.getName(), "Meta");
    }
    @Test
    public <Gson> void gsonExample(){








    }



































}
