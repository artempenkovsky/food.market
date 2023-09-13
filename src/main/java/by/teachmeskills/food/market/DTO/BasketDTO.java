package by.teachmeskills.food.market.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BasketDTO {
    private Long productId;
    private String name;
    private String description;
    private Double price;
    private Double count;
    private Double amount;
}
