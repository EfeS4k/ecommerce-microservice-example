package entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.*;

import java.sql.Timestamp;

@Entity
@SQLDelete(sql = "UPDATE category SET is_deleted = true WHERE id = ?")
@FilterDef(
        name = "deleteCategoryFilter",
        parameters = @ParamDef(name = "isDeleted", type = boolean.class)
)
@Filter(
        name = "deleteCategoryFilter",
        condition = "isDeleted = :isDeleted"
)
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq_gen")
    @SequenceGenerator(
            name = "category_seq_gen",
            sequenceName = "category_seq",
            allocationSize = 50
    )
    private Integer id;
    @Column(unique = true)
    private String name;
    @CreationTimestamp
    @Column(name = "created_at")
    private Timestamp createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private Timestamp updatedAt;
    @Column(name = "is_deleted")
    private Boolean isDeleted;
}
