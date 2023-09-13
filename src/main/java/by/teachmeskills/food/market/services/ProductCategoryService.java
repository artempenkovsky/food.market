package by.teachmeskills.food.market.services;

import by.teachmeskills.food.market.DTO.ProductCategoryDTO;

import java.util.List;

public interface ProductCategoryService {
    void createProductCategory(ProductCategoryDTO productCategoryDTO);

    List<ProductCategoryDTO> getAllProductCategories();
}
