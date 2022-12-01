package com.cydeo.practiceShortVideos;

import com.cydeo.utilities.SpartanTestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class SpartanTestWithJsonPath extends SpartanTestBase {

    /*
    Given accept type is json
    And path param spartan id is 11
    When user sends a get request to /spartans/{id}
    Then status code is 200
    And content type is Json
    and "id":11
        "name":"Nona"
        "gender":"Female"
        "phone":7959094216

     */

    @Test
    public void test1(){

        Response response = given().accept(ContentType.JSON)
                .and().pathParam("id", 11)
                .when().get("/api/spartans/{id}");

        assertEquals(response.statusCode(),200);
        //how to read value with path() method
        int id1 = response.path("id");
        System.out.println("id1 = " + id1);

        JsonPath jsonPath = response.jsonPath();

        //how to read value with JsonPath?
        int id = jsonPath.getInt("id");
        String name = jsonPath.getString("name");
        String gender = jsonPath.getString("gender");
        long phone = jsonPath.getLong("phone");

        System.out.println("id = " + id);
        System.out.println("name = " + name);
        System.out.println("gender = " + gender);
        System.out.println("phone = " + phone);

        assertEquals(11, id);
        assertEquals("Nona", name);
        assertEquals("Female",gender);
        assertEquals(7959094216L, phone);

    }
    @Test
    public void test2(){

        ////get me name of spartans who name contains 'e'

        Response response = get("/api/spartans");

        JsonPath jsonPath = response.jsonPath();

        List<Object> allSpartans = jsonPath.get();
       System.out.println("allSpartans = " + allSpartans); // bütün spartanları yazdı
       System.out.println("allSpartans.size() = " + allSpartans.get(1));

        List<String> names = jsonPath.getList("name");//her spartanın isimlerini yazdır
      //  System.out.println("names = " + names);

        List<String> namesContainsE = jsonPath.getList("findAll{it.name.contains('e')}.name");
        System.out.println("namesContainsE = " + namesContainsE);


    }































}
