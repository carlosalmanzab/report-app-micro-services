package com.sector.service.sectorservice.domain.ports.in;

import com.sector.service.sectorservice.domain.models.Comuna;

public interface CreateComunaUseCase {
    Comuna createComuna(Comuna comuna);
}
