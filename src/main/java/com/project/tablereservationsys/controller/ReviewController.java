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

    private final ReviewService reviewService; // ReviewService 의존성 주입

    /**
     * 리뷰 생성 API
     * POST /api/reviews
     * @param review 생성할 리뷰 정보
     * @return ResponseEntity<Review> 생성된 리뷰 정보와 함께 200 OK 응답
     */
    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        return ResponseEntity.ok(reviewService.createReview(review));
    }

    /**
     * 리뷰 조회 API
     * GET /api/reviews/{id}
     * @param id 조회할 리뷰의 ID
     * @return ResponseEntity<Review> 조회된 리뷰 정보와 함께 200 OK 응답
     */
    @GetMapping("/{id}")
    public ResponseEntity<Review> getReview(@PathVariable Long id) {
        return ResponseEntity.ok(reviewService.getReviewById(id));
    }

    /**
     * 특정 상점의 리뷰 목록 조회 API
     * GET /api/reviews/store/{storeId}
     * @param storeId 조회할 상점의 ID
     * @return ResponseEntity<List<Review>> 조회된 리뷰 목록과 함께 200 OK 응답
     */
    @GetMapping("/store/{storeId}")
    public ResponseEntity<List<Review>> getReviewsByStore(@PathVariable Long storeId) {
        Store store = new Store(); // 실제 Store 객체를 가져와야 할 수 있음
        store.setId(storeId);
        return ResponseEntity.ok(reviewService.getReviewsByStore(store));
    }

    /**
     * 특정 사용자의 리뷰 목록 조회 API
     * GET /api/reviews/user/{userId}
     * @param userId 조회할 사용자의 ID
     * @return ResponseEntity<List<Review>> 조회된 리뷰 목록과 함께 200 OK 응답
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Review>> getReviewsByUser(@PathVariable Long userId) {
        User user = new User(); // 실제 User 객체를 가져와야 할 수 있음
        user.setId(userId);
        return ResponseEntity.ok(reviewService.getReviewsByUser(user));
    }

    /**
     * 리뷰 업데이트 API
     * PUT /api/reviews/{id}
     * @param id 업데이트할 리뷰의 ID
     * @param review 업데이트할 리뷰 정보
     * @return ResponseEntity<Review> 업데이트된 리뷰 정보와 함께 200 OK 응답
     */
    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable Long id, @RequestBody Review review) {
        review.setId(id);
        return ResponseEntity.ok(reviewService.updateReview(review));
    }

    /**
     * 리뷰 삭제 API
     * DELETE /api/reviews/{id}
     * @param id 삭제할 리뷰의 ID
     * @return ResponseEntity<Void> 삭제 성공을 나타내는 200 OK 응답
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return ResponseEntity.ok().build();
    }
}
