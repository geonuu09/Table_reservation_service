package com.project.tablereservationsys.repository;

import com.project.tablereservationsys.domain.Store;
import com.project.tablereservationsys.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
    List<Store> findByPartner(User partner);
}