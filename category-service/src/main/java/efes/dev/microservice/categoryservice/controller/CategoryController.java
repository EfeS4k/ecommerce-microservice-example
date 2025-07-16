package efes.dev.microservice.categoryservice.controller;

import efes.dev.microservice.categoryservice.dto.CategoryRequest;
import efes.dev.microservice.categoryservice.dto.CategoryResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import efes.dev.microservice.categoryservice.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
@Tag(name = "Category", description = "Category Management API's")
public class CategoryController {
    private final CategoryService categoryService;

    @Operation(
            summary = "Create new category.",
            description = "Creates new category with given name."
    )
    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory(@Valid @RequestBody CategoryRequest categoryRequest) {

        CategoryResponse categoryResponse = categoryService.save(categoryRequest);
        return ResponseEntity.ok(categoryResponse);
    }

    @Operation(
            summary = "Get Category by Id",
            description = "Get the category for given id."
    )
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getCategoryById(@PathVariable Integer id) {
        CategoryResponse categoryResponse = categoryService.findById(id);
        return ResponseEntity.ok(categoryResponse);
    }

    @Operation(
            summary = "Update the Category of given id.",
            description = "Updates existing Category entity with given id."
    )
    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> updateCategoryById(
            @PathVariable Integer id,
            @Valid @RequestBody CategoryRequest categoryRequest) {
        CategoryResponse categoryResponse = categoryService.update(categoryRequest, id);
        return ResponseEntity.ok(categoryResponse);
    }

    @Operation(
            summary = "Delete category by id.",
            description = "Deletes the Category with given id."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<CategoryResponse> deleteCategoryById(@PathVariable Integer id) {
        CategoryResponse categoryResponse = categoryService.deleteById(id);
        return ResponseEntity.ok(categoryResponse);
    }

    @Operation(
            summary = "Get Category List.",
            description = "Get all of the categories that are not deleted before."
    )
    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAllCategories() {
        List<CategoryResponse> categoryResponses = categoryService.findAll();
        return ResponseEntity.ok(categoryResponses);
    }
}
