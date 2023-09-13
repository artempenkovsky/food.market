package by.teachmeskills.food.market.services.implementation;

import by.teachmeskills.food.market.DTO.ProductDTO;
import by.teachmeskills.food.market.DTO.ProductRequestDTO;
import by.teachmeskills.food.market.DTO.UserDTO;
import by.teachmeskills.food.market.models.User;
import by.teachmeskills.food.market.models.UserRole;
import by.teachmeskills.food.market.repositories.ProductRepository;
import by.teachmeskills.food.market.repositories.UserRepository;
import by.teachmeskills.food.market.repositories.UserRoleRepository;
import by.teachmeskills.food.market.services.DistributorService;
import by.teachmeskills.food.market.transformers.TransformerProductRequestDTOToProduct;
import by.teachmeskills.food.market.transformers.TransformerProductToProductDTO;
import by.teachmeskills.food.market.transformers.TransformerUserDTOToUser;
import by.teachmeskills.food.market.transformers.TransformerUserToUserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DistributorServiceImpl implements DistributorService {
    private final TransformerUserDTOToUser transformerUserDTOToUser;
    private final UserRepository userRepository;
    private final TransformerUserToUserDTO transformerUserToUserDTO;
    private final UserRoleRepository userRoleRepository;
    private final ProductRepository productRepository;
    private final TransformerProductToProductDTO transformerProductToProductDTO;
    private final TransformerProductRequestDTOToProduct transformerProductRequestDTOToProduct;

    @Override
    public UserDTO registration(UserDTO userDTO) {
        User user = transformerUserDTOToUser.transform(userDTO);
        UserRole roleUser = userRoleRepository.findByRole("ROLE_DISTRIBUTOR").orElseThrow(() -> new RuntimeException("Нельзя создать пользователя с такой ролью!"));
        user.setUserRole(roleUser);
        user.setApproved(false);
        User save = userRepository.save(user);
        return transformerUserToUserDTO.transform(save);
    }

    @Override
    public List<UserDTO> getAllDistibutors() {
        List<User> all = userRepository.findAll();
        return all.stream()
                .filter(user -> user
                        .getUserRole()
                        .getRole()
                        .equals("ROLE_DISTRIBUTOR"))
                .sorted(Comparator.comparing(User::getId))
                .map(transformerUserToUserDTO::transform)
                .collect(Collectors.toList());
    }

    @Override
    public void changeStatusDistributors(Long distributorId) {
        Optional<User> byId = userRepository.findById(distributorId);
        if (byId.isPresent()) {
            User user = byId.get();
            user.setApproved(!user.getApproved());
            userRepository.save(user);
        }
    }

    @Override
    public List<ProductDTO> getAllProductByDistributor(User user) {
        return productRepository.findAllByDistributor(user)
                .stream()
                .map(transformerProductToProductDTO::transform)
                .collect(Collectors.toList());
    }

    @Override
    public void addProduct(ProductRequestDTO productRequestDTO) {
        productRepository.save(transformerProductRequestDTOToProduct.transform(productRequestDTO));
    }
}
