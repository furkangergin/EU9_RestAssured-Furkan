package com.cydeo.day12;

import io.restassured.http.*;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class MockApi {

    //https://c7e25ac7-0e15-4761-aeb2-a2d25d544674.mock.pstmn.io

    @Test
    public void test1(){

        given().baseUri("https://c7e25ac7-0e15-4761-aeb2-a2d25d544674.mock.pstmn.io")
                .accept(ContentType.JSON)
                .when()
                .get("/customer")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstName",is("John"));

    }

    @Test
    public void test2(){

        given().baseUri("https://c7e25ac7-0e15-4761-aeb2-a2d25d544674.mock.pstmn.io")
                .accept(ContentType.JSON)
                .when()
                .get("/employees")
                .prettyPrint();

    }

}
