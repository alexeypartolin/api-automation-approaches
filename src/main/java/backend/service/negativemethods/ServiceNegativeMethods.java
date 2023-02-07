package backend.service.negativemethods;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;

public class ServiceNegativeMethods {
    @Step("GET {endpoint")
    public static Response getResponseCustomMethod(String endpoint) {
        return given()
                .get(endpoint)
                .then()
                .statusCode(anyOf(
                        is(404),
                        is(403)
                ))
                .extract().response();
    }
}
