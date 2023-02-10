package backend.service.positivemethods;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;

public class ServicePositiveMethods {
    @Step("GET {endpoint")
    public static Response getResponseCustomMethod(String endpoint) {
        return given()
                .get(endpoint)
                .then()
                .statusCode(anyOf(
                        is(200),
                        is(201)
                ))
                .extract().response();
    }

    @Step("GET {endpoint}")
    public static <T> T getToPojo(String endpoint, Class<T> pojoClass) {
        return given()
                .get(endpoint)
                .then()
                .extract().body().as(pojoClass);
    }

    // Уточняем через JSONPath что мы извлекаем в POJO (к примеру один json object)
    @Step("GET {endpoint}")
    public static <T> T getToPojoJsonPath(String endpoint, String jsonPath, Class<T> pojoClass) {
        return given()
                .get(endpoint)
                .then()
                .extract().body().jsonPath().getObject(jsonPath, pojoClass);
    }

    // Получаем список JSON объектов
    @Step("GET {endpoint}")
    public static <T> List<T> getToListPojoJsonPathData(String endpoint, Class<T> pojoClass) {
        return given()
                .get(endpoint)
                .then()
                .extract().body().jsonPath().getList("tags", pojoClass);
    }

    // Создание сущности в БД и return root POJO
    @Step("POST {endpoint}")
    public static <T> T postToRootPojo(String endpoint, Object body, Class<T> pojoClass) {
        return given()
                .body(body)
                .post(endpoint)
                .then()
                .extract().body().as(pojoClass);
    }

    // Создание сущности в БД и return POJO (не root)
    @Step("POST {endpoint}")
    public static <T> T postToPojo(String endpoint, Object body, String jsonPath, Class<T> pojoClass) {
        return given()
                .body(body)
                .post(endpoint)
                .then()
                .extract().body().jsonPath().getObject(jsonPath, pojoClass);
    }

    @Step("GET {endpoint}")
    public static <T> List<T> getToListPojoJsonPathData(String endpoint, Class<T> pojoClass, Map<String, String> params) {
        return given()
                .queryParams(params)
                .get(endpoint)
                .then()
                .extract().body().jsonPath().getList(".", pojoClass);
    }

    // Обновление данных существующего Pet
    @Step("POST {endpoint}")
    public static <T> T postToPojoJsonPath(String endpoint, Object body, String jsonPath, Class<T> pojoClass) {
        return given()
                .body(body)
                .put(endpoint)
                .then()
                .extract().body().jsonPath().getObject(jsonPath, pojoClass);
    }

    @Step("PUT {endpoint}")
    public static <T> T putToPojo(String endpoint, Object body, Class<T> pojoClass) {
        return given()
                .body(body)
                .put(endpoint)
                .then()
                .extract().body().as(pojoClass);
    }


}
