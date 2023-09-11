package by.teachmeskills.food.market.transformers;

import by.teachmeskills.food.market.DTO.ProductCategoryDTO;
import by.teachmeskills.food.market.models.ProductCategory;
import org.springframework.stereotype.Component;

@Component
public class TransformerProductCategoryDTOToProductCategory extends Transformer<ProductCategory, ProductCategoryDTO>{
    @Override
    public ProductCategory transform(ProductCategoryDTO productCategoryDTO) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(productCategoryDTO.getId());
        productCategory.setName(productCategoryDTO.getName());
        productCategory.setPriority(productCategoryDTO.getPriority());
        return productCategory;
    }
}
