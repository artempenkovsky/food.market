package by.teachmeskills.food.market.repositories;

import by.teachmeskills.food.market.models.Product;
import by.teachmeskills.food.market.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByDistributor(User distributor);
}
