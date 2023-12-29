package com.sector.service.sectorservice.infrastructure.entities.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ComunaWithBarriosDTO {
    private Long id;
    private String nombre;
    private List<BarrioDTO> barrios;
}
