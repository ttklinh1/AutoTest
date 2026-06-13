package tests.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.CreateUserRequest;
import utils.ApiUtils;
import utils.BaseApiTest;
import utils.RetryAnalyzer;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class CreateUserTest extends BaseApiTest {

 @Test(retryAnalyzer =
        RetryAnalyzer.class)    
        public void verifyCreateUser() {

       CreateUserRequest requestBody =
        new CreateUserRequest(
                "Linh",
                "QA Engineer");

        Response response = request
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/api/users")
                .then()
                .log().all()
                .extract()
                .response();

        response.then()
        .spec(ApiUtils.successResponse());

        response.then()
        .assertThat()
        .body(matchesJsonSchemaInClasspath(
                "schemas/create-user-schema.json"));

        Assert.assertEquals(
                response.jsonPath().getString("name"),
                "Linh");

        Assert.assertEquals(
                response.jsonPath().getString("job"),
                "QA Engineer");
    }
}