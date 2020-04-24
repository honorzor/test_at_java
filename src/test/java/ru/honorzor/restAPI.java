package ru.honorzor;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class restAPI {


    @Test(priority = 2)
    public void getUsersList() {
        baseURI = "https://reqres.in";
        RestAssured.given()
                .when()
                .get("/api/users?page=2")
                .then()
                .log().all()
                .statusCode(200)
                .body("page", notNullValue())
                .body("per_page", notNullValue())
                .body("total", notNullValue())
                .body("total_pages", notNullValue())
                .body("data.id", not(hasItem(nullValue())))
                .body("data.email", not(hasItem(nullValue())))
                .body("data.first_name", not(hasItem(nullValue())))
                .body("data.last_name", not(hasItem(nullValue())))
                .body("data.avatar", not(hasItem(nullValue())))
                .body("ad.company", notNullValue())
                .body("ad.url", notNullValue())
                .body("ad.text", notNullValue());
    }


    @Test(priority = 1)
    public void createUser() {
        Map<String, String> dao = new HashMap<>();
        dao.put("name", "morpheus");
        dao.put("job", "leader");

        baseURI = "https://reqres.in";

        Response response = given()
                .contentType("application/json")
                .body(dao)
                .when()
                .post("/api/users")
                .then()
                .log().all()
                .statusCode(201)
                .extract()
                .response();

        JsonPath jsonResponse = response.jsonPath();

        Assert.assertEquals(jsonResponse.get("name").toString(), dao.get("name"));
        Assert.assertEquals(jsonResponse.get("job").toString(), dao.get("job"));

    }
}