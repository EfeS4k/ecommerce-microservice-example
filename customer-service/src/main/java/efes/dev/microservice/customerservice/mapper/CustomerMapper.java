package efes.dev.microservice.customerservice.mapper;

import efes.dev.microservice.customerservice.dto.CustomerResponse;
import efes.dev.microservice.customerservice.entity.Customer;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    CustomerResponse toReponse(Customer customer);
}
