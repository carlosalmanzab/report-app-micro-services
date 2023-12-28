package com.sector.service.sectorservice.domain.ports.in;

import java.util.List;
import java.util.Optional;
import com.sector.service.sectorservice.domain.models.Comuna;

public interface RetrieveComunaUseCase {
    Optional<Comuna> getComunaById(Long id);
    List<Comuna> getAllComunas();
}
