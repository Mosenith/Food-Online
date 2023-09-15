package food.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Food {

    private Long id;

    private Date createdAt;

//    @NotNull
//    @Size(min = 5, message = "Name must have at least 5 characters")
//    private String name;
//
//    @Size(min = 1, message = "You must choose at least 1 menu")
//    private List<Cuisine> types;
}
