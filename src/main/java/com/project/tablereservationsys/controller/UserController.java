package com.project.tablereservationsys.controller;

import com.project.tablereservationsys.domain.User;
import com.project.tablereservationsys.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 사용자 등록 API
     * POST /api/users/register
     * @param user 등록할 사용자 정보
     * @return ResponseEntity<User> 생성된 사용자 정보와 함께 200 OK 응답
     */
    @PostMapping("/register")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.registerUser(user));
    }

    /**
     * 특정 사용자 조회 API
     * GET /api/users/{id}
     * @param id 조회할 사용자의 ID
     * @return ResponseEntity<User> 조회된 사용자 정보와 함께 200 OK 응답
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    /**
     * 특정 사용자 정보 업데이트 API
     * PUT /api/users/{id}
     * @param id 업데이트할 사용자의 ID
     * @param user 업데이트할 사용자 정보
     * @return ResponseEntity<User> 업데이트된 사용자 정보와 함께 200 OK 응답
     */
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        return ResponseEntity.ok(userService.updateUser(user));
    }

    /**
     * 특정 사용자 삭제 API
     * DELETE /api/users/{id}
     * @param id 삭제할 사용자의 ID
     * @return ResponseEntity<Void> 삭제 성공을 나타내는 200 OK 응답
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
