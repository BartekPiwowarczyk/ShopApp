package pl.nullpointerexception.shop.product.service.dto;

import lombok.Builder;
import lombok.Getter;
import java.util.List;

import java.math.BigDecimal;

@Getter
@Builder
public class ProductDto {
    private Long id;
    private String name;
    private Long categoryId;
    private String description;
    private String fullDescription;
    private BigDecimal price;
    private BigDecimal salePrice;
    private String currency;
    private String image;
    private String slug;
    private List<ReviewDto> reviews;
}
