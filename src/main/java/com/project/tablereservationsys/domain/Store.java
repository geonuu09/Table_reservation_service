package com.project.tablereservationsys.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "stores")
@Getter
@Setter
public class Store extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "partner_id", nullable = false)
    private User partner;
}