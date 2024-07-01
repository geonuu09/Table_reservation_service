package com.project.tablereservationsys.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Entity
public class User extends BaseEntity {
    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;


}
enum UserRole {
    ROLE_USER, ROLE_PARTNER
}
