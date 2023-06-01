package pl.nullpointerexception.shop.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.nullpointerexception.shop.common.model.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {
//    @Query("SELECT c FROM Category c left join fetch c.products WHERE c.slug=:slug")
    Category findBySlug(String slug);
}
