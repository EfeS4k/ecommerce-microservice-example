package data;

import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class CategoryRequest {
    @NotNull
    private String categoryName;
}
