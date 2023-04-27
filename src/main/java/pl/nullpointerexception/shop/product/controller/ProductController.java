package pl.nullpointerexception.shop.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.nullpointerexception.shop.product.model.Product;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class ProductController {

    @GetMapping("/products")
    public List<Product> getProducts() {
        return List.of(
                new Product("Product 1","Kat 1", "Opis", new BigDecimal("9.99"),"PLN"),
                new Product("Product 2","Kat 2", "Opis", new BigDecimal("19.99"),"PLN"),
                new Product("Product 3","Kat 3", "Opis", new BigDecimal("19.99"),"PLN")
        );
    }
}
