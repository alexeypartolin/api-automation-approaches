package backend;

import backend.context.Context;
import backend.helpers.Endpoints;
import backend.helpers.SpecConfigurator;
import backend.methods.positivemethods.PositiveMethods;
import backend.pojo.petcontroller.getfindpetbyid.PojoResFindPetById;
import backend.pojo.petcontroller.postaddnewpet.request.Tags;
import backend.service.negativemethods.ServiceNegativeMethods;
import backend.service.positivemethods.ServicePositiveMethods;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;
public class PetshopTests {
    @BeforeAll
    public static void beforeAll() {
        SpecConfigurator.installSpec200();
    }

    @Test
    @DisplayName("Коллекция GET-тестов с разными подходами")
    public void CollectionOfDifferentGetTests() {

        // Ниже представлены разные методы написания АТ (GET) на примере простых тестов

        // 0 Создание сущности в БД (подготовка тестовых данных)

        PositiveMethods.Post.postCreateANewPet();
        System.out.println(Context.petId);

        // 1 Вариант (Service + POJO + Assert it test)
        var response1 = ServicePositiveMethods.getResponseCustomMethod(Endpoints.Get.findPetById((int)Context.petId));
        var responseToPojo1 = response1.as(PojoResFindPetById.class);
        Assertions.assertThat(responseToPojo1.getTags().get(0).getName()).isEqualTo("fast");

        // 2 Вариант (Service + JSONPath + Assert in test (Negative test))
        var endpoint2 = Endpoints.Get.findPetById(0);
        var response2 = ServiceNegativeMethods.getResponseCustomMethod(endpoint2);
        var actualResult2 = response2.jsonPath().get("message");
        var expectedResult2 = "Pet not found";

        Assertions.assertThat(actualResult2).isEqualTo(expectedResult2); // Assert на body
        Assertions.assertThat(404).isEqualTo(response2.getStatusCode()); // Assert на statusCode

        // 3 Вариант (T Service method (под Pojo.class) + JSONPath + Assert in test)
        var response3 = ServicePositiveMethods.getToListPojoJsonPathData(
                Endpoints.Get.findPetById((int)Context.petId),
                Tags.class
        );

        Assertions.assertThat(response3.get(0).getName()).isEqualTo("fast");


        // 4 Вариант (T Service method (list) + JSONPath to Pojo + assert in test)

        var response4 = PositiveMethods.Get.getFindPetsByStatus();
        List<String> array = new ArrayList<>();

        for (int i = 0; i < response4.size(); i++) {
            array.add(i, response4.get(i).getId().toString());
        }

        Assertions.assertThat(array).contains(Context.petId.toString());

        // 5 Вариант (PUT T Service method (endpoint, pojo.class) + assert in test)

        var responseBody5 = PositiveMethods.Put.putUpdateAnExistingPet("sold");
        Assertions.assertThat(responseBody5.getStatus()).isEqualTo("sold");

        //



    }


}
