package com.project.tablereservationsys.controller;

import com.project.tablereservationsys.domain.Store;
import com.project.tablereservationsys.domain.User;
import com.project.tablereservationsys.service.StoreService;
import com.project.tablereservationsys.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stores")
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;

    @PostMapping
    public ResponseEntity<Store> createStore(@RequestBody Store store) {
        return ResponseEntity.ok(storeService.createStore(store));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Store> getStore(@PathVariable Long id) {
        return ResponseEntity.ok(storeService.getStoreById(id));
    }

    @GetMapping("/partner/{partnerId}")
    public ResponseEntity<List<Store>> getStoresByPartner(@PathVariable Long partnerId) {
        User partner = new User();
        partner.setId(partnerId);
        return ResponseEntity.ok(storeService.getStoresByPartner(partner.getId()));
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Store> updateStore(@PathVariable Long id, @RequestBody Store store) {
//        store.setId(id);
//        return ResponseEntity.ok(storeService.updateStore(store));
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStore(@PathVariable Long id) {
        storeService.deleteStore(id);
        return ResponseEntity.ok().build();
    }
}


