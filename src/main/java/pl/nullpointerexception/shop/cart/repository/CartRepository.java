package pl.nullpointerexception.shop.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pl.nullpointerexception.shop.cart.model.Cart;

import java.time.LocalDateTime;
import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Long> {
    List<Cart> findByCreatedLessThan(LocalDateTime minusDays);

    @Query("DELETE FROM Cart c WHERE c.id=:id")
    @Modifying
    void deleteCartById(Long id);

    @Query("DELETE FROM Cart c WHERE c.id IN (:ids)")
    @Modifying
    void deleteAllByIdIn(List<Long> ids);
}
