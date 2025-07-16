package efes.dev.microservice.categoryservice.repository;

import efes.dev.microservice.categoryservice.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    // create: save(entity), read: findById(id), findAll(),
    // Update: save(entity), DELETE: delete(entity), deleteById(id)
    // These methods are built-in methods.
    Optional<Category> findByName(String name);
}
