package com.cydeo.practiceShortVideos;

import com.cydeo.utilities.SpartanAuthTestBase;
import com.cydeo.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class SpartanJsonToCollections extends SpartanTestBase {

    @Test
    public void test1() {

        Response response = given().accept(ContentType.JSON)
                .and().pathParam("id", 1)
                .when().get("/api/spartans/{id}");

        //response.prettyPrint();

        //convert Json response to Java Collections(Map)
        Map<String, Object> spartanMap = response.body().as(Map.class);
        System.out.println("spartanMap.get(\"name\") = " + spartanMap.get("name"));

        Assertions.assertEquals("Meade", spartanMap.get("name"));

    }

    @Test
    public void test2() {

        Response response = given().accept(ContentType.JSON)
                .when().get("/api/spartans");

        //convert full json body to list of map

        List<Map<String, Object>> listOfSpartans = response.body().as(List.class);
        System.out.println(listOfSpartans.get(0));
        Map<String, Object> firstSpartan = listOfSpartans.get(0);

        int counter =1;

        for (Map<String, Object> map : listOfSpartans) {
            System.out.println(counter+ " -spartan" + map);
            counter++;

        }

    }
}
