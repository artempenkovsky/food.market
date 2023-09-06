package by.teachmeskills.food.market.controllers;

import by.teachmeskills.food.market.DTO.UserDTO;
import by.teachmeskills.food.market.services.implementation.CourierServiceImpl;
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
@RequestMapping("/api/v1/admin/couriers")
@RequiredArgsConstructor
public class AdminCourierController {
    private final CourierServiceImpl courierService;
    @GetMapping()
    public String getAllCouriers(Model model) {
        List<UserDTO> allCouriers = courierService.getAllCouriers();
        model.addAttribute("couriers", allCouriers);
        return "/admin/adminCouriers";
    }
    @PostMapping("/changeStatusCouriers/{courierId}")
    public String changeStatusCouriers (@PathVariable Long courierId){
        courierService.changeStatusCouriers(courierId);
        return "redirect:/api/v1/admin/couriers";
    }
}
