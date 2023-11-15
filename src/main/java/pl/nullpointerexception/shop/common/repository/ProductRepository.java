package pl.nullpointerexception.shop.common.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.nullpointerexception.shop.common.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findBySlug(String slug);

    @Query("SELECT p FROM Product p LEFT JOIN Review r WHERE p.slug=:slug AND r.moderated=:moderated")
    Optional<Product> findBySlugAndModerated(String slug, Boolean moderated);

    Page<Product> findByCategoryId(Long categoryId, Pageable pageable);

    List<Product> findTop10BySalePriceIsNotNull();

}
