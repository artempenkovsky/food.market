package by.teachmeskills.food.market.services.implementation;

import by.teachmeskills.food.market.DTO.UserDTO;
import by.teachmeskills.food.market.models.User;
import by.teachmeskills.food.market.repositories.UserRepository;
import by.teachmeskills.food.market.services.UserService;
import by.teachmeskills.food.market.transformers.TransformerUserDTOToUser;
import by.teachmeskills.food.market.transformers.TransformerUserToUserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final TransformerUserDTOToUser transformerUserDTOToUser;
    private final UserRepository userRepository;
    private final TransformerUserToUserDTO transformerUserToUserDTO;

    @Override
    public UserDTO registration(UserDTO userDTO) {
        User user = transformerUserDTOToUser.transform(userDTO);
        User save = userRepository.save(user);
        return transformerUserToUserDTO.transform(save);
    }
}
