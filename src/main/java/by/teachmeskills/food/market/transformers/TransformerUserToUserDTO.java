package by.teachmeskills.food.market.transformers;

import by.teachmeskills.food.market.DTO.UserDTO;
import by.teachmeskills.food.market.models.User;
import org.springframework.stereotype.Component;

@Component
public class TransformerUserToUserDTO extends Transformer<UserDTO, User> {
    @Override
    public UserDTO transform(User user) {
        return UserDTO
                .builder()
                .id(user.getId())
                .login(user.getLogin())
                .name(user.getName())
                .surName(user.getSurName())
                .build();
    }
}
