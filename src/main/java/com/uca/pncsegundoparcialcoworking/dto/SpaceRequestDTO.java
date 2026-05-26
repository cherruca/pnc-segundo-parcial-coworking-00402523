package com.uca.pncsegundoparcialcoworking.dto;

import com.uca.pncsegundoparcialcoworking.domain.enums.SpaceType;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class SpaceRequestDTO {

    @NotBlank(message = "El nombre es requerido y no puede estar vacío")
    private String name;

    private String description;

    @NotNull(message = "El tipo es requerido")
    private SpaceType type;

    @NotNull(message = "La capacidad es requerida")
    @Min(value = 1, message = "La capacidad debe ser de al menos 1 persona")
    private Integer capacity;

    @NotNull(message = "El precio por hora es requerido")
    @Positive(message = "El precio debe ser mayor a 0")
    private BigDecimal pricePerHour;

    private Boolean available = true;

    @NotNull(message = "El piso es requerido")
    @Min(value = 0, message = "El piso no puede ser negativo")
    private Integer floor;

    private String amenities;
}
