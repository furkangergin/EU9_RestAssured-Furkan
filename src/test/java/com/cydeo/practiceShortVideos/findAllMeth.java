package com.cydeo.practiceShortVideos;

import com.cydeo.utilities.HRTestBase;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;

public class findAllMeth extends HRTestBase {

    @Test
    public void test(){

        Response response = RestAssured.get("/employees");

        JsonPath jsonPath = response.jsonPath();

       // response.prettyPeek();

        List<Integer> salary = jsonPath.getList("items.salary");
        //System.out.println(salary);

        List<Integer> listSalaryLessThanFive = jsonPath.getList("items.findAll{it.salary<5000}.salary");

        System.out.println(listSalaryLessThanFive);

        System.out.println(listSalaryLessThanFive.size());


    }
}
