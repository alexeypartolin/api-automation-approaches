package backend.pojo.petcontroller.putupdateanexistingpet.response;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder

@JsonIgnoreProperties(ignoreUnknown = true)

public class Tags {
    Integer id;
    String name;
}
