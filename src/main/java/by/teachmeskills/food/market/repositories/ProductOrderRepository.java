package by.teachmeskills.food.market.repositories;

import by.teachmeskills.food.market.models.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, Long> {
}
