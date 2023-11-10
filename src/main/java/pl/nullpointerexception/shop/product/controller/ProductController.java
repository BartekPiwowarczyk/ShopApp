package pl.nullpointerexception.shop.product.controller;

import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.nullpointerexception.shop.common.dto.ProductListDto;
import pl.nullpointerexception.shop.common.model.Product;
import pl.nullpointerexception.shop.product.service.ProductService;
import pl.nullpointerexception.shop.product.service.dto.ProductDto;

import javax.validation.constraints.Pattern;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
public class ProductController {


    private final ProductService productService;

    @GetMapping("/products")
    public Page<ProductListDto> getProducts(Pageable pageable) {
        Page<Product> products = productService.getProducts(pageable);
        List<ProductListDto> productListDtos = products.getContent().stream()
                .map(product -> ProductListDto.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .description(product.getDescription())
                        .image(product.getImage())
                        .price(product.getPrice())
                        .salePrice(product.getSalePrice())
                        .currency(product.getCurrency())
                        .slug(product.getSlug())
                        .build()).toList();
        return new PageImpl<>(productListDtos,pageable,products.getTotalElements());
    }

    @Cacheable("productBySlug")
    @GetMapping("/products/{slug}")
    public ProductDto getProduct(@PathVariable
                                  @Pattern(regexp = "[a-z0-9\\-]+")
                                  @Length(max=255)
                                  String slug) {
        return productService.getProductBySlug(slug);
    }
}
