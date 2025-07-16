package efes.dev.microservice.customerservice.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.*;

import java.sql.Timestamp;

@Entity
@SQLDelete(sql = "UPDATE customer SET is_deleted = true WHERE id = ?")
@FilterDef(
        name = "deleteCustomerFilter",
        parameters = @ParamDef(name = "isDeleted", type = boolean.class)
)
@Filter(
        name = "deleteCustomerFilter",
        condition = "isDeleted = :isDeleted"
)
@Builder(toBuilder = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq_gen")
    @SequenceGenerator(
            name = "customer_seq_gen",
            sequenceName = "customer_seq",
            allocationSize = 10
    )
    private Integer id;
    private String name;
    private String surname;
    @Column(length = 14)
    private String city;
    @Column(length = 50)
    private String country;
    @CreationTimestamp
    @Column(name = "created_at")
    private Timestamp createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private Timestamp updatedAt;
    @Column(name = "is_deleted")
    private boolean isDeleted;
}
