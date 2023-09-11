package by.teachmeskills.food.market.services;

import by.teachmeskills.food.market.DTO.ProductDTO;
import by.teachmeskills.food.market.DTO.ProductRequestDTO;
import by.teachmeskills.food.market.DTO.UserDTO;
import by.teachmeskills.food.market.models.User;

import java.util.List;

public interface DistributorService {
    UserDTO registration (UserDTO userDTO);
    List<UserDTO> getAllDistibutors ();

    void changeStatusDistributors(Long distributorId);

    List<ProductDTO> getAllProductByDistributor(User user);

    void addProduct(ProductRequestDTO productCategoryDTO);
}
