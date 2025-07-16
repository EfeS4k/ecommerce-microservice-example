package efes.dev.microservice.categoryservice.mapper;

import efes.dev.microservice.categoryservice.dto.CategoryResponse;
import efes.dev.microservice.categoryservice.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryResponse toResponse(Category category);
}
