package by.teachmeskills.food.market.services.implementation;

import by.teachmeskills.food.market.DTO.BasketDTO;
import by.teachmeskills.food.market.DTO.ProductDTO;
import by.teachmeskills.food.market.models.*;
import by.teachmeskills.food.market.repositories.OrderRepository;
import by.teachmeskills.food.market.repositories.OrderStatusRepository;
import by.teachmeskills.food.market.repositories.ProductOrderRepository;
import by.teachmeskills.food.market.repositories.ProductRepository;
import by.teachmeskills.food.market.services.ProductService;
import by.teachmeskills.food.market.transformers.TransformerProductToProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final TransformerProductToProductDTO transformerProductToProductDTO;
    private final OrderStatusRepository orderStatusRepository;
    private final OrderRepository orderRepository;
    private final ProductOrderRepository productOrderRepository;

    @Override
    public List<ProductDTO> getAllProduct() {
        return productRepository.findAll().stream().filter(product -> product.getActive())
                .map(product -> transformerProductToProductDTO.transform(product))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProductById(Long productId) {
        Product product = productRepository.findById(productId).orElse(new Product());
        return transformerProductToProductDTO.transform(product);
    }

    @Override
    public void addProductToOrder(Long productId) {
        Order order = new Order();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        order.setUser(user);
        OrderStatus orderStatus = orderStatusRepository.findByName("NEW").get();
        order.setOrderStatus(orderStatus);
        order.setDateOfOrdering(LocalDate.now());
        ProductOrder productOrder = new ProductOrder();
        Product product = productRepository.findById(productId).get();
        productOrder.setOrder(order);
        productOrder.setProduct(product);
        productOrder.setQuantity(1.0);
        List<ProductOrder> productOrders = order.getProductOrders();
        productOrders.add(productOrder);
        order.setProductOrders(productOrders);
        Order save = orderRepository.save(order);
    }

    @Override
    public List<BasketDTO> getMyBasket() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        List<Order> orders = orderRepository.findByUser(user);
        List<BasketDTO> result = new ArrayList<>();
        for (Order order : orders) {

            List<ProductOrder> productOrders = order.getProductOrders();
            for (ProductOrder productOrder : productOrders) {
                BasketDTO basketDTO = new BasketDTO();
                Product product = productOrder.getProduct();
                basketDTO.setProductId(product.getId());
                basketDTO.setName(product.getName());
                basketDTO.setDescription(product.getDescription());
                basketDTO.setPrice(product.getPrice());
                basketDTO.setCount(productOrder.getQuantity());
                basketDTO.setAmount(basketDTO.getCount() * basketDTO.getPrice());
                result.add(basketDTO);
            }
        }
        return result;
    }
}
