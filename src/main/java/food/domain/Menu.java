package food.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Menu {
    private final String id;
    private final String name;
    private final Type type;
    public static enum Type {
        FAST_FOOD, ASIAN, JAPANESE, WESTERN, FRENCH, ITALIAN
    }
}
