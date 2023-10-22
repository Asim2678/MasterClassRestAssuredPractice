package com.sl.test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCasesResResp {
    String BaseURL = "https://reqres.in";
    RequestSpecification reqSpec;
    LibReqRsData lib;

    @BeforeClass
    public void before() {
        lib = new LibReqRsData();
        RestAssured.baseURI = BaseURL;
        reqSpec = RestAssured
                .given()
                .header("Content-Type", "application/json");

    }

    @Test(dataProvider = "dp")
    public void TestLogin(String strName, String strRole) {

        lib.setStrName(strName);
        lib.setStrRole(strRole);
        JSONObject user = lib.DataJsonCreateUser();
        System.out.println(user.toString());

        Response resp = reqSpec
                .body(user.toString())
                .when()
                .post("/api/users");
        Assert.assertEquals(resp.getStatusCode(), 201);
        JsonPath jsonPath = resp.jsonPath();

        Assert.assertEquals(jsonPath.getString("name"), strName);
        Assert.assertEquals(jsonPath.getString("job"), strRole);
//        only to intentially fail the test
//        if (strName.equals("Krishna")){
//            strName = "Krishna Kishore";
//            System.out.println("User is invalid");
//        }else {
//            System.out.println("User is valid");
//        }
    }

    @DataProvider
    public String[][] dp() {
        return new String[][]{
                new String[]{"Karthik", "IM"},
                new String[]{"karishna", "DM"},
        };
    }
}
