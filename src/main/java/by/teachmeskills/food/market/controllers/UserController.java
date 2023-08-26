package by.teachmeskills.food.market.controllers;

import by.teachmeskills.food.market.DTO.UserDTO;
import by.teachmeskills.food.market.services.implementation.UserServiceImpl;
import by.teachmeskills.food.market.validators.UserValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserServiceImpl userService;
    private final UserValidator userValidator;


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String formRegistration(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "registration";
    }

    @PostMapping("/registration")
    public String save(@Valid UserDTO userDTO, BindingResult bindingResult, Model model) {
        userValidator.validate(userDTO, bindingResult);
        if (!bindingResult.hasErrors())
        {
            model.addAttribute("noErrors", true);
            UserDTO registration = userService.registration(userDTO);
            log.info("Зарегистрирован пользователь с логином: " + registration.getLogin());
            return "login";
        }
        model.addAttribute("userDTO", userDTO);
        return "registration";
    }
}
