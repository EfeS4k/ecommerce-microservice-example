package efes.dev.microservice.customerservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {
    private Integer id;
    private String name;
    private String surname;
    private String city;
    private String country;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
