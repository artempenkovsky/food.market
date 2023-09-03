package by.teachmeskills.food.market.controllers;

import by.teachmeskills.food.market.DTO.UserDTO;
import by.teachmeskills.food.market.services.implementation.CourierServiceImpl;
import by.teachmeskills.food.market.services.implementation.DistributorServiceImpl;
import by.teachmeskills.food.market.services.implementation.UserServiceImpl;
import by.teachmeskills.food.market.validators.UserValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/registration")
@RequiredArgsConstructor
@Slf4j
public class RegistrationController {
    private final UserServiceImpl userService;
    private final UserValidator userValidator;
    private final CourierServiceImpl courierService;
    private final DistributorServiceImpl distributorService;
    @PostMapping()
    public String saveUser(@Valid UserDTO userDTO, BindingResult bindingResult, Model model) {
        userValidator.validate(userDTO, bindingResult);
        if (!bindingResult.hasErrors()) {
            model.addAttribute("noErrors", true);
            UserDTO registration = userService.registration(userDTO);
            log.info("Зарегистрирован пользователь с логином: " + registration.getLogin());
            return "login";
        }
        model.addAttribute("userDTO", userDTO);
        return "registration";
    }
    @PostMapping("/courier")
    public String saveCourier(@Valid UserDTO userDTO, BindingResult bindingResult, Model model) {
        userValidator.validate(userDTO, bindingResult);
        if (!bindingResult.hasErrors()) {
            model.addAttribute("noErrors", true);
            UserDTO registration = courierService.registration(userDTO);
            log.info("Зарегистрирован курьер с логином: " + registration.getLogin());
            return "login";
        }
        model.addAttribute("userDTO", userDTO);
        return "registration";
    }

    @PostMapping("/distributor")
    public String saveDistributor(@Valid UserDTO userDTO, BindingResult bindingResult, Model model) {
        userValidator.validate(userDTO, bindingResult);
        if (!bindingResult.hasErrors()) {
            model.addAttribute("noErrors", true);
            UserDTO registration = distributorService.registration(userDTO);
            log.info("Зарегистрирован дистрибьютор с логином: " + registration.getLogin());
            return "login";
        }
        model.addAttribute("userDTO", userDTO);
        return "registration";
    }
}
