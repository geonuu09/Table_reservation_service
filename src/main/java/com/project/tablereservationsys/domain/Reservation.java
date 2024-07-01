package com.project.tablereservationsys.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor

@Entity  // JPA 엔티티 클래스임을 표시
@Table(name = "reservations")  // 데이터베이스 테이블 이름을 지정

@Getter
@Setter
public class Reservation extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)  // 다대일 관계 설정, 지연 로딩 사용
    @JoinColumn(name = "store_id", nullable = false)  // 외래키를 가진 컬럼명 지정
    private Store store;  // 예약을 생성한 가게 정보

    @ManyToOne(fetch = FetchType.LAZY)  // 다대일 관계 설정, 지연 로딩 사용
    @JoinColumn(name = "user_id", nullable = false)  // 외래키를 가진 컬럼명 지정
    private User user;  // 예약을 생성한 사용자 정보

    @Column(name = "reservation_datetime", nullable = false)
    private LocalDateTime reservationDateTime;  // 예약 일시

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReservationStatus status;  // 예약 상태
}

enum ReservationStatus {
    PENDING, CONFIRMED, CANCELLED, COMPLETED
}
