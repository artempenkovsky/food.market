package by.teachmeskills.food.market.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDTO {

    private String name;

    private String description;

    private Double price;

    private String measurementUnit;

    private Long categoryId;
}
