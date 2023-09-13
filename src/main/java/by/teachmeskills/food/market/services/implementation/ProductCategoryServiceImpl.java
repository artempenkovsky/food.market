package by.teachmeskills.food.market.services.implementation;

import by.teachmeskills.food.market.DTO.ProductCategoryDTO;
import by.teachmeskills.food.market.models.ProductCategory;
import by.teachmeskills.food.market.repositories.ProductCategoryRepository;
import by.teachmeskills.food.market.services.ProductCategoryService;
import by.teachmeskills.food.market.transformers.TransformerProductCategoryDTOToProductCategory;
import by.teachmeskills.food.market.transformers.TransformerProductCategoryToProductCategoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductCategoryServiceImpl implements ProductCategoryService {
    private final ProductCategoryRepository productCategoryRepository;
    private final TransformerProductCategoryDTOToProductCategory transformer;
    private final TransformerProductCategoryToProductCategoryDTO transformerProductCategoryToProductCategoryDTO;

    @Override
    public void createProductCategory(ProductCategoryDTO productCategoryDTO) {
        productCategoryRepository.save(transformer.transform(productCategoryDTO));
    }

    @Override
    public List<ProductCategoryDTO> getAllProductCategories() {
        List<ProductCategory> categoryRepositoryAll = productCategoryRepository.findAll();
        return categoryRepositoryAll.stream().map(transformerProductCategoryToProductCategoryDTO::transform)
                .collect(Collectors.toList());
    }
}
