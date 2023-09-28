package food.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 5, message = "Name must have at least 5 characters")
    private String name;

    private Date createdAt;

    @ManyToMany(targetEntity = Menu.class)
    @Size(min = 1, message = "You must choose at least 1 menu")
    private List<Menu> menu;

    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }

}
