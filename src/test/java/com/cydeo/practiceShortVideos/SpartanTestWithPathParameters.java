package com.cydeo.practiceShortVideos;

import com.cydeo.utilities.SpartanTestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;

public class SpartanTestWithPathParameters extends SpartanTestBase {

    @Test
    public void Test1(){

        Response response = given().accept(ContentType.JSON)
                .and().pathParam("id", 10)
                .when().get("api/spartans/{id}");

        System.out.println("response.body().path(\"id\") = " + response.path("id"));
    }

    @Test
    public void Test2(){
        Response response1 = get("api/spartans");

        int firstid= response1.path("id[0]");

        System.out.println("firstid = " + firstid);

        //get the all firstNames and print them

        List<String> names = response1.path("name");

        System.out.println("names.size() = " + names.size());

        for (String name : names) {
            System.out.println(name);

        }
    }






















}
