package by.teachmeskills.food.market.repositories;

import by.teachmeskills.food.market.models.Order;
import by.teachmeskills.food.market.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);
}
