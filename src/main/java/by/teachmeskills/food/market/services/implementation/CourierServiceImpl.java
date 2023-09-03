package by.teachmeskills.food.market.services.implementation;

import by.teachmeskills.food.market.DTO.UserDTO;
import by.teachmeskills.food.market.models.User;
import by.teachmeskills.food.market.models.UserRole;
import by.teachmeskills.food.market.repositories.UserRepository;
import by.teachmeskills.food.market.repositories.UserRoleRepository;
import by.teachmeskills.food.market.services.CourierService;
import by.teachmeskills.food.market.transformers.TransformerUserDTOToUser;
import by.teachmeskills.food.market.transformers.TransformerUserToUserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourierServiceImpl implements CourierService {
    private final TransformerUserDTOToUser transformerUserDTOToUser;
    private final UserRepository userRepository;
    private final TransformerUserToUserDTO transformerUserToUserDTO;
    private final UserRoleRepository userRoleRepository;

    @Override
    public UserDTO registration(UserDTO userDTO) {
        User user = transformerUserDTOToUser.transform(userDTO);
        UserRole roleUser = userRoleRepository.findByRole("ROLE_COURIER").orElseThrow(()-> new RuntimeException("Нельзя создать пользователя с такой ролью!"));
        user.setUserRole(roleUser);
        user.setApproved(false);
        User save = userRepository.save(user);
        return transformerUserToUserDTO.transform(save);
    }
}
