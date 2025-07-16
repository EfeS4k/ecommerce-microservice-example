package efes.dev.microservice.customerservice.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotNull
    @Size(min = 1, max = 14)
    private String city;
    @NotNull
    @Size(min = 1, max = 50)
    private String country;
}

