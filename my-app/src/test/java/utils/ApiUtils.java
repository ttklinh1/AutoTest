package utils;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public class ApiUtils {

    public static ResponseSpecification
    successResponse() {

        return new ResponseSpecBuilder()
                .expectStatusCode(201)
                .build();
    }
}
