package com.sector.service.sectorservice.domain.ports.in;

import java.util.Optional;
import com.sector.service.sectorservice.domain.models.Comuna;

public interface UpdateComunaUseCase {
    Optional<Comuna> updateComuna(Long id, Comuna comuna);
}
