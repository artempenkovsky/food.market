package by.teachmeskills.food.market.transformers;

import by.teachmeskills.food.market.DTO.ProductRequestDTO;
import by.teachmeskills.food.market.models.Product;
import by.teachmeskills.food.market.models.User;
import by.teachmeskills.food.market.repositories.ProductCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TransformerProductRequestDTOToProduct extends Transformer<Product, ProductRequestDTO>{
    private final ProductCategoryRepository productCategoryRepository;
    @Override
    public Product transform(ProductRequestDTO productRequestDTO) {
        Product product = new Product();
        product.setName(productRequestDTO.getName());
        product.setDescription(productRequestDTO.getDescription());
        product.setPrice(productRequestDTO.getPrice());
        product.setMeasurementUnit(productRequestDTO.getMeasurementUnit());
        product.setActive(true);
        product.setProductCategory(productCategoryRepository
                .findById(productRequestDTO.getCategoryId())
                .get());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        product.setDistributor(user);
        return product;
    }
}
