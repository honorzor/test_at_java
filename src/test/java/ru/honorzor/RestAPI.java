package ru.honorzor;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.path.json.JsonPath.from;


public class RestAPI {


    @Test(priority = 2)
    public void getUsersList() {
        baseURI = "https://reqres.in";
        Response response = get("/api/users/?page=2");
        response.then().log().all().statusCode(200);

        User[] userList = from(response.getBody().asString()).getObject("data", User[].class);

        for (User userGet : userList) {
            Assert.assertNotNull(userGet.getId());
            Assert.assertNotNull(userGet.getEmail());
            Assert.assertNotNull(userGet.getFirst_name());
            Assert.assertNotNull(userGet.getLast_name());
            Assert.assertNotNull(userGet.getAvatar());
        }
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