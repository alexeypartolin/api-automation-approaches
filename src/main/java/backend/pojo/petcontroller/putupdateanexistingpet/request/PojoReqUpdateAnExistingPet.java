package backend.pojo.petcontroller.putupdateanexistingpet.request;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder

@JsonIgnoreProperties(ignoreUnknown = true)
public class PojoReqUpdateAnExistingPet {
    Integer id;
    String name;
    String status;
    Category category; // JSON объект
    List<Object> photoUrls; // Список объектов (строк)
    List<Tags> tags; // Список JSON объектов
}
