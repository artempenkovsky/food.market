package by.teachmeskills.food.market.models;

import javax.persistence.*;
@Entity
@Table(name = "product_order")
public class ProductOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.REFRESH)
    private Order order;

    @ManyToOne(cascade = CascadeType.REFRESH)
    private Product product;

    @Column(name = "quantity")
    private Double quantity;
}
