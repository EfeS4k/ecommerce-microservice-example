package efes.dev.microservice.categoryservice.service;

import efes.dev.microservice.categoryservice.dto.CategoryRequest;
import efes.dev.microservice.categoryservice.dto.CategoryResponse;
import efes.dev.microservice.categoryservice.entity.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import efes.dev.microservice.categoryservice.mapper.CategoryMapper;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import efes.dev.microservice.categoryservice.repository.CategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository repository;
    private final CategoryMapper mapper;

    @PersistenceContext
    private EntityManager entityManager;

    public CategoryResponse save(CategoryRequest t) {
        Category category = Category.builder()
                .name(t.getName()).
                build();
        Category saved = repository.save(category);
        return mapper.toResponse(saved);
    }

    public CategoryResponse findById(Integer id) {
        Category category = repository.findById(id).orElse(null);
        return mapper.toResponse(category);
    }

    public CategoryResponse deleteById(Integer id){
        Category category = repository.findById(id).orElse(null);
        repository.delete(category);
        return mapper.toResponse(category);
    }

    public CategoryResponse update(CategoryRequest t, Integer id){
        Category category = repository.findById(id).orElse(null);
        Category updated = category.toBuilder()
                .name(t.getName())
                .build();
        Category saved = repository.save(updated);
        return mapper.toResponse(saved);
    }

    public List<CategoryResponse> findAll(){
        Session session = entityManager.unwrap(Session.class);
        session.enableFilter("deleteCategoryFilter").setParameter("isDeleted", false);
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }
}
