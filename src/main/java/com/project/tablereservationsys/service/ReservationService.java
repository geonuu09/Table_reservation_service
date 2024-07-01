package com.project.tablereservationsys.service;

import com.project.tablereservationsys.domain.Reservation;
import com.project.tablereservationsys.domain.Store;
import com.project.tablereservationsys.domain.User;
import com.project.tablereservationsys.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public Reservation createReservation(Reservation reservation) {

        return reservationRepository.save(reservation);
    }

    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
    }

    public List<Reservation> getReservationsByStore(Store store) {
        return reservationRepository.findByStore(store);
    }

    public List<Reservation> getReservationsByUser(User user) {
        return reservationRepository.findByUser(user);
    }

    public Reservation updateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}