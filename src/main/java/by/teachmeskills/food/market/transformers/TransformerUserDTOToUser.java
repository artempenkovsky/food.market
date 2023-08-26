package by.teachmeskills.food.market.transformers;

import by.teachmeskills.food.market.DTO.UserDTO;
import by.teachmeskills.food.market.models.User;
import by.teachmeskills.food.market.models.UserRole;
import by.teachmeskills.food.market.repositories.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class TransformerUserDTOToUser {
    private final PasswordEncoder passwordEncoder;
    private final UserRoleRepository userRoleRepository;
    public User transform(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setSurName(userDTO.getSurName());
        user.setLogin(userDTO.getLogin());
        UserRole roleUser = userRoleRepository.findByRole("ROLE_USER").orElseThrow(()-> new RuntimeException("Нельзя создать пользователя с такой ролью!"));
        user.setUserRole(roleUser);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setDateOfCreate(LocalDate.now());
        return user;
    }
}
