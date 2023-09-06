package by.teachmeskills.food.market.services;

import by.teachmeskills.food.market.DTO.UserDTO;

import java.util.List;

public interface DistributorService {
    UserDTO registration (UserDTO userDTO);
    List<UserDTO> getAllDistibutors ();

    void changeStatusDistributors(Long distributorId);
}
