package food;

import food.domain.Food;
import food.domain.Menu;
import food.repository.FoodRepository;
import food.repository.MenuRepository;
import food.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class FoodOnlineApplication implements CommandLineRunner {

	@Autowired
	private FoodRepository foodRepo;

	@Autowired
	private MenuRepository menuRepo;

	@Autowired
	private UserRepository userRepo;

	public static void main(String[] args) {
		SpringApplication.run(FoodOnlineApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Menu pizzaMenu = new Menu("PZ", "Pizza", Menu.Type.FAST_FOOD);
		Menu phoMenu = new Menu("PH", "Pho", Menu.Type.ASIAN);
		Menu macaronMenu = new Menu("MC", "Macaron", Menu.Type.FRENCH);
		Menu sushiMenu = new Menu("SS", "Sushi", Menu.Type.JAPANESE);
		Menu ramenMenu = new Menu("RM", "Ramen", Menu.Type.JAPANESE);
		Menu burgerMenu = new Menu("HB", "Ham Burger", Menu.Type.FAST_FOOD);

		menuRepo.save(pizzaMenu);
		menuRepo.save(phoMenu);
		menuRepo.save(macaronMenu);
		menuRepo.save(sushiMenu);
		menuRepo.save(ramenMenu);
		menuRepo.save(burgerMenu);

//		System.out.println(pizzaMenu.toString());

		Food food1 = new Food();
		food1.setName("ChrisFood");
		food1.setMenu(Arrays.asList(pizzaMenu, phoMenu, sushiMenu));
		foodRepo.save(food1);


		Food food2 = new Food();
		food2.setName("JessFood");
		food2.setMenu(Arrays.asList(ramenMenu, phoMenu, macaronMenu));
		foodRepo.save(food2);


		Food food3 = new Food();
		food3.setName("JohnFood");
		food3.setMenu(Arrays.asList(burgerMenu, sushiMenu));
		foodRepo.save(food3);
	}
}
