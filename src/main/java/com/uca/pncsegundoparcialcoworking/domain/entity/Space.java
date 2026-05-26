package com.uca.pncsegundoparcialcoworking.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "space")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Space {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;
//    private Enum

    @Column(name = "capacity", nullable = false)
    @Min(value = 1, message = "La capacidad debe ser mayor o igual a 1")
    private Integer capacity;

    @Column(name = "price", nullable = false)
    @Min(value = 0, message = "Debe ingresar una cantidad mayor o igual a 0")
    private BigDecimal price;

    @Column(name = "available", nullable = false)
    private Boolean available;

    @Column(name = "floor", nullable = false)
    @Min(value = 0, message = "Debe ingresar una cantidad mayor o igual a 0")
    private Integer floor;

    @Column(name = "price")
    private String amenities;
}
