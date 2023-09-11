package by.teachmeskills.food.market.transformers;

import by.teachmeskills.food.market.DTO.ProductCategoryDTO;
import by.teachmeskills.food.market.models.ProductCategory;
import org.springframework.stereotype.Component;

@Component
public class TransformerProductCategoryToProductCategoryDTO extends Transformer<ProductCategoryDTO, ProductCategory>{
    @Override
    public ProductCategoryDTO transform(ProductCategory productCategory) {
        return ProductCategoryDTO
                .builder()
                .id(productCategory.getId())
                .name(productCategory.getName())
                .priority(productCategory.getPriority())
                .build();
    }
}
