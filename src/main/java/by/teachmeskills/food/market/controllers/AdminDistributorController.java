package by.teachmeskills.food.market.controllers;

import by.teachmeskills.food.market.DTO.UserDTO;
import by.teachmeskills.food.market.services.implementation.DistributorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/api/v1/admin/distributors")
@RequiredArgsConstructor
public class AdminDistributorController {
    private final DistributorServiceImpl distributorService;
    @GetMapping()
    public String getAllDistributors(Model model) {
        List<UserDTO> allDistibutors = distributorService.getAllDistibutors();
        model.addAttribute("distributors", allDistibutors);
        return "/admin/adminDistributors";
    }
    @PostMapping("/changeStatusDistributors/{distributorId}")
    public String changeStatusDistributors (@PathVariable Long distributorId){
        distributorService.changeStatusDistributors(distributorId);
        return "redirect:/api/v1/admin/distributors";
    }


}
