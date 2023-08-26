package by.teachmeskills.food.market.repositories;

import by.teachmeskills.food.market.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);

}
