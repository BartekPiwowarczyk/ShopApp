package pl.nullpointerexception.shop.admin.review.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.nullpointerexception.shop.admin.review.model.AdminReview;
import pl.nullpointerexception.shop.admin.review.repository.AdminReviewRepository;

import javax.transaction.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminReviewService {

    private final AdminReviewRepository reviewRepository;

    public List<AdminReview> getReviews() {
        return reviewRepository.findAll();
    }
    @Transactional
    public void moderate(Long id) {
        reviewRepository.moderate(id);
    }
    public void delete(Long id) {
        reviewRepository.deleteById(id);
    }

}
