package com.project.tablereservationsys.controller;

import com.project.tablereservationsys.domain.Store;
import com.project.tablereservationsys.domain.User;
import com.project.tablereservationsys.service.UserService;
import com.project.tablereservationsys.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stores")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService; // StoreService 의존성 주입
    private final UserService userService;
    /**
     * 상점 생성 API
     * POST /api/stores
     * @param store 생성할 상점 정보
     * @return ResponseEntity<Store> 생성된 상점 정보와 함께 200 OK 응답
     */
    @PostMapping("registration")
    @PreAuthorize("hasRole('ROLE_PARTNER')")
    public ResponseEntity<Store> createStore(@RequestBody Store store, Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User user = userService.getUserByUsername(userDetails.getUsername());
        store.setPartner(user);
        return ResponseEntity.ok(storeService.createStore(store));
    }

    /**
     * 상점 조회 API
     * GET /api/stores/{id}
     * @param id 조회할 상점의 ID
     * @return ResponseEntity<Store> 조회된 상점 정보와 함께 200 OK 응답
     */
    @GetMapping("/{id}")
    public ResponseEntity<Store> getStore(@PathVariable Long id) {
        return ResponseEntity.ok(storeService.getStoreById(id));
    }

    /**
     * 특정 파트너의 상점 목록 조회 API
     * GET /api/stores/partner/{partnerId}
     * @param partnerId 조회할 파트너의 ID
     * @return ResponseEntity<List<Store>> 조회된 상점 목록과 함께 200 OK 응답
     */
    @GetMapping("/partner/{partnerId}")
    public ResponseEntity<List<Store>> getStoresByPartner(@PathVariable Long partnerId) {
        User partner = new User();
        partner.setId(partnerId);
        return ResponseEntity.ok(storeService.getStoresByPartner(partner.getId()));
    }

    /**
     * 상점 삭제 API
     * DELETE /api/stores/{id}
     * @param id 삭제할 상점의 ID
     * @return ResponseEntity<Void> 삭제 성공을 나타내는 200 OK 응답
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStore(@PathVariable Long id) {
        storeService.deleteStore(id);
        return ResponseEntity.ok().build();
    }
}
