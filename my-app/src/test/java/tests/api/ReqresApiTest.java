package tests.api;

import utils.BaseApiTest;
import utils.RetryAnalyzer;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReqresApiTest extends BaseApiTest {

    @Test(retryAnalyzer =
        RetryAnalyzer.class)
    public void getUserTest() {

        int statusCode =
                  request
                  .when()
                .get("/api/users/2")
                .then()
                .log().all()
                .extract()
                .statusCode();

        Assert.assertEquals(statusCode, 200);
        request
                .when()
                .get("/api/users/2")
                .then()
                .log().all()
                .statusCode(200)
                .body("data.id", org.hamcrest.Matchers.equalTo(2))
                .body("data.email",
                        org.hamcrest.Matchers.equalTo("janet.weaver@reqres.in"))
                .body("data.first_name",
                        org.hamcrest.Matchers.equalTo("Janet"));
    }
}