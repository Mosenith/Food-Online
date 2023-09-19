package food.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class Menu {
    @Id
    private String id;
    private String name;
    private Type type;

    public static enum Type {
        FAST_FOOD, ASIAN, JAPANESE, WESTERN, FRENCH, ITALIAN
    }
}
