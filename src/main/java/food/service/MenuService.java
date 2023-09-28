package food.service;

import food.domain.Menu;
import food.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MenuService {
    @Autowired
    MenuRepository menuRepository;

    public Menu getCuisine(String id) {
        Menu searchMenu = menuRepository.findCuisineById(id);

        if(searchMenu == null) {
            return null;
        }

        return searchMenu;
    }

    public List<Menu> getAllCuisines() {
        List<Menu> menus = menuRepository.findAll();

        return menus;
    }

    public Menu createCuisine(Menu menu) {
        menuRepository.save(menu);
        return menu;
    }

    public void saveCuisine(Menu menu) {
        menuRepository.save(menu);
    }
}
