package pl.nullpointerexception.shop.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pl.nullpointerexception.shop.cart.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    Long countByCartId(Long cartId);

    @Query("DELETE FROM CartItem ci WHERE ci.cartId=:cartId")
    @Modifying
    void deleteByCartId(Long cartId);

}
