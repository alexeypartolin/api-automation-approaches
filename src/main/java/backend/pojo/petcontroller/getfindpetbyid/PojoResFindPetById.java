package backend.pojo.petcontroller.getfindpetbyid;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder

@JsonIgnoreProperties(ignoreUnknown = true)
public class PojoResFindPetById {
    private Long id;
    private String name;
    private String status;
    private List<Object> photoUrls; // Массив строк
    private Category category; // JSON объект
    private List<Tags> tags; // массив JSON объектов
}
