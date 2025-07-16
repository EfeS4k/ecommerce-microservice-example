package efes.dev.microservice.customerservice.service;

import efes.dev.microservice.customerservice.mapper.CustomerMapper;
import efes.dev.microservice.customerservice.repository.CustomerRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;
    @PersistenceContext
    private EntityManager entityManager;
}
