package pl.nullpointerexception.shop.product.model.dto;

import org.springframework.data.domain.Page;
import pl.nullpointerexception.shop.category.model.Category;
import pl.nullpointerexception.shop.product.model.entity.Product;

public record CategoryProductsDto(Category category, Page<Product> products) {
}
