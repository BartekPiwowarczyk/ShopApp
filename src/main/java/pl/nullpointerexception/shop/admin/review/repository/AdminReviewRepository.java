package pl.nullpointerexception.shop.admin.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pl.nullpointerexception.shop.admin.review.model.AdminReview;

public interface AdminReviewRepository extends JpaRepository<AdminReview,Long> {

    @Query("UPDATE AdminReview r SET r.moderated=true WHERE r.id=:id")
    @Modifying
    void moderate(Long id);

}
