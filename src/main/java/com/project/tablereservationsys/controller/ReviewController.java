package com.project.tablereservationsys.controller;

import com.project.tablereservationsys.domain.Review;
import com.project.tablereservationsys.domain.Store;
import com.project.tablereservationsys.domain.User;

import com.project.tablereservationsys.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        return ResponseEntity.ok(reviewService.createReview(review));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReview(@PathVariable Long id) {
        return ResponseEntity.ok(reviewService.getReviewById(id));
    }

    @GetMapping("/store/{storeId}")
    public ResponseEntity<List<Review>> getReviewsByStore(@PathVariable Long storeId) {
        Store store = new Store(); // You might need to fetch the actual Store object
        store.setId(storeId);
        return ResponseEntity.ok(reviewService.getReviewsByStore(store));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Review>> getReviewsByUser(@PathVariable Long userId) {
        User user = new User(); // You might need to fetch the actual User object
        user.setId(userId);
        return ResponseEntity.ok(reviewService.getReviewsByUser(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable Long id, @RequestBody Review review) {
        review.setId(id);
        return ResponseEntity.ok(reviewService.updateReview(review));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return ResponseEntity.ok().build();
    }
}