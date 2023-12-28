package com.sector.service.sectorservice.domain.ports.in;

import java.util.Optional;

import com.sector.service.sectorservice.domain.models.Barrio;

public interface UpdateBarrioUseCase {
    Optional<Barrio> updateBarrio(Long id, Barrio barrio);
}
