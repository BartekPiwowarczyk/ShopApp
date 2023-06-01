package pl.nullpointerexception.shop.common.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.nullpointerexception.shop.common.model.Review;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="PRODUCTS")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String name;
    private Long categoryId;
    private String description;
    private String fullDescription;
    private BigDecimal price;
    private String currency;
    private String image;
    private String slug;
    @OneToMany
    @JoinColumn(name = "productId")
    List<Review> reviews;
}
