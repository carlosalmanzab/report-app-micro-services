package com.sector.service.sectorservice.domain.ports.in;

import com.sector.service.sectorservice.domain.models.Barrio;

public interface CreateBarrioUseCase {
    Barrio createBarrio(Barrio barrio);
}
