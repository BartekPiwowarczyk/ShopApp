package pl.nullpointerexception.shop.review.controller;

import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;
import org.springframework.web.bind.annotation.*;
import pl.nullpointerexception.shop.review.controller.dto.ReviewDto;
import pl.nullpointerexception.shop.common.model.Review;
import pl.nullpointerexception.shop.review.service.ReviewService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/reviews")
    public Review addReview(@RequestBody @Valid ReviewDto reviewDto){
        return reviewService.addReview(mapToReview(reviewDto));
    }

    private Review mapToReview(ReviewDto reviewDto) {
        return Review.builder()
                .authorName(cleanContent(reviewDto.authorName()))
                .content(cleanContent(reviewDto.content()))
                .productId(reviewDto.productId())
                .build();
    }

    private String cleanContent(String text) {
        return Jsoup.clean(text, Safelist.none());
    }
}
