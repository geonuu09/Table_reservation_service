package com.project.tablereservationsys.controller;

import com.project.tablereservationsys.domain.Reservation;
import com.project.tablereservationsys.domain.Store;
import com.project.tablereservationsys.domain.User;
import com.project.tablereservationsys.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService; // ReservationService 의존성 주입

    /**
     * 예약 생성 API
     * POST /api/reservations
     * @param reservation 생성할 예약 정보
     * @return ResponseEntity<Reservation> 생성된 예약 정보와 함께 200 OK 응답
     */
    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        return ResponseEntity.ok(reservationService.createReservation(reservation));
    }

    /**
     * 예약 조회 API
     * GET /api/reservations/{id}
     * @param id 조회할 예약의 ID
     * @return ResponseEntity<Reservation> 조회된 예약 정보와 함께 200 OK 응답
     */
    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservation(@PathVariable Long id) {
        return ResponseEntity.ok(reservationService.getReservationById(id));
    }

    /**
     * 특정 상점의 예약 목록 조회 API
     * GET /api/reservations/store/{storeId}
     * @param storeId 조회할 상점의 ID
     * @return ResponseEntity<List<Reservation>> 조회된 예약 목록과 함께 200 OK 응답
     */
    @GetMapping("/store/{storeId}")
    public ResponseEntity<List<Reservation>> getReservationsByStore(@PathVariable Long storeId) {
        Store store = new Store(); // 실제 Store 객체를 가져와야 할 수 있음
        store.setId(storeId);
        return ResponseEntity.ok(reservationService.getReservationsByStore(store));
    }

    /**
     * 특정 사용자의 예약 목록 조회 API
     * GET /api/reservations/user/{userId}
     * @param userId 조회할 사용자의 ID
     * @return ResponseEntity<List<Reservation>> 조회된 예약 목록과 함께 200 OK 응답
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Reservation>> getReservationsByUser(@PathVariable Long userId) {
        User user = new User(); // 실제 User 객체를 가져와야 할 수 있음
        user.setId(userId);
        return ResponseEntity.ok(reservationService.getReservationsByUser(user));
    }

    /**
     * 예약 업데이트 API
     * PUT /api/reservations/{id}
     * @param id 업데이트할 예약의 ID
     * @param reservation 업데이트할 예약 정보
     * @return ResponseEntity<Reservation> 업데이트된 예약 정보와 함께 200 OK 응답
     */
    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable Long id, @RequestBody Reservation reservation) {
        reservation.setId(id);
        return ResponseEntity.ok(reservationService.updateReservation(reservation));
    }

    /**
     * 예약 삭제 API
     * DELETE /api/reservations/{id}
     * @param id 삭제할 예약의 ID
     * @return ResponseEntity<Void> 삭제 성공을 나타내는 200 OK 응답
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return ResponseEntity.ok().build();
    }
}