package by.teachmeskills.food.market.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long id;

    private String name;

    private String description;

    private Double price;

    private Boolean active;

    private String measurementUnit;

    private ProductCategoryDTO productCategoryDTO;
}
