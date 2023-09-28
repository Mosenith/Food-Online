package food.controller;

import food.domain.Food;
import food.repository.FoodRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/foods", produces = "application/json")
@CrossOrigin(origins = "http://foodonline:8080") // Restrict clients consuming API, only from port 8080
public class FoodController {
    private FoodRepository foodRepository;

    public FoodController(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @GetMapping(params = "recent")
    public Iterable<Food> recentFoods() {
        PageRequest page = PageRequest.of(
                0, 12, Sort.by("createdAt").descending()
        );
        return foodRepository.findAll(page).getContent();
    }

    @GetMapping("/{id}")
    public Optional<Food> getFoodById(@PathVariable("id") Long id) {
        return foodRepository.findById(id);
    }
}
