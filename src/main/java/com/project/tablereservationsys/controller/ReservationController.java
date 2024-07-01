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

    private final ReservationService reservationService;

    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        return ResponseEntity.ok(reservationService.createReservation(reservation));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservation(@PathVariable Long id) {
        return ResponseEntity.ok(reservationService.getReservationById(id));
    }

    @GetMapping("/store/{storeId}")
    public ResponseEntity<List<Reservation>> getReservationsByStore(@PathVariable Long storeId) {
        Store store = new Store(); // You might need to fetch the actual Store object
        store.setId(storeId);
        return ResponseEntity.ok(reservationService.getReservationsByStore(store));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Reservation>> getReservationsByUser(@PathVariable Long userId) {
        User user = new User(); // You might need to fetch the actual User object
        user.setId(userId);
        return ResponseEntity.ok(reservationService.getReservationsByUser(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable Long id, @RequestBody Reservation reservation) {
        reservation.setId(id);
        return ResponseEntity.ok(reservationService.updateReservation(reservation));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return ResponseEntity.ok().build();
    }
}