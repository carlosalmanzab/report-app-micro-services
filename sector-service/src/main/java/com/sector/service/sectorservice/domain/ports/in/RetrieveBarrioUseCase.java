package com.sector.service.sectorservice.domain.ports.in;

import java.util.List;
import java.util.Optional;

import com.sector.service.sectorservice.domain.models.Barrio;

public interface RetrieveBarrioUseCase {
    Optional<Barrio> getBarrioById(Long id);
    List<Barrio> getAllBarrios();
    List<Barrio> getBarriosByComunaId(Long comunaId);
}
