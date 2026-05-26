package com.uca.pncsegundoparcialcoworking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpaceRequestDTO {
    private String name;
    private String description;
    private BigDecimal price;
    private Boolean available;
}

/*
*
public class PlatoRequestDTO {
    private String nombre;
    private String descripcion;
    private Double precio;
    private Boolean disponible;
}
* */
