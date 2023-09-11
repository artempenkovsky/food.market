package by.teachmeskills.food.market.controllers;

import by.teachmeskills.food.market.DTO.ProductCategoryDTO;
import by.teachmeskills.food.market.DTO.ProductDTO;
import by.teachmeskills.food.market.DTO.ProductRequestDTO;
import by.teachmeskills.food.market.models.User;
import by.teachmeskills.food.market.services.implementation.DistributorServiceImpl;
import by.teachmeskills.food.market.services.implementation.ProductCategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/v1/distributors")
@RequiredArgsConstructor
public class DistributorController {
    private final DistributorServiceImpl distributorService;
    private final ProductCategoryServiceImpl productCategoryService;

    @GetMapping()
    public String getAllProducts(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        List<ProductDTO> productDTOS = new ArrayList<>();
        if (user.getUserRole().getRole().equals("ROLE_DISTRIBUTOR")) {
            productDTOS = distributorService.getAllProductByDistributor(user);
        }
        model.addAttribute("products", productDTOS);
        List<ProductCategoryDTO> categories = productCategoryService.getAllProductCategories();
        model.addAttribute("categories",categories);
        return "/distributor/getAllProducts";
    }
    @PostMapping("/addProduct")
    public String addProduct (ProductRequestDTO productCategoryDTO){
        distributorService.addProduct(productCategoryDTO);
        return "redirect:/api/v1/distributors";
    }
}
