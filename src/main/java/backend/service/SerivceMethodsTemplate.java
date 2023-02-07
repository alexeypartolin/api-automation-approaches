package backend.service;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class SerivceMethodsTemplate {
    @Step("GET {endpoint}")
    public static <T> T getToPojo(String endpoint, Class<T> pojoClass) {
        return given()
                .get(endpoint)
                .then()
                .extract().body().as(pojoClass);
    }

    @Step("GET {endpoint}")
    public static <T> T getToPojo(String endpoint, Class<T> pojoClass, Map<String, Object> params) {
        return given()
                .queryParams(params)
                .get(endpoint)
                .then()
                .extract().body().as(pojoClass);
    }

    @Step("POST {endpoint}")
    public static <T> T postToPojo(String endpoint, Object body, Class<T> pojoClass) {
        return given()
                .body(body)
                .post(endpoint)
                .then()
                .extract().body().as(pojoClass);
    }

    @Step("GET {endpoint}")
    public static <T> T getToPojoJsonPath(String endpoint, String jsonPath, Class<T> pojoClass) {
        return given()
                .get(endpoint)
                .then()
                .extract().body().jsonPath().getObject(jsonPath, pojoClass);

    }

    @Step("GET {endpoint}")
    public static <T> T getToPojoJsonPath(String endpoint, String jsonPath, Class<T> pojoClass, Map<String, Object> params) {
        return given()
                .queryParams(params)
                .get(endpoint)
                .then()
                .extract().body().jsonPath().getObject(jsonPath, pojoClass);

    }

    @Step("POST {endpoint}")
    public static <T> T postToPojoJsonPath(String endpoint, Object body, String jsonPath, Class<T> pojoClass) {
        return given()
                .body(body)
                .post(endpoint)
                .then()
                .extract().body().jsonPath().getObject(jsonPath, pojoClass);
    }

    @Step("GET {endpoint}")
    public static <T> T getToPojoJsonPathData(String endpoint, Class<T> pojoClass) {
        return given()
                .get(endpoint)
                .then()
                .extract().body().jsonPath().getObject("data", pojoClass);

    }

    @Step("GET {endpoint}")
    public static <T> T getToPojoJsonPathData(String endpoint, Class<T> pojoClass, Map<String, Object> params) {
        return given()
                .queryParams(params)
                .get(endpoint)
                .then()
                .extract().body().jsonPath().getObject("data", pojoClass);

    }

    @Step("POST {endpoint}")
    public static <T> T postToPojoJsonPathResult(String endpoint, Object body, Class<T> pojoClass) {
        return given()
                .body(body)
                .post(endpoint)
                .then()
                .extract().body().jsonPath().getObject("result", pojoClass);
    }

    @Step("GET {endpoint}")
    public static <T> List<T> getToListPojoJsonPathData(String endpoint, Class<T> pojoClass) {
        return given()
                .get(endpoint)
                .then()
                .extract().body().jsonPath().getList("data", pojoClass);

    }

    @Step("GET {endpoint}")
    public static <T> List<T> getToListPojoJsonPathData(String endpoint, Class<T> pojoClass, Map<String, Object> params) {
        return given()
                .queryParams(params)
                .get(endpoint)
                .then()
                .extract().body().jsonPath().getList("data", pojoClass);

    }

    @Step("POST {endpoint}")
    public static <T> List<T> postToListPojoJsonPathItems(String endpoint, Object body, Class<T> pojoClass) {
        return given()
                .body(body)
                .post(endpoint)
                .then()
                .extract().body().jsonPath().getList("items", pojoClass);
    }

    @Step("POST {endpoint}")
    public static Response postResponse(String endpoint, Object body) {
        return given()
                .body(body)
                .post(endpoint)
                .then()
                .extract().response();
    }

    @Step("POST {endpoint}")
    public static Response postResponse(String endpoint) {
        return given()
                .post(endpoint)
                .then()
                .extract().response();
    }

    @Step("GET {endpoint}")
    public static Response getResponse(String endpoint) {
        return given()
                .get(endpoint)
                .then()
                .extract().response();
    }

    @Step("GET {endpoint}")
    public static Response getResponse(String endpoint, Map<String, Object> params) {
        return given()
                .queryParams(params)
                .get(endpoint)
                .then()
                .extract().response();
    }
}
