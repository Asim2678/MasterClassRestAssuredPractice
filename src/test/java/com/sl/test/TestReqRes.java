package com.sl.test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class TestReqRes {
    public static void main(String[] args) {

        String C_ID = "3";
        String expFirstName = "Emma";


        String BaseURL = "https://reqres.in";
        RestAssured.baseURI = BaseURL;

        Response response = RestAssured
                .given()
                .when()
                .get("/api/users/" + C_ID);
        System.out.println(response.asString());

        ResponseBody body = response.getBody();
        System.out.println(body.asString());

        JsonPath JsonPath = response.jsonPath();
        System.out.println(JsonPath.getString("data.id"));
        System.out.println(JsonPath.getString("data.first_name"));
        System.out.println(JsonPath.getString("data.last_name"));
        System.out.println(JsonPath.getString("data.email"));
        System.out.println(JsonPath.getString("data.avatar"));

        String actFirstname = JsonPath.getString("data.first_name");
        if (expFirstName.equals(actFirstname)) {
            System.out.println("Test Pass");
        }
            else{
            System.out.println("Test Fail, First naim does not match");
        }



    }
}
