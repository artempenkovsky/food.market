package by.teachmeskills.food.market.validators;

import by.teachmeskills.food.market.DTO.UserDTO;
import by.teachmeskills.food.market.models.User;
import by.teachmeskills.food.market.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class UserValidator implements Validator {
    private final UserRepository userRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return UserDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDTO userDTO = (UserDTO) target;
        if (!userDTO.getConfirmPassword().equals(userDTO.getPassword())){
            errors.rejectValue("confirmPassword","DIFFERENT","Введенные пароли не совпадают!");
        }
        User user = userRepository.findByLogin(userDTO.getLogin());
        if (user != null){
            errors.rejectValue("login","DIFFERENT","Пользователь с таким логином уже существует в системе!");
        }
    }

}
