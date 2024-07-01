package com.project.tablereservationsys.repository;

import com.project.tablereservationsys.domain.Reservation;
import com.project.tablereservationsys.domain.Store;
import com.project.tablereservationsys.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByStore(Store store);
    List<Reservation> findByUser(User user);
}