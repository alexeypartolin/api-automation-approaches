package backend.pojo.petcontroller.postaddnewpet.response;


import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder

@JsonIgnoreProperties(ignoreUnknown = true)

public class Category {
    Integer id;
    String name;
}
