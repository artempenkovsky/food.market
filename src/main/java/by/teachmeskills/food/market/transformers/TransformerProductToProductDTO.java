package by.teachmeskills.food.market.transformers;

import by.teachmeskills.food.market.DTO.ProductDTO;
import by.teachmeskills.food.market.models.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TransformerProductToProductDTO extends Transformer<ProductDTO, Product> {
    private final TransformerProductCategoryToProductCategoryDTO transformerProductCategoryToProductCategoryDTO;
    @Override
    public ProductDTO transform(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setDescription(product.getDescription());
        productDTO.setMeasurementUnit(product.getMeasurementUnit());
        productDTO.setActive(product.getActive());
        productDTO.setProductCategoryDTO(transformerProductCategoryToProductCategoryDTO
                .transform(product.getProductCategory()));
        return productDTO;
    }
}
