package by.teachmeskills.food.market.services;

import by.teachmeskills.food.market.DTO.BasketDTO;
import by.teachmeskills.food.market.DTO.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProduct();

    ProductDTO getProductById(Long productId);

    void addProductToOrder(Long productId);

    List<BasketDTO> getMyBasket();
}
