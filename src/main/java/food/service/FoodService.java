package food.service;

import food.domain.Food;
import food.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodService {
    @Autowired
    FoodRepository foodRepository;

    public Food createFood(Food food) {
        foodRepository.save(food);
        return food;
    }
}
