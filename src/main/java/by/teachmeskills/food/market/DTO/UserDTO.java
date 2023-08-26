package by.teachmeskills.food.market.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;

    @NotEmpty(message = "Поле имя не должно быть пустым")
    @Pattern(regexp = "[А-Я][а-я]*", message = "Имя должно начитаться с заглавной буквы")
    @Size(min = 2, max = 20)
    private String name;

    @NotEmpty(message = "Поле фамилия не должно быть пустым")
    @Pattern(regexp = "[А-Я][а-я]*", message = "Фамилия должна начитаться с заглавной буквы")
    @Size(min = 2, max = 20, message = "Количество символов должно быть от 2 до 20 включительно")
    private String surName;

    @NotEmpty(message = "Поле имя не должно быть пустым")
    @Size(min = 5, max = 20, message = "Количество символов должно быть от 5 до 20 включительно")
    private String login;

    @NotEmpty(message = "Поле password не должно быть пустым")
    @Size(min = 5, max = 20, message = "Количество символов должно быть от 5 до 20 включительно")
    private String password;

    @NotEmpty(message = "Поле confirmPassword не должно быть пустым")
    @Size(min = 5, max = 20, message = "Количество символов должно быть от 5 до 20 включительно")
    private String confirmPassword;
}
