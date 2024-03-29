package pl.nullpointerexception.shop.cart.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.nullpointerexception.shop.cart.controller.dto.CartSummaryDto;
import pl.nullpointerexception.shop.cart.controller.mapper.CartMapper;
import pl.nullpointerexception.shop.cart.model.dto.CartProductDto;
import pl.nullpointerexception.shop.cart.service.CartService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/carts")
public class CartController {

    private final CartService cartService;

    @GetMapping("/{id}")
    public CartSummaryDto getCart(@PathVariable Long id) {
        return CartMapper.mapToCartSummaryDto(cartService.getCart(id));
    }

    @PutMapping("/{id}")
    public CartSummaryDto addProductToCart(@PathVariable Long id, @RequestBody CartProductDto cartProductDto) {
        return CartMapper.mapToCartSummaryDto(cartService.addProductToCart(id, cartProductDto));
    }

    @PutMapping("/{id}/update")
    public CartSummaryDto updateCart(@PathVariable Long id, @RequestBody List<CartProductDto> cartProductDtos) {
        return CartMapper.mapToCartSummaryDto(cartService.updateCart(id, cartProductDtos));
    }
}
