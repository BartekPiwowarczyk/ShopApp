package pl.nullpointerexception.shop.admin.product.model;


import lombok.Getter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "PRODUCTS")
@Getter
public class AdminProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String name;
    private String category;
    private String description;
    private BigDecimal price;
    private String currency;
}

