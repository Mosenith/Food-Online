package food.controller;

import food.domain.Menu;
import food.domain.Menu.Type;
import food.domain.Food;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignFoodController {
    @GetMapping
    public String showDesignForm(Model model) {
        List<Menu> menus = Arrays.asList(
                new Menu("PH", "Pho", Menu.Type.ASIAN),
                new Menu("PT", "Pad Thai", Menu.Type.ASIAN),
                new Menu("HB", "Ham Burger", Menu.Type.FAST_FOOD),
                new Menu("PZ", "Pizza", Menu.Type.FAST_FOOD),
                new Menu("CS", "Croissant", Menu.Type.FRENCH),
                new Menu("MC", "Macaron", Menu.Type.FRENCH),
                new Menu("TS", "Tartar Steak", Menu.Type.FRENCH),
                new Menu("GC", "Gnocchi", Menu.Type.ITALIAN),
                new Menu("PN", "Pizza Napoletana", Menu.Type.ITALIAN),
                new Menu("SP", "Spaghetti", Menu.Type.ITALIAN),
                new Menu("KC", "Karage Chicken", Menu.Type.JAPANESE),
                new Menu("SS", "Sushi", Menu.Type.JAPANESE),
                new Menu("RM", "Ramen", Menu.Type.JAPANESE)
        );

        List<Menu> asians = menus.stream()
                .filter(x -> x.getType().equals(Type.ASIAN))
                .collect(Collectors.toList());

        List<Menu> fastFoods = menus.stream()
                .filter(x -> x.getType().equals(Type.FAST_FOOD))
                .collect(Collectors.toList());

        List<Menu> french = menus.stream()
                .filter(x -> x.getType().equals(Type.FRENCH))
                .collect(Collectors.toList());

        List<Menu> italian = menus.stream()
                .filter(x -> x.getType().equals(Type.ITALIAN))
                .collect(Collectors.toList());

        List<Menu> japanese = menus.stream()
                .filter(x -> x.getType().equals(Type.JAPANESE))
                .collect(Collectors.toList());

        model.addAttribute("asians", asians);
        model.addAttribute("fastFoods", fastFoods);
        model.addAttribute("french", french);
        model.addAttribute("italian", italian);
        model.addAttribute("japanese", japanese);
        model.addAttribute("design", new Food());

        return "design";
    }

    @PostMapping
    public String processDesign(@Valid Food design, Errors errors) {
        if(errors.hasErrors()) {
            return "design";
        }

        log.info("Processing design: " + design);
        return "redirect:/orders/current";
    }
}
