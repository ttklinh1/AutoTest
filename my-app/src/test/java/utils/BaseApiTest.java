package utils;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

import config.ConfigReader;

public class BaseApiTest {

protected RequestSpecification request;

    @BeforeMethod
    public void setup() {
        request = RestAssured.given()
                .log().all()
                .baseUri("https://reqres.in")
                .header("x-api-key", ConfigReader.get("reqres.api.key"));
    }
}