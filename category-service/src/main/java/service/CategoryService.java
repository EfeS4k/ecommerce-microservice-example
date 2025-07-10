package service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.CategoryRepository;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository repository;

}
