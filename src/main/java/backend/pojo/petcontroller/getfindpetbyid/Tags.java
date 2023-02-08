package backend.pojo.petcontroller.getfindpetbyid;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder

@JsonIgnoreProperties(ignoreUnknown = true)
public class Tags {
    Long id;
    String name;
}