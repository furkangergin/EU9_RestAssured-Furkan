package com.cydeo.practiceShortVideos;

import com.cydeo.pojo.Spartan;
import com.cydeo.utilities.SpartanTestBase;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SpartanTestPojoDeserization extends SpartanTestBase {
    @Test
    public void test1() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .pathParam("id", 15)
                .when().get("/api/spartans/{id}");

        //GSON --> de-serialization
        //how to convert json response to our spartan class
        SpartanForPojo spartan15 = response.body().as(SpartanForPojo.class);
        System.out.println("spartan15.getName() = " + spartan15.getName());

        //verify
        Assertions.assertEquals("Meta", spartan15.getName());

    }

    @Test
    public void gsonExample() {

        Gson gson = new Gson();

        String myJsonBody = "{\n" +
                "    \"id\": 15,\n" +
                "    \"name\": \"Meta\",\n" +
                "    \"gender\": \"Female\",\n" +
                "    \"phone\": 1938695106\n" +
                "}";

        //Using gson to de-serialize our json body
        SpartanForPojo spartanMeta = gson.fromJson(myJsonBody,SpartanForPojo.class);
        System.out.println("spartanMeta = " + spartanMeta);

        //serialization Java object --> JSON Body

        SpartanForPojo spartan = new SpartanForPojo(101,"Mike","Male",123456789l);
        //converting cuatom class to json (serialization)
        String jsonBody = gson.toJson(spartan);

        System.out.println(jsonBody);


    }
}