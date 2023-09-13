package by.teachmeskills.food.market.repositories;

import by.teachmeskills.food.market.models.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
