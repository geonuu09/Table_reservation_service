package com.project.tablereservationsys.service;

import com.project.tablereservationsys.domain.Store;
import com.project.tablereservationsys.domain.User;
import com.project.tablereservationsys.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;
    private final UserService userService;

    public Store createStore(Store store) {
        return storeRepository.save(store);
    }

    public Store getStoreById(Long id) {
        return storeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Store not found"));
    }

    public void deleteStore(Long id) {
        storeRepository.deleteById(id);
    }

    public List<Store> getStoresByPartner(Long partnerId) {
        User partner = userService.getUserById(partnerId);
        return storeRepository.findByPartner(partner);
    }
}

