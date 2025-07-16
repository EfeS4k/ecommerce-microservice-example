package efes.dev.microservice.categoryservice.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class CategoryRequest {
    @NotNull
    private String name;
}
