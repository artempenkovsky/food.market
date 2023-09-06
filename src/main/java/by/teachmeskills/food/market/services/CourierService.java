package by.teachmeskills.food.market.services;

import by.teachmeskills.food.market.DTO.UserDTO;

import java.util.List;

public interface CourierService {
    UserDTO registration (UserDTO userDTO);

    List<UserDTO> getAllCouriers();

    void changeStatusCouriers(Long courierId);
}
