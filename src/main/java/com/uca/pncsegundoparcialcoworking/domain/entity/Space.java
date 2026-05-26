package com.uca.pncsegundoparcialcoworking.domain.entity;

import com.uca.pncsegundoparcialcoworking.domain.enums.SpaceType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "spaces")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Space {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private SpaceType type;

    @Column(name = "capacity", nullable = false)
    private Integer capacity;

    @Column(name = "price_per_hour", nullable = false, precision = 10, scale = 2)
    private BigDecimal pricePerHour;

    @Column(name = "available")
    private Boolean available;

    @Column(name = "floor", nullable = false)
    private Integer floor;

    @Column(name = "amenities")
    private String amenities;
}
