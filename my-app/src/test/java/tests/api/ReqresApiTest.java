package tests.api;

import io.restassured.RestAssured;
import utils.BaseApiTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReqresApiTest extends BaseApiTest {

    @Test
    public void getUserTest() {

        int statusCode =
                RestAssured
                        .given()
                        .when()
                        .get("/api/users/2")
                        .then()
                        .extract()
                        .statusCode();

        Assert.assertEquals(statusCode, 200);
        RestAssured
                .given()
                .when()
                .get("/api/users/2")
                .then()
                .statusCode(200)
                .body("data.id", org.hamcrest.Matchers.equalTo(2))
                .body("data.email",
                        org.hamcrest.Matchers.equalTo("janet.weaver@reqres.in"))
                .body("data.first_name",
                        org.hamcrest.Matchers.equalTo("Janet"));
    }
}