package backend.pojo.petcontroller.postaddnewpet.response;

import backend.pojo.petcontroller.postaddnewpet.request.Category;
import backend.pojo.petcontroller.postaddnewpet.request.Tags;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder

@JsonIgnoreProperties(ignoreUnknown = true)
public class PojoResAddNewPet {
    Integer id;
    String name;
    String status;
    Category category; // JSON объект
    List<Object> photoUrls; // Список объектов (строк)
    List<Tags> tags; // Список JSON объектов
}
