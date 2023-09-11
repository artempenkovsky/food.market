package by.teachmeskills.food.market.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<ProductOrder> productOrders = new ArrayList<>();

    @Column
    private Double price;

    @Column
    private Boolean active;

    @Column(name = "measurement_unit")
    private String measurementUnit;

    @ManyToOne
    @JoinColumn(name = "distributor_id")
    private User distributor;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private ProductCategory productCategory;
}
