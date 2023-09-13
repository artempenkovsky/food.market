package by.teachmeskills.food.market.controllers;

import by.teachmeskills.food.market.DTO.BasketDTO;
import by.teachmeskills.food.market.DTO.ProductDTO;
import by.teachmeskills.food.market.services.implementation.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/v1/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ProductServiceImpl productService;
    @GetMapping()
    public String getAllProducts(Model model) {
        List<ProductDTO> products = productService.getAllProduct();
        model.addAttribute("products",products);
        List<BasketDTO> baskets= productService.getMyBasket();
        model.addAttribute("baskets",baskets);
        return "/client/getAllProducts";
    }
    @GetMapping("/infoProduct/{productId}")
    public String infoProduct(@PathVariable Long productId, Model model) {
        ProductDTO product = productService.getProductById(productId);
        model.addAttribute("product",product);
        return "/client/infoProduct";
    }
    @PostMapping("/addProductToOrder/{productId}")
    public String addProductToOrder (@PathVariable Long productId){
        productService.addProductToOrder(productId);
        return "redirect:/api/v1/clients";
    }

}
