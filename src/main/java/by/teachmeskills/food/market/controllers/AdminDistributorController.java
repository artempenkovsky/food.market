package by.teachmeskills.food.market.controllers;

import by.teachmeskills.food.market.DTO.ProductCategoryDTO;
import by.teachmeskills.food.market.DTO.UserDTO;
import by.teachmeskills.food.market.services.implementation.DistributorServiceImpl;
import by.teachmeskills.food.market.services.implementation.ProductCategoryServiceImpl;
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
    private final ProductCategoryServiceImpl productCategoryService;
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
    @GetMapping("/productCategories")
    public String getAllCategories(Model model) {
        List<ProductCategoryDTO> allProductCategories = productCategoryService.getAllProductCategories();
        model.addAttribute("productCategories", allProductCategories);
        return "/admin/adminProductCategories";
    }
    @PostMapping("/createCategory")
    public String createCategory (ProductCategoryDTO productCategoryDTO){
        productCategoryService.createProductCategory(productCategoryDTO);
        return "redirect:/api/v1/admin/distributors/productCategories";
    }
}
