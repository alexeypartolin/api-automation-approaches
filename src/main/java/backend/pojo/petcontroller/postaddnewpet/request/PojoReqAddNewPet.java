package backend.pojo.petcontroller.postaddnewpet.request;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder

@JsonIgnoreProperties(ignoreUnknown = true)
public class PojoReqAddNewPet {
    Integer id;
    String name;
    String status;
    Category category; // JSON объект
    List<Object> photoUrls; // Список объектов (строк)
    List<Tags> tags; // Список JSON объектов
}
