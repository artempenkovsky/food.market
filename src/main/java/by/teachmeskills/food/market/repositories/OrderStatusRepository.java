package by.teachmeskills.food.market.repositories;

import by.teachmeskills.food.market.models.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderStatusRepository extends JpaRepository<OrderStatus, Long> {
    Optional <OrderStatus> findByName(String name);
}
