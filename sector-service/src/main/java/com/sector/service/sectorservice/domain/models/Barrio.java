package com.sector.service.sectorservice.domain.models;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Barrio {
    private Long id;
    private String nombre;
    private LocalDateTime fechaCreacion;
}
