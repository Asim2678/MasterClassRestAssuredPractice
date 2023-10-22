package com.sl.test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;

public class TestPostReq {
    public static void main(String[] args) {

        String BaseURL = "https://reqres.in";
        RestAssured.baseURI = BaseURL;
        LibReqRsData lib = new LibReqRsData();
        JSONObject user = lib.DataJsonCreateUser();

//        JSONObject jsoneobject =new JSONObject();
//        jsoneobject.put("name", "kumar");
//        jsoneobject.put("job", "AE");


       Response response= RestAssured
                .given()
                .header("Content-Type","application/json")
                .body(user.toString())
                .when()
                .post("api/users");
       System.out.println(response.getStatusCode());
       System.out.println(response.getBody().asString());
        JsonPath jsonPath = response.jsonPath();

        System.out.println(jsonPath.getString("id"));
        System.out.println(jsonPath.getString("name"));

    }
}
