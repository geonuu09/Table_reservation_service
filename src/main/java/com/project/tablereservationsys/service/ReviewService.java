package com.project.tablereservationsys.service;
import com.project.tablereservationsys.domain.Review;
import com.project.tablereservationsys.domain.Store;
import com.project.tablereservationsys.domain.User;
import com.project.tablereservationsys.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public Review createReview(Review review) {
        // Here you might want to add some business logic, e.g., checking if the user has a reservation
        return reviewRepository.save(review);
    }

    public Review getReviewById(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));
    }

    public List<Review> getReviewsByStore(Store store) {
        return reviewRepository.findByStore(store);
    }

    public List<Review> getReviewsByUser(User user) {
        return reviewRepository.findByUser(user);
    }

    public Review updateReview(Review review) {
        return reviewRepository.save(review);
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}