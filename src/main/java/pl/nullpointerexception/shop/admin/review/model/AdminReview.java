package pl.nullpointerexception.shop.admin.review.model;


import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "REVIEWS")
@Getter
public class AdminReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;
    private Long productId;
    private String authorName;
    private String content;
    private boolean moderated;
}
