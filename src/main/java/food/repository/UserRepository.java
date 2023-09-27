package food.repository;

import food.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    // used to look up User by their Username
    User findByUsername(String username);
}
